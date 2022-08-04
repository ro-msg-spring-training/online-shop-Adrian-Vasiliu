package ro.msg.learning.shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.msg.learning.shop.domain.*;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.StockService;
import ro.msg.learning.shop.service.findingLocatonsStrategy.ProductLocation;
import ro.msg.learning.shop.service.findingLocatonsStrategy.SingleLocationStrategy;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindingLocationsStrategyTest {

    @Mock
    private StockService stockService;

    @Mock
    private ProductService productService;

    @InjectMocks
    private SingleLocationStrategy singleLocationStrategy;

    @Test
    void testFindingLocationsStrategy() {
        ProductCategory productCategory = new ProductCategory("IT", "Product From IT Category");
        Supplier supplier1 = new Supplier("DELL");
        Supplier supplier2 = new Supplier("HP");
        Product product1 = new Product("Notebook Basic 15", "Notebook Basic", BigDecimal.valueOf(956),
                2000.5, productCategory, supplier2,
                "https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1000.jpg");
        Product product2 = new Product("Notebook Basic 15", "Dell Latitude", BigDecimal.valueOf(500),
                1500.7, productCategory, supplier1,
                "https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1000.jpg");
        when(productService.getById(1L)).thenReturn(product1);
        when(productService.getById(2L)).thenReturn(product2);

        Location location1 = new Location("Altex", "Romania", "Cluj-Napoca", "Cluj", "Memorandumului");
        Location location2 = new Location("Flanco", "Romania", "Piatra Neamt", "Neamt", "9 Mai");
        Stock stock1 = new Stock(product1, location1, 3);
        Stock stock2 = new Stock(product1, location2, 10);
        Stock stock3 = new Stock(product2, location2, 4);
        Stock stock4 = new Stock(product2, location1, 9);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);
        stocks.add(stock3);
        stocks.add(stock4);
        when(stockService.getAll()).thenReturn(stocks);

        Map<Long, Integer> orderedProducts = new HashMap<Long, Integer>() {{
            put(1L, 4);
            put(2L, 3);
        }};
        ProductLocation productLocation1 = new ProductLocation(location2, product1, 4);
        ProductLocation productLocation2 = new ProductLocation(location2, product2, 3);
        List<ProductLocation> productLocationList1 = Arrays.asList(productLocation1, productLocation2);

        List<ProductLocation> singleLocationResult = singleLocationStrategy.getProductLocations(orderedProducts);
        assertThat(productLocationList1).hasSameElementsAs(singleLocationResult);
    }

}
