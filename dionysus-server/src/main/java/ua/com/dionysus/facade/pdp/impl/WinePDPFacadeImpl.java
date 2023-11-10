package ua.com.dionysus.facade.pdp.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.pdp.WinePDPDto;
import ua.com.dionysus.facade.pdp.WinePDPFacade;
import ua.com.dionysus.persistence.sql.models.product.WineProduct;
import ua.com.dionysus.service.product.WineCrudService;

@Service
public class WinePDPFacadeImpl implements WinePDPFacade {

    private final WineCrudService wineCrudService;

    public WinePDPFacadeImpl(WineCrudService wineCrudService) {
        this.wineCrudService = wineCrudService;
    }

    @Override
    public WinePDPDto findById(Long id) {
        WineProduct wineProduct = wineCrudService.findById(id);
        return new WinePDPDto(wineProduct);
    }
}
