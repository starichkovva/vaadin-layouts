package com.simbirsoft.java.vaadin.demo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

/**
 * @author Vadim Starichkov
 * @since 7/29/16 6:31 PM
 */
public class GridLayoutView extends GridLayout implements View {
    private static final int ROWS = 4;
    private static final int COLUMNS = 4;
    public static final String VIEW_NAME = "grid";

    public GridLayoutView() {
        super(COLUMNS, ROWS);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                addComponent(new Label("Label " + i + "" + j));
            }
        }
        setSpacing(true);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome to Grid Layout!");
    }
}
