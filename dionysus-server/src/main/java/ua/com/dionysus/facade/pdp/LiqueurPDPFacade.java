package ua.com.dionysus.facade.pdp;

import ua.com.dionysus.data.dto.product.pdp.LiqueurPDPDto;

public interface LiqueurPDPFacade {

    LiqueurPDPDto findById(Long id);
}
