package ua.com.dionysus.facade.plp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.plp.WhiskeyPLPDto;
import ua.com.dionysus.data.dto.product.plp.WinePLPDto;
import ua.com.dionysus.facade.plp.WhiskeyPLPFacade;
import ua.com.dionysus.facade.plp.WinePLPFacade;
import ua.com.dionysus.service.product.WineCrudService;

import java.util.List;

@Service
public class WinePLPFacadeImpl implements WinePLPFacade {

    private final WineCrudService wineCrudService;

    public WinePLPFacadeImpl(WineCrudService wineCrudService) {
        this.wineCrudService = wineCrudService;
    }

    @Override
    public List<WinePLPDto> findAll() {
        return wineCrudService
                .findAll()
                .stream()
                .map(WinePLPDto ::new)
                .toList();
    }
}
