package ua.com.dionysus.facade.plp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.plp.RumPLPDto;
import ua.com.dionysus.facade.plp.RumPLPFacade;
import ua.com.dionysus.service.product.LiqueurCrudService;
import ua.com.dionysus.service.product.RumCrudService;

import java.util.Collection;

@Service
public class RumPLPFacadeImpl implements RumPLPFacade {

    private final RumCrudService rumCrudService;

    public RumPLPFacadeImpl(RumCrudService rumCrudService) {
        this.rumCrudService = rumCrudService;
    }

    @Override
    public Collection<RumPLPDto> findAll() {
        return rumCrudService
                .findAll()
                .stream()
                .map(RumPLPDto::new)
                .toList();
    }
}
