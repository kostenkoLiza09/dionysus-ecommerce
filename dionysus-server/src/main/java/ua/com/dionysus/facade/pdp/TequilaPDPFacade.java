package ua.com.dionysus.facade.pdp;


import ua.com.dionysus.data.dto.product.pdp.TequilaPDPDto;

public interface TequilaPDPFacade {

    TequilaPDPDto findById(Long id);
}
