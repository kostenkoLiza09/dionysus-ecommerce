package ua.com.dionysus.facade.pdp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.pdp.TequilaPDPDto;
import ua.com.dionysus.facade.pdp.TequilaPDPFacade;
import ua.com.dionysus.persistence.sql.models.product.TequilaProduct;
import ua.com.dionysus.service.product.TequilaCrudService;

@Service
public class TequilaPDPFacadeImpl implements TequilaPDPFacade {

    private final TequilaCrudService tequilaCrudService;

    public TequilaPDPFacadeImpl(TequilaCrudService tequilaCrudService) {
        this.tequilaCrudService = tequilaCrudService;
    }

    @Override
    public TequilaPDPDto findById(Long id) {
        TequilaProduct tequilaProduct = tequilaCrudService.findById(id);
        return new TequilaPDPDto(tequilaProduct);
    }
}
