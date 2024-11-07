package g5.hotelreservationwebapp.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "customer_room_reservation_payment")
public class CustomerRoomReservationPayment extends BaseEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_room_reservation_id", nullable = false)
    private CustomerRoomReservation customerRoomReservation;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "is_refund", nullable = false)
    private Boolean isRefund = false;

    @Column(name = "is_transaction_closed")
    private Boolean isTransactionClosed;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CustomerRoomReservationPayment that = (CustomerRoomReservationPayment) o;
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
                "transactionId = " + getTransactionId() + ", " +
                "isRefund = " + getIsRefund() + ", " +
                "isTransactionClosed = " + getIsTransactionClosed() + ", " +
                "dateCreate = " + getDateCreate() + ", " +
                "dateUpdate = " + getDateUpdate() + ", " +
                "createdByMember = " + getCreatedByMember() + ", " +
                "updatedByMember = " + getUpdatedByMember() + ", " +
                "isDeleted = " + getIsDeleted() + ")";
    }
}