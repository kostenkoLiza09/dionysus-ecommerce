package ua.com.dionysus.service.product;

import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.service.crud.CrudService;

import java.util.Set;

@Service
public interface ProductImageCrudService extends CrudService<ProductImage> {

    Set<ProductImage> findAllByIdIn(Set<Long> ids);
}
