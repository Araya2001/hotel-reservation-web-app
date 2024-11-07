package g5.hotelreservationwebapp.backend.service;

import g5.hotelreservationwebapp.backend.model.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseEntityService<Model extends BaseEntity> {
    Model save(Model entity);

    List<Model> saveAll(List<Model> entities);

    Model update(Model entity);

    List<Model> updateAll(List<Model> entities);

    Boolean hardDelete(Model entity);

    Boolean hardDeleteAll(List<Model> entities);

    Optional<Model> getByUUID(UUID uuid);

    List<Model> findAll();

    Boolean softDelete(Model entity);

    Boolean softDeleteAll(List<Model> entities);
}
