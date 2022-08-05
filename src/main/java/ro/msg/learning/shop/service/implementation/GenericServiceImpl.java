package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import ro.msg.learning.shop.exception.NotFoundException;
import ro.msg.learning.shop.service.GenericService;

import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<Entity, Repository extends PagingAndSortingRepository<Entity, Long>>
        implements GenericService<Entity, Repository> {

    protected Repository repository;
    private final String notFoundMessage = "Entity not found!";

    public GenericServiceImpl(@Autowired Repository repository) {

        this.repository = repository;
    }

    @Override
    public Entity create(Entity entity) {
        return repository.save(entity);
    }

    public List<Entity> getAll() {
        return (List<Entity>) this.repository.findAll();
    }

    public Entity getById(Long id) {
        Optional<Entity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            return optionalEntity.get();
        }
        throw new NotFoundException(notFoundMessage);
    }

    public Entity update(Long id, Entity newEntity) {
        Optional<Entity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            return repository.save(newEntity);
        } else throw new NotFoundException(notFoundMessage);
    }

    public void delete(Long id) {
        Optional<Entity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            repository.deleteById(id);
        } else throw new NotFoundException(notFoundMessage);
    }

}
