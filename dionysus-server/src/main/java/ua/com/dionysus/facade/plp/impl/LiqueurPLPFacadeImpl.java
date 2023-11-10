package ua.com.dionysus.facade.plp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.plp.LiqueurPLPDto;
import ua.com.dionysus.facade.plp.LiqueurPLPFacade;
import ua.com.dionysus.service.product.LiqueurCrudService;

import java.util.Collection;

@Service
public class LiqueurPLPFacadeImpl implements LiqueurPLPFacade {

    private final LiqueurCrudService liqueurCrudService;

    public LiqueurPLPFacadeImpl(LiqueurCrudService liqueurCrudService) {
        this.liqueurCrudService = liqueurCrudService;
    }

    @Override
    public Collection<LiqueurPLPDto> findAll() {
        return liqueurCrudService
                .findAll()
                .stream()
                .map(LiqueurPLPDto::new)
                .toList();
    }
}
