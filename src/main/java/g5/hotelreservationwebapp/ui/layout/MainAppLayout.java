package g5.hotelreservationwebapp.ui.layout;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import g5.hotelreservationwebapp.ui.grid.*;
import g5.hotelreservationwebapp.ui.view.MainView;


@Route("main-app-layout")
public class MainAppLayout extends AppLayout {

    private final DrawerToggle drawerToggle = new DrawerToggle();

    public MainAppLayout() {
        createHeader();
    }

    private void createHeader() {
        // Set the logo for the web page
        H1 logo = new H1("Hotel Reservation");
        logo.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");
        logo.addClassName("logo");

        // Add links to drawer
        addToDrawer(createRouterLinkVerticalLayout());

        // Add Components to the Navigation Bar
        addToNavbar(drawerToggle, logo);
    }

    private VerticalLayout createRouterLinkVerticalLayout() {
        // Create Router Links for the drawer
        RouterLink mainView = new RouterLink("Main View", MainView.class);
        RouterLink customerContactLink = new RouterLink("Customer Contact Table", CustomerContactGrid.class);
        RouterLink customerLink = new RouterLink("Customer Table", CustomerGrid.class);
        RouterLink customerRoomReservationDetailsLink = new RouterLink("Customer Room Reservation Details Table", CustomerRoomReservationDetailsGrid.class);
        RouterLink customerRoomReservationFeedbackLink = new RouterLink("Customer Room Reservation Feedback Table", CustomerRoomReservationFeedbackGrid.class);
        RouterLink customerRoomReservationLink = new RouterLink("Customer Room Reservation Table", CustomerRoomReservationGrid.class);
        RouterLink customerRoomReservationPaymentLink = new RouterLink("Customer Room Reservation Payment Table", CustomerRoomReservationPaymentGrid.class);
        RouterLink roomDetailsLink = new RouterLink("Room Details Table", RoomDetailsGrid.class);
        RouterLink roomLink = new RouterLink("Room Table", RoomGrid.class);

        // Add Router Links to Vertical Layout
        return new VerticalLayout(
                mainView,
                roomLink,
                roomDetailsLink,
                customerLink,
                customerContactLink,
                customerRoomReservationLink,
                customerRoomReservationPaymentLink,
                customerRoomReservationDetailsLink,
                customerRoomReservationFeedbackLink
        );
    }
}
