package ua.com.dionysus.facade.pdp;

import ua.com.dionysus.data.dto.product.pdp.WinePDPDto;

public interface WinePDPFacade {

    WinePDPDto findById(Long id);

}
