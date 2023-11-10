package ua.com.dionysus.facade.pdp;

import ua.com.dionysus.data.dto.product.pdp.ArticlesPDPDto;

public interface ArticlesPDPFacade  {

    ArticlesPDPDto findById(Long id);
}
