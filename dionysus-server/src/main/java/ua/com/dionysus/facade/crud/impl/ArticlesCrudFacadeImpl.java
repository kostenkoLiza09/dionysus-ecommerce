package ua.com.dionysus.facade.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.ArticlesDto;

import ua.com.dionysus.facade.crud.ArticlesCrudFacade;
import ua.com.dionysus.persistence.sql.models.product.Articles;
import ua.com.dionysus.service.product.ArticlesCrudService;

import java.util.List;

@Service
public class ArticlesCrudFacadeImpl implements ArticlesCrudFacade {

    private  final ArticlesCrudService articlesCrudService;

    public ArticlesCrudFacadeImpl(ArticlesCrudService articlesCrudService) {
        this.articlesCrudService = articlesCrudService;
    }

    @Override
    public void create(ArticlesDto dto) {
        Articles articles = new Articles();
        articles.setDescription(dto.getDescription());
        articles.setImagUrl(dto.getImagUrl());
        articles.setName(dto.getName());
        articlesCrudService.create(articles);

    }

    @Override
    public void update(Long id, ArticlesDto dto) {
        Articles articles = articlesCrudService.findById(id);
        articles.setDescription(dto.getDescription());
        articles.setImagUrl(dto.getImagUrl());
        articles.setName(dto.getName());
        articlesCrudService.create(articles);

    }

    @Override
    public void delete(Long id) {
        articlesCrudService.delete(id);

    }

    @Override
    public ArticlesDto findById(Long id) {
        return new ArticlesDto(articlesCrudService.findById(id));
    }

    @Override
    public DataTableResponse<ArticlesDto> findAll(DataTableRequest request) {
        Page<Articles> page = articlesCrudService.findAll(request);
        DataTableResponse<ArticlesDto> dataTableResponse = new DataTableResponse<ArticlesDto>(request, page);
        List<ArticlesDto> list = page.getContent().stream().map(ArticlesDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
