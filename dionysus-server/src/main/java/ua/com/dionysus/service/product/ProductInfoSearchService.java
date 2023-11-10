package ua.com.dionysus.service.product;

import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.elasticsearch.document.ProductIndex;

import java.util.Collection;

@Service
public interface ProductInfoSearchService {

    Collection<ProductIndex> search(String query);
}
