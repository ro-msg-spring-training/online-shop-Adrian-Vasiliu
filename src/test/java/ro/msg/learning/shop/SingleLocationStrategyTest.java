package ro.msg.learning.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.StockService;
import ro.msg.learning.shop.service.findingLocatonsStrategy.SingleLocationStrategy;

@ExtendWith(MockitoExtension.class)
class SingleLocationStrategyTest {

    @Mock
    private StockService stockService;

    @Mock
    private ProductService productService;

    private SingleLocationStrategy singleLocationStrategy;


    @Test
    void singleLocationStrategy() {
        // ...
    }

}