package ua.com.dionysus.service.product.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.elasticsearch.document.ProductIndex;
import ua.com.dionysus.persistence.elasticsearch.repository.ProductIndexRepository;
import ua.com.dionysus.service.product.ProductInfoSearchService;

import java.util.Collection;


@Service
public class ProductInfoSearchServiceImpl implements ProductInfoSearchService {

   private final ProductIndexRepository productIndexRepository;

    public ProductInfoSearchServiceImpl(ProductIndexRepository productIndexRepository) {
        this.productIndexRepository = productIndexRepository;
    }

    @Override
    public Collection<ProductIndex> search(String query) {
        return productIndexRepository.findByProductInfoContainingIgnoreCase(query);
    }
}
