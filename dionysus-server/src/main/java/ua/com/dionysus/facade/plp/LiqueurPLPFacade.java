package ua.com.dionysus.facade.plp;

import ua.com.dionysus.data.dto.product.plp.LiqueurPLPDto;

import java.util.Collection;

public interface LiqueurPLPFacade {

    Collection<LiqueurPLPDto> findAll();
}
