package ua.com.dionysus.facade.plp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.plp.ArticlesPLPDto;
import ua.com.dionysus.data.dto.product.plp.LiqueurPLPDto;
import ua.com.dionysus.facade.plp.ArticlesPLPFacade;
import ua.com.dionysus.service.product.ArticlesCrudService;

import java.util.Collection;

@Service
public class ArticlesPLPFacadeImpl implements ArticlesPLPFacade {

    private final ArticlesCrudService articlesCrudService;

    public ArticlesPLPFacadeImpl(ArticlesCrudService articlesCrudService) {
        this.articlesCrudService = articlesCrudService;
    }

    @Override
    public Collection<ArticlesPLPDto> findAll() {
        return articlesCrudService
                .findAll()
                .stream()
                .map(ArticlesPLPDto::new)
                .toList();
    }
}
