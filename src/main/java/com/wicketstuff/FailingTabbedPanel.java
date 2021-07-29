package com.wicketstuff;

import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.list.Loop;
import org.apache.wicket.markup.html.list.LoopItem;

import java.util.List;

public class FailingTabbedPanel extends TabbedPanel<ITab> {
    private WebMarkupContainer tabsContainer;
    public FailingTabbedPanel(final String id, List<ITab> tabs) {
        super(id, tabs);
        tabsContainer = (WebMarkupContainer) new WebMarkupContainer("tabs-container-parent").setOutputMarkupId(true);
        tabsContainer.add(FailingTabbedPanel.this.get("tabs-container"));
        add(tabsContainer);
        WebMarkupContainer panelContainer = new WebMarkupContainer("tabpanels-container");
        add(panelContainer);
        panelContainer.add(new Loop("panels", tabs.size()) {
            @Override
            protected void populateItem(LoopItem item) {
                int index = item.getIndex();
                boolean visible = getSelectedTab() == index;
                WebMarkupContainer panel = getTabs().get(index).getPanel(TAB_PANEL_ID);
                panel.setOutputMarkupPlaceholderTag(true);
                item.add(panel);
            }
        });
        setSelectedTab(0);
    }
}
