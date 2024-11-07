package g5.hotelreservationwebapp.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer_feedback")
public class CustomerFeedback extends BaseEntity {
}