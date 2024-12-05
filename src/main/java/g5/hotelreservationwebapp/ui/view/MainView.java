package g5.hotelreservationwebapp.ui.view;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.ui.dialog.HomeDialog;
import g5.hotelreservationwebapp.ui.layout.MainAppLayout;


@Route(value = "", layout = MainAppLayout.class)
public class MainView extends VerticalLayout {


    public MainView() {
        addClassName("main-view");

        add(new HomeDialog());
    }


}
