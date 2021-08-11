package com.wicketstuff;

import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
        List<DictionaryBase> choiceList = new ArrayList<DictionaryBase>();
        choiceList.add(new DictionaryBase(1L,"First choice"));
		choiceList.add(new DictionaryBase(2L,"Second Choice"));
		choiceList.add(new DictionaryBase(3L,"Third Choice"));
		choiceList.add(new DictionaryBase(4L,"Fourth Choice"));
		choiceList.add(new DictionaryBase(5L,"Fifth Choice"));

		Select2Choice<DictionaryBase> dropDownChoiceWorking = new Select2Choice<DictionaryBase>("choice", null, new DictionaryBaseProvider(choiceList,"project"));
		dropDownChoiceWorking.getSettings().setMinimumInputLength(0);
		dropDownChoiceWorking.setRequired(false);
		dropDownChoiceWorking.getSettings().setWidth("200px");
		add(dropDownChoiceWorking);

		List<ITab> tabs = new ArrayList<>();
		tabs.add(new Tab("Tab 1", new Tab1Panel()));
		tabs.add(new Tab("Tab 2", new Tab2Panel()));
		add(new FailingTabbedPanel("tabs", tabs));




		//If I use new TabbedPanel instead of FailingTabbedPanel then SELECT2 works correctly
		//form.add(new TabbedPanel("tabs", tabs));

		// TODO Add your page's components here

    }
	public class DictionaryBaseProvider extends ChoiceProvider<DictionaryBase> {

		List<DictionaryBase> selectList;
		String propertyName;

		public DictionaryBaseProvider(List<DictionaryBase> selectList, String propertyName) {
			this.selectList = selectList;
			this.propertyName = propertyName;
		}

		private List<DictionaryBase> queryMatches(String term, int page, int pageSize) {

			List<DictionaryBase> result = new ArrayList<DictionaryBase>();

			term = term.toUpperCase();

			final int offset = page * pageSize;

			int matched = 0;
			for (DictionaryBase listItem : selectList) {
				if (result.size() == pageSize) {
					break;
				}

				if (listItem.getName().toUpperCase().contains(term)) {
					matched++;
					if (matched > offset) {
						result.add(listItem);
					}
				}
			}
			return result;
		}

		@Override
		public String getDisplayValue(DictionaryBase choice) {
			return choice.getName();
		}

		@Override
		public String getIdValue(DictionaryBase choice) {
			return choice.getId().toString();
		}

		@Override
		public void query(String term, int page, Response<DictionaryBase> response) {
			response.addAll(this.queryMatches(term, page, 10));
			response.setHasMore(response.size() == 10);
		}

		@Override
		public Collection<DictionaryBase> toChoices(Collection<String> ids) {
			System.out.println("Getting choice forn ids==" + ids.toString());
			ArrayList<DictionaryBase> result = new ArrayList<DictionaryBase>();
			for (String id : ids) {
				for(DictionaryBase row : selectList) {
					System.out.println("Checking==" + row.getName());
					if (row.getId().toString().equals(id)) {
						result.add(row);
						System.out.println("Added " + row.getName());
					}
				}
			}
			return result;
		}
	}
}
