package ua.com.dionysus.facade.pdp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.pdp.LiqueurPDPDto;
import ua.com.dionysus.facade.pdp.LiqueurPDPFacade;
import ua.com.dionysus.persistence.sql.models.product.LiqueurProduct;
import ua.com.dionysus.service.product.LiqueurCrudService;

@Service
public class LiqueurPDPFacadeImpl implements LiqueurPDPFacade {

    private final LiqueurCrudService liqueurCrudService;

    public LiqueurPDPFacadeImpl(LiqueurCrudService liqueurCrudService) {
        this.liqueurCrudService = liqueurCrudService;
    }

    @Override
    public LiqueurPDPDto findById(Long id) {
        LiqueurProduct liqueurProduct = liqueurCrudService.findById(id);
        return new LiqueurPDPDto(liqueurProduct);
    }
}
