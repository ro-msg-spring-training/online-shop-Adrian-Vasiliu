package ro.msg.learning.shop.services;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface GenericService<Entity, Repository extends PagingAndSortingRepository<Entity, Long>> {
    void create(Entity entity);

    List<Entity> getAll();

    Entity getById(Long id);

    void delete(Long id);
}
