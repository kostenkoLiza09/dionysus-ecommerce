package ua.com.dionysus.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;
import ua.com.dionysus.persistence.sql.repository.BaseEntityRepository;

@Repository
public interface RumRepository extends BaseEntityRepository<RumProduct> {
}
