package g5.hotelreservationwebapp.ui.grid;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservation;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationService;
import g5.hotelreservationwebapp.backend.service.CustomerService;
import g5.hotelreservationwebapp.backend.service.RoomService;
import g5.hotelreservationwebapp.ui.form.CustomerRoomReservationForm;
import g5.hotelreservationwebapp.ui.layout.MainAppLayout;

@Route(value = "customer-room-reservation-grid", layout = MainAppLayout.class)
public class CustomerRoomReservationGrid extends BaseEntityGrid<CustomerRoomReservation> {

    public CustomerRoomReservationGrid(CustomerRoomReservationService customerRoomReservationService, CustomerService customerService,
                                       RoomService roomService) {
        super(
                new Grid<>(CustomerRoomReservation.class, true),
                new CustomerRoomReservationForm(customerRoomReservationService, customerService, roomService),
                customerRoomReservationService,
                "Customer Room Reservation Table"
        );

        super.fillGrid();
    }
}