package g5.hotelreservationwebapp.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "room_details")
public class RoomDetails extends BaseEntity {