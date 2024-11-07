package g5.hotelreservationwebapp.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "date_create", nullable = false, updatable = false)
    @CreationTimestamp
    private Instant dateCreate;

    @Column(name = "date_update", nullable = false)
    @UpdateTimestamp
    private Instant dateUpdate;

    @Column(name = "created_by_member_id", nullable = false)
    private UUID createdByMember;

    @Column(name = "updated_by_member_id", nullable = false)
    private UUID updatedByMember;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

}