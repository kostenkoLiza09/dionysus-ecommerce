package ua.com.dionysus.service.product;

import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.sql.models.product.WhiskeyProduct;
import ua.com.dionysus.service.crud.CrudService;

import java.util.Collection;

@Service
public interface WhiskeyCrudService extends CrudService<WhiskeyProduct> {

    Collection<WhiskeyProduct> findAll();
}
