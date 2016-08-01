package com.simbirsoft.java.vaadin.demo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * @author Vadim Starichkov
 * @since 7/29/16 6:17 PM
 */
public class FullHeightView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "full";

    public FullHeightView() {
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> addComponent(new Label("Thanks " + name.getValue() + ", it works!")));

        addComponents(name, button);
        setMargin(true);
        setSpacing(true);

        Grid grid = new Grid("Sample grid");
        grid.setSizeFull();
        grid.addColumn("Column 1");
        grid.addColumn("Column 2");
        for (int i = 0; i < 100; i++) {
            grid.addRow("Column #", String.valueOf(i));
        }

        addComponent(grid);
        setExpandRatio(grid, 1f);
        setSizeFull();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
