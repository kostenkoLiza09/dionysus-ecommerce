package ua.com.dionysus.facade.pdp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.pdp.WhiskeyPDPDto;
import ua.com.dionysus.facade.pdp.WhiskeyPDPFacade;
import ua.com.dionysus.persistence.sql.models.product.WhiskeyProduct;
import ua.com.dionysus.service.product.WhiskeyCrudService;

@Service
public class WhiskeyPDPFacadeImpl implements WhiskeyPDPFacade {

    private final WhiskeyCrudService whiskeyCrudService;

    public WhiskeyPDPFacadeImpl(WhiskeyCrudService whiskeyCrudService) {
        this.whiskeyCrudService = whiskeyCrudService;
    }

    @Override
    public WhiskeyPDPDto findById(Long id) {
        WhiskeyProduct whiskeyProduct = whiskeyCrudService.findById(id);
        return new WhiskeyPDPDto(whiskeyProduct);
    }
}
