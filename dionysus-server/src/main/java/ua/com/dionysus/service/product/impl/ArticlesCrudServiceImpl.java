package ua.com.dionysus.service.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.persistence.sql.models.product.Articles;
import ua.com.dionysus.persistence.sql.models.product.LiqueurProduct;
import ua.com.dionysus.persistence.sql.repository.product.ArticlesRepository;
import ua.com.dionysus.persistence.sql.repository.product.LiqueurRepository;
import ua.com.dionysus.service.crud.CrudHelperService;
import ua.com.dionysus.service.product.ArticlesCrudService;

import java.util.Collection;

@Service
public class ArticlesCrudServiceImpl implements ArticlesCrudService {

    private final ArticlesRepository articlesRepository;

    private final CrudHelperService<Articles, ArticlesRepository> crudHelperService;


    public ArticlesCrudServiceImpl(ArticlesRepository articlesRepository,
                                   CrudHelperService<Articles, ArticlesRepository> crudHelperService) {
        this.articlesRepository = articlesRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(Articles entity) {
        crudHelperService.create(entity, articlesRepository);

    }

    @Override
    public void update(Articles entity) {
        crudHelperService.update(entity, articlesRepository);

    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, articlesRepository);

    }

    @Override
    public Articles findById(Long id) {
        return crudHelperService.findById(id, articlesRepository);
    }

    @Override
    public Page<Articles> findAll(DataTableRequest dataTableRequest) {
        return crudHelperService.findAll(dataTableRequest, articlesRepository);
    }

    @Override
    public Collection<Articles> findAll() {
        return articlesRepository.findAll();
    }
}
