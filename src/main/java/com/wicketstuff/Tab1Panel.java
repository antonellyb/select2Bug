package com.wicketstuff;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.select2.Select2Choice;

public class Tab1Panel extends Panel {
    public Tab1Panel(Select2Choice<DictionaryBase> select2Choice) {
        super("panel");
        add(select2Choice);
    }
}
