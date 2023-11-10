package ua.com.dionysus.facade.plp;

import ua.com.dionysus.data.dto.product.plp.ArticlesPLPDto;

import java.util.Collection;

public interface ArticlesPLPFacade {

    Collection<ArticlesPLPDto> findAll();
}
