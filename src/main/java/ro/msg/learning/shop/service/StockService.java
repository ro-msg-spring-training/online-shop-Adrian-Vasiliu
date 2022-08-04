package ro.msg.learning.shop.service;

import ro.msg.learning.shop.domain.Stock;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.service.findingLocatonsStrategy.ProductLocation;

import java.util.List;

public interface StockService extends GenericService<Stock, StockRepository> {
    void updateStocks(List<ProductLocation> productLocationList);
}
