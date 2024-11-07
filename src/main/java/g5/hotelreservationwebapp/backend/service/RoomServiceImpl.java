package g5.hotelreservationwebapp.backend.service;

import g5.hotelreservationwebapp.backend.model.Room;
import g5.hotelreservationwebapp.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends AbstractBaseEntityServiceImpl<Room> implements RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        super(roomRepository);
        this.roomRepository = roomRepository;
    }

}