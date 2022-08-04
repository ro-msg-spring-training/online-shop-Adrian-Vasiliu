package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.Stock;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.service.StockService;
import ro.msg.learning.shop.service.findingLocatonsStrategy.ProductLocation;

import java.util.List;

@Service
public class StockServiceImpl extends GenericServiceImpl<Stock, StockRepository> implements StockService {

    @Autowired
    public StockServiceImpl(StockRepository repository) {
        super(repository);
    }

    public void updateStocks(List<ProductLocation> productLocationList) {
        for (ProductLocation productLocation : productLocationList) {
            for (Stock stock : this.getAll()) {
                if (stock.getLocation().equals(productLocation.getLocation()) &&
                        stock.getProduct().equals(productLocation.getProduct())) {
                    stock.setQuantity(stock.getQuantity() - productLocation.getQuantity());
                    update(stock.getId(), stock);
                }
            }
        }
    }
}
