package ua.com.dionysus.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.persistence.elasticsearch.document.ProductIndex;
import ua.com.dionysus.service.product.ProductInfoSearchService;

import java.util.Collection;

@RestController
@RequestMapping("products/search")
public class ProductInfoSearchController {

    private final ProductInfoSearchService productInfoSearchService;

    public ProductInfoSearchController(ProductInfoSearchService productInfoSearchService) {
        this.productInfoSearchService = productInfoSearchService;
    }

    @GetMapping
    public ResponseEntity<DataContainer<Collection<ProductIndex>>> search(@RequestParam String query) {
        return ResponseEntity.ok(new DataContainer<>(productInfoSearchService.search(query)));
    }
}