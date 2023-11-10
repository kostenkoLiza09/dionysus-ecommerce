package ua.com.dionysus.facade.plp;


import ua.com.dionysus.data.dto.product.plp.WhiskeyPLPDto;

import java.util.Collection;
import java.util.List;

public interface WhiskeyPLPFacade {

    Collection<WhiskeyPLPDto> findAll();
}
