package ua.com.dionysus.facade.pdp;

import ua.com.dionysus.data.dto.product.pdp.WhiskeyPDPDto;

public interface WhiskeyPDPFacade {

    WhiskeyPDPDto findById(Long id);
}
