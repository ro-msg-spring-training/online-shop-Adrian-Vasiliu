package ro.msg.learning.shop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.Stock;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.services.StockService;

@Service
public class StockServiceImpl extends GenericServiceImpl<Stock, StockRepository> implements StockService {

    @Autowired
    public StockServiceImpl(StockRepository repository) {
        super(repository);
    }
}
