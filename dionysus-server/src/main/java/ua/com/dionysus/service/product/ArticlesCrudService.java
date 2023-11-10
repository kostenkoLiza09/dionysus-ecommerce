package ua.com.dionysus.service.product;

import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.sql.models.product.Articles;
import ua.com.dionysus.service.crud.CrudService;

import java.util.Collection;

@Service
public interface ArticlesCrudService extends CrudService<Articles> {

    Collection<Articles> findAll();
}
