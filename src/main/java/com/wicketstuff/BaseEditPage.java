package com.wicketstuff;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BaseEditPage extends WebPage {
    protected Form form;
    public BaseEditPage(final PageParameters parameters) {
        super(parameters);
        WebMarkupContainer parentForm = new WebMarkupContainer("parentForm");
        add(parentForm);
        parentForm.add(form = new Form("form"));
    }
    @Override
    protected void onInitialize() {
        super.onInitialize();
    }
}