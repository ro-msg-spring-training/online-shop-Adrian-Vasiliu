package ro.msg.learning.shop.services;

import ro.msg.learning.shop.domain.Stock;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.services.findingLocatonsStrategy.ProductLocation;

import java.util.List;

public interface StockService extends GenericService<Stock, StockRepository> {
    void updateStocks(List<ProductLocation> productLocationList);
}
