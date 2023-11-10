package ua.com.dionysus.facade.pdp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.pdp.ArticlesPDPDto;
import ua.com.dionysus.facade.pdp.ArticlesPDPFacade;
import ua.com.dionysus.persistence.sql.models.product.Articles;
import ua.com.dionysus.persistence.sql.models.product.LiqueurProduct;
import ua.com.dionysus.service.product.ArticlesCrudService;

@Service
public class ArticlesPDPFacadeImpl implements ArticlesPDPFacade {

    private final ArticlesCrudService articlesCrudService;

    public ArticlesPDPFacadeImpl(ArticlesCrudService articlesCrudService) {
        this.articlesCrudService = articlesCrudService;
    }

    @Override
    public ArticlesPDPDto findById(Long id) {
        Articles articles = articlesCrudService.findById(id);
        return new ArticlesPDPDto(articles);
    }
}
