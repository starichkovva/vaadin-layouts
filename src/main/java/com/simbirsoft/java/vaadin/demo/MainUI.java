package com.simbirsoft.java.vaadin.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * @author Vadim Starichkov
 * @since 7/29/16 7:19 PM
 */
@Theme("mytheme")
@Widgetset("com.simbirsoft.java.vaadin.MyAppWidgetset")
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Navigation Example");

        String[] pages = {FullHeightView.VIEW_NAME, GridLayoutView.VIEW_NAME, FormLayoutView.VIEW_NAME};

        VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.setMargin(true);
        contentLayout.setSizeFull();

        // Create a navigator to control the views
        Navigator navigator = new Navigator(this, contentLayout);

        navigator.addView("", FullHeightView.class);
        navigator.addView(FullHeightView.VIEW_NAME, FullHeightView.class);
        navigator.addView(GridLayoutView.VIEW_NAME, GridLayoutView.class);
        navigator.addView(FormLayoutView.VIEW_NAME, FormLayoutView.class);

        MenuBar menuBar = new MenuBar();
        for (String page : pages) {
            menuBar.addItem(page, (MenuBar.Command) selectedItem -> navigator.navigateTo(selectedItem.getText()));
        }

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.addComponent(menuBar);
        mainLayout.addComponent(contentLayout);
        mainLayout.setExpandRatio(contentLayout, 1f);
        mainLayout.setSizeFull();
        setContent(mainLayout);

    }

    @WebServlet(urlPatterns = "/*", name = "MainUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MainUIServlet extends VaadinServlet {
    }
}
