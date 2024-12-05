package g5.hotelreservationwebapp.ui.grid;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.RoomDetails;
import g5.hotelreservationwebapp.backend.service.RoomDetailsService;
import g5.hotelreservationwebapp.backend.service.RoomService;
import g5.hotelreservationwebapp.ui.form.RoomDetailsForm;
import g5.hotelreservationwebapp.ui.layout.MainAppLayout;

@Route(value = "room-details-grid", layout = MainAppLayout.class)
public class RoomDetailsGrid extends BaseEntityGrid<RoomDetails> {

    public RoomDetailsGrid(RoomDetailsService roomDetailsService, RoomService roomService) {
        super(
                new Grid<>(RoomDetails.class, true),
                new RoomDetailsForm(roomDetailsService, roomService),
                roomDetailsService,
                "Room Details Table"
        );

        super.fillGrid();
    }
}