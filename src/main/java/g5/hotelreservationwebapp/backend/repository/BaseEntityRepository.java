package g5.hotelreservationwebapp.backend.repository;

import g5.hotelreservationwebapp.backend.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseEntityRepository<Model extends BaseEntity> extends JpaRepository<Model, UUID>, JpaSpecificationExecutor<Model> {
    Optional<Model> findByIdAndIsDeletedFalse(UUID id);

    List<Model> findAllByIsDeletedFalse();
}