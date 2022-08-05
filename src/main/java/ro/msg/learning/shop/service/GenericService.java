package ro.msg.learning.shop.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface GenericService<Entity, Repository extends PagingAndSortingRepository<Entity, Long>> {
    Entity create(Entity entity);

    List<Entity> getAll();

    Entity getById(Long id);

    void delete(Long id);

    Entity update(Long id, Entity newEntity);
}
