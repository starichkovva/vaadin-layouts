package com.simbirsoft.java.vaadin.demo;

import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

/**
 * @author Vadim Starichkov
 * @since 7/29/16 7:38 PM
 */
public class FormLayoutView extends Panel implements View {
    public static final String VIEW_NAME = "form";

    public FormLayoutView() {
        FormLayout formLayout = new FormLayout();
        formLayout.setMargin(true);
        formLayout.setSpacing(true);

        TextField tf1 = new TextField("Name");
        tf1.setIcon(FontAwesome.USER);
        tf1.setRequired(true);
        tf1.addValidator(new NullValidator("Must be given", false));
        formLayout.addComponent(tf1);

        TextField tf2 = new TextField("Street address");
        tf2.setIcon(FontAwesome.HOME);
        formLayout.addComponent(tf2);

        TextField tf3 = new TextField("Postal code");
        tf3.setIcon(FontAwesome.ENVELOPE);
        tf3.addValidator(new IntegerRangeValidator("Doh!", 1, 99999));
        formLayout.addComponent(tf3);

        setCaption("FormLayout inside Panel");
        setContent(formLayout);
        setSizeUndefined();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
