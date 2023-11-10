package ua.com.dionysus.facade.plp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.plp.WhiskeyPLPDto;
import ua.com.dionysus.facade.plp.WhiskeyPLPFacade;
import ua.com.dionysus.service.product.WhiskeyCrudService;

import java.util.List;

@Service
public class WhiskeyPLPFacadeImpl implements WhiskeyPLPFacade {

    private final WhiskeyCrudService whiskeyCrudService;

    public WhiskeyPLPFacadeImpl(WhiskeyCrudService whiskeyCrudService) {
        this.whiskeyCrudService = whiskeyCrudService;
    }

    @Override
    public List<WhiskeyPLPDto> findAll() {
        return whiskeyCrudService
                .findAll()
                .stream()
                .map(WhiskeyPLPDto::new)
                .toList();
    }
}
