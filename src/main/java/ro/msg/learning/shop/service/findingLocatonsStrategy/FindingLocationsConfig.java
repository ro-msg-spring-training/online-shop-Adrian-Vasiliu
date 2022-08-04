package ro.msg.learning.shop.service.findingLocatonsStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.StockService;

import static ro.msg.learning.shop.service.findingLocatonsStrategy.FindingLocationsStrategyType.MOSTABUNDANT;

@Configuration
public class FindingLocationsConfig {

    @Value("${findingLocationsStrategy}")
    private FindingLocationsStrategyType strategyType;

    private final StockService stockService;
    private final ProductService productService;

    @Autowired
    public FindingLocationsConfig(StockService stockService, ProductService productService) {
        this.stockService = stockService;
        this.productService = productService;
    }

    @Bean
    public FindingLocationsStrategy chooseStrategy() {
        if (MOSTABUNDANT.equals(strategyType)) {
            return new MostAbundantStrategy(stockService, productService);
        }
        return new SingleLocationStrategy(stockService, productService);
    }

}
