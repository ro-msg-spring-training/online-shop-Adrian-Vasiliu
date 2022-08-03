package ro.msg.learning.shop.services.findingLocatonsStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.services.ProductService;
import ro.msg.learning.shop.services.StockService;

@Configuration
public class FindingLocationsConfig {

    @Value("${findingLocationsStrategy}")
    private String strategy;

    private final StockService stockService;
    private final ProductService productService;

    @Autowired
    public FindingLocationsConfig(StockService stockService, ProductService productService) {
        this.stockService = stockService;
        this.productService = productService;
    }

    @Bean
    public FindingLocationsStrategy chooseStrategy() {
        switch (strategy) {
            case "singleLocation": {
                return new SingleLocationStrategy(stockService, productService);
            }
            case "mostAbundant": {
                return new MostAbundantStrategy(stockService, productService);
            }
            default: {
                return null;
            }
        }
    }

}
