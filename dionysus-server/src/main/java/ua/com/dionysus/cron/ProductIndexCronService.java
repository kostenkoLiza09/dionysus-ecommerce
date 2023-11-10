package ua.com.dionysus.cron;


import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.elasticsearch.document.ProductIndex;
import ua.com.dionysus.persistence.elasticsearch.repository.ProductIndexRepository;
import ua.com.dionysus.persistence.sql.dto.WineDtoMini;

import ua.com.dionysus.persistence.sql.models.product.WineProduct;
import ua.com.dionysus.persistence.sql.repository.product.WineRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ProductIndexCronService {


    private final WineRepository wineRepository;
    private final ElasticsearchOperations elasticsearchOperations;
    private final ProductIndexRepository productIndexRepository;

    public ProductIndexCronService(WineRepository wineRepository,
                                   ElasticsearchOperations elasticsearchOperations,
                                   ProductIndexRepository productIndexRepository) {
        this.wineRepository = wineRepository;
        this.elasticsearchOperations = elasticsearchOperations;
        this.productIndexRepository = productIndexRepository;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void syncToElastic() {
        elasticsearchOperations.indexOps(ProductIndex.class).refresh();
        productIndexRepository.deleteAll();
        Collection<ProductIndex> productIndexCollection = generateProductIndices();
        productIndexRepository.saveAll(productIndexCollection);
    }


    private Collection<ProductIndex> generateProductIndices() {
        Collection<ProductIndex> productIndexCollection = new ArrayList<>();
        Collection<WineDtoMini> collection = wineRepository.find();
        if (CollectionUtils.isNotEmpty(collection)) {
            productIndexCollection = collection
                    .stream()
                    .map(dto -> {
                        ProductIndex productIndex = new ProductIndex();
                        StringBuilder productInfo = new StringBuilder();
                        WineProduct product = dto.getWineProduct();
                        if (product != null) {
                            productInfo.append(product.getName());
                            productInfo.append(", ");
                            productInfo.append(product.getCountryType().getCountryType());
                        }
                        productIndex.setProductInfo(productInfo.toString());
                        return productIndex;
                    })
                    .toList();
        }
        return productIndexCollection;
    }
}