package ua.com.dionysus.facade.plp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.plp.TequilaPLPDto;
import ua.com.dionysus.facade.plp.TequilaPLPFacade;
import ua.com.dionysus.service.product.RumCrudService;
import ua.com.dionysus.service.product.TequilaCrudService;

import java.util.Collection;

@Service
public class TequilaPLPFacadeImpl implements TequilaPLPFacade {

    private final TequilaCrudService tequilaCrudService;

    public TequilaPLPFacadeImpl(TequilaCrudService tequilaCrudService) {
        this.tequilaCrudService = tequilaCrudService;
    }

    @Override
    public Collection<TequilaPLPDto> findAll() {
        return tequilaCrudService
                .findAll()
                .stream()
                .map(TequilaPLPDto::new)
                .toList();
    }
}
