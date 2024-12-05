package g5.hotelreservationwebapp.ui.grid;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservationDetails;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationDetailsService;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationService;
import g5.hotelreservationwebapp.ui.form.CustomerRoomReservationDetailsForm;
import g5.hotelreservationwebapp.ui.layout.MainAppLayout;

@Route(value = "customer-room-reservation-details-grid", layout = MainAppLayout.class)
public class CustomerRoomReservationDetailsGrid extends BaseEntityGrid<CustomerRoomReservationDetails> {

    public CustomerRoomReservationDetailsGrid(CustomerRoomReservationDetailsService customerRoomReservationDetailsService,
                                              CustomerRoomReservationService customerRoomReservationService) {
        super(
                new Grid<>(CustomerRoomReservationDetails.class, true),
                new CustomerRoomReservationDetailsForm(customerRoomReservationDetailsService, customerRoomReservationService),
                customerRoomReservationDetailsService,
                "Customer Room Reservation Details Table"
        );

        super.fillGrid();
    }
}