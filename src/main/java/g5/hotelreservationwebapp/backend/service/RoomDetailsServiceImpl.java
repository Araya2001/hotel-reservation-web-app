package g5.hotelreservationwebapp.backend.service;

import g5.hotelreservationwebapp.backend.model.RoomDetails;
import g5.hotelreservationwebapp.backend.repository.RoomDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomDetailsServiceImpl extends AbstractBaseEntityServiceImpl<RoomDetails> implements RoomDetailsService {
    private final RoomDetailsRepository roomDetailsRepository;

    @Autowired
    public RoomDetailsServiceImpl(RoomDetailsRepository roomDetailsRepository) {
        super(roomDetailsRepository);
        this.roomDetailsRepository = roomDetailsRepository;
    }

}