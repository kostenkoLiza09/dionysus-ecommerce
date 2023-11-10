package ua.com.dionysus.facade.pdp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.pdp.RumPDPDto;
import ua.com.dionysus.facade.pdp.RumPDPFacade;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;
import ua.com.dionysus.service.product.RumCrudService;

@Service
public class RumPDPFacadeImpl implements RumPDPFacade {

    private final RumCrudService rumCrudService;

    public RumPDPFacadeImpl(RumCrudService rumCrudService) {
        this.rumCrudService = rumCrudService;
    }

    @Override
    public RumPDPDto findById(Long id) {
        RumProduct rumProduct = rumCrudService.findById(id);
        return new RumPDPDto(rumProduct);
    }
}
