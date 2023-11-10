package ua.com.dionysus.service.product;

import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;
import ua.com.dionysus.service.crud.CrudService;

import java.util.Collection;

@Service
public interface RumCrudService extends CrudService<RumProduct> {

    Collection<RumProduct> findAll();
}
