package ua.com.dionysus.facade.process;

import ua.com.dionysus.data.dto.product.ProductProcessDto;

public interface ProductProcessFacade {

    void attachWine(Long id, ProductProcessDto dto);
    void attachWhiskey(Long id, ProductProcessDto dto);
    void attachLiqueur(Long id, ProductProcessDto dto);
    void attachRum(Long id, ProductProcessDto dto);
    void attachTequila(Long id, ProductProcessDto dto);
    void detachWine(Long id, ProductProcessDto dto);
    void detachWhiskey(Long id, ProductProcessDto dto);
    void detachLiqueur(Long id, ProductProcessDto dto);
    void detachRum(Long id, ProductProcessDto dto);
    void detachTequila(Long id, ProductProcessDto dto);

}
