package ua.com.dionysus.service.product;

import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.sql.models.product.WineProduct;
import ua.com.dionysus.service.crud.CrudService;

import java.util.Collection;

@Service
public interface WineCrudService extends CrudService<WineProduct> {

    Collection<WineProduct> findAll();
}
