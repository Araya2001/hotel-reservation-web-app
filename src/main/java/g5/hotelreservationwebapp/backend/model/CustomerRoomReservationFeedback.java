package g5.hotelreservationwebapp.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "customer_room_reservation_feedback")
public class CustomerRoomReservationFeedback extends BaseEntity {
    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "customer_room_reservation_id", nullable = false)
    private CustomerRoomReservation customerRoomReservation;

    @Column(name = "feedback", length = 1024)
    private String feedback;

    @Column(name = "rating_value", nullable = false)
    private Integer ratingValue;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CustomerRoomReservationFeedback that = (CustomerRoomReservationFeedback) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "customerRoomReservation = " + getCustomerRoomReservation() + ", " +
                "feedback = " + getFeedback() + ", " +
                "ratingValue = " + getRatingValue() + ", " +
                "dateCreate = " + getDateCreate() + ", " +
                "dateUpdate = " + getDateUpdate() + ", " +
                "isDeleted = " + getIsDeleted() + ")";
    }
}