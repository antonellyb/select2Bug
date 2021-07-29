package com.wicketstuff;

import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class Tab extends AbstractTab {
    private Panel panel;
    private Form formToSubmitOnTabChange;

    public Tab(IModel<String> title) {
        super(title);
    }

    public Tab(IModel<String> title, Panel panel) {
        super(title);
        this.panel = panel;
    }

    public Tab(String title, Panel panel) {
        super(new Model<String>(title));
        this.panel = panel;
    }

    public Tab(IModel<String> title, Form formToSubmitOnTabChange) {
        super(title);
        this.formToSubmitOnTabChange = formToSubmitOnTabChange;
    }

    public Tab(String title, Panel panel, Form formToSubmitOnTabChange) {
        super(new Model<String>(title));
        this.panel = panel;
        this.formToSubmitOnTabChange = formToSubmitOnTabChange;
    }

    @Override
    public Panel getPanel(String panelId) {
        return panel != null ? panel : null;
    }

    public Panel getPanel() {
        return panel != null ? panel : null;
    }
}