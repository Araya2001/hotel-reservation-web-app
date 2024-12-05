package g5.hotelreservationwebapp.ui.grid;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.Room;
import g5.hotelreservationwebapp.backend.service.RoomService;
import g5.hotelreservationwebapp.ui.form.RoomForm;
import g5.hotelreservationwebapp.ui.layout.MainAppLayout;

@Route(value = "room-grid", layout = MainAppLayout.class)
public class RoomGrid extends BaseEntityGrid<Room> {

    public RoomGrid(RoomService roomService) {
        super(
                new Grid<>(Room.class, true),
                new RoomForm(roomService),
                roomService,
                "Room Table"
        );

        super.fillGrid();
    }
}