package ro.msg.learning.shop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import ro.msg.learning.shop.exceptions.NotFoundException;
import ro.msg.learning.shop.services.GenericService;

import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<Entity, Repository extends PagingAndSortingRepository<Entity, Long>>
        implements GenericService<Entity, Repository> {

    protected Repository repository;

    public GenericServiceImpl(@Autowired Repository repository) {

        this.repository = repository;
    }

    @Override
    public void create(Entity entity) {
        repository.save(entity);
    }

    public List<Entity> getAll() {
        return (List<Entity>) this.repository.findAll();
    }

    public Entity getById(Long id) {
        Optional<Entity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            return optionalEntity.get();
        }
        throw new NotFoundException("Entity not found!");
    }

    public void delete(Long id) {
        Optional<Entity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException("Entity not found!");
    }

}
