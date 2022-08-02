package ro.msg.learning.shop.services.findingLocatonsStrategy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.services.ProductService;
import ro.msg.learning.shop.services.StockService;

@Configuration
@RequiredArgsConstructor
public class FindingLocationsConfig {

    @Value("${findingLocationsStrategy}")
    private String strategy;

    private final StockService stockService;
    private final ProductService productService;

    @Bean
    public FindingLocationsStrategy chooseStrategy() {
        switch (strategy) {
            case "singleLocation": {
                return new SingleLocationStrategy();
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
