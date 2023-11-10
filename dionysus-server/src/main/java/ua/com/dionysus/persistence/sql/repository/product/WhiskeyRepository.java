package ua.com.dionysus.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.dionysus.persistence.sql.models.product.WhiskeyProduct;
import ua.com.dionysus.persistence.sql.repository.BaseEntityRepository;

@Repository
public interface WhiskeyRepository extends BaseEntityRepository<WhiskeyProduct> {


}
