package ua.com.dionysus.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.repository.BaseEntityRepository;

import java.util.Set;

@Repository
public interface ProductImageRepository extends BaseEntityRepository<ProductImage> {

    Set<ProductImage> findAllByIdIn(Set<Long> ids);
}
