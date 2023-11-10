package ua.com.dionysus.facade.process.impl;

import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.product.ProductProcessDto;
import ua.com.dionysus.facade.process.ProductProcessFacade;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.*;
import ua.com.dionysus.service.product.*;

import java.util.Collections;
import java.util.Set;

@Service
public class ProductProcessFacadeImpl implements ProductProcessFacade {

    private final ProductImageCrudService productImageCrudService;
    private final WineCrudService wineCrudService;
    private final WhiskeyCrudService whiskeyCrudService;
    private final TequilaCrudService tequilaCrudService;
    private final LiqueurCrudService liqueurCrudService;
    private final RumCrudService rumCrudService;


    public ProductProcessFacadeImpl(WineCrudService wineCrudService,
                                    WhiskeyCrudService whiskeyCrudService,
                                    TequilaCrudService tequilaCrudService,
                                    LiqueurCrudService liqueurCrudService,
                                    RumCrudService rumCrudService,
                                    ProductImageCrudService productImageCrudService) {
        this.wineCrudService = wineCrudService;
        this.whiskeyCrudService = whiskeyCrudService;
        this.tequilaCrudService = tequilaCrudService;
        this.liqueurCrudService = liqueurCrudService;
        this.rumCrudService = rumCrudService;
        this.productImageCrudService = productImageCrudService;
    }

    @Override
    public void attachWine(Long id, ProductProcessDto dto) {
        WineProduct wineProduct = wineCrudService.findById(id);
        Set<ProductImage> productImages = productImageCrudService
                .findAllByIdIn(dto.getProductImages());
        wineProduct.setProductImages(productImages);
        wineCrudService.update(wineProduct);
    }

    @Override
    public void attachWhiskey(Long id, ProductProcessDto dto) {
        WhiskeyProduct whiskeyProduct = whiskeyCrudService.findById(id);
        Set<ProductImage> productImages = productImageCrudService
                .findAllByIdIn(dto.getProductImages());
        whiskeyProduct.setProductImages(productImages);
        whiskeyCrudService.update(whiskeyProduct);
    }

    @Override
    public void attachLiqueur(Long id, ProductProcessDto dto) {
        LiqueurProduct liqueurProduct = liqueurCrudService.findById(id);
        Set<ProductImage> productImages = productImageCrudService
                .findAllByIdIn(dto.getProductImages());
        liqueurProduct.setProductImages(productImages);
        liqueurCrudService.update(liqueurProduct);
    }

    @Override
    public void attachRum(Long id, ProductProcessDto dto) {
        RumProduct rumProduct = rumCrudService.findById(id);
        Set<ProductImage> productImages = productImageCrudService
                .findAllByIdIn(dto.getProductImages());
        rumProduct.setProductImages(productImages);
        rumCrudService.update(rumProduct);
    }

    @Override
    public void attachTequila(Long id, ProductProcessDto dto) {
        TequilaProduct tequilaProduct = tequilaCrudService.findById(id);
        Set<ProductImage> productImages = productImageCrudService
                .findAllByIdIn(dto.getProductImages());
        tequilaProduct.setProductImages(productImages);
        tequilaCrudService.update(tequilaProduct);
    }

    @Override
    public void detachWine(Long id, ProductProcessDto dto) {
        WineProduct wineProduct = wineCrudService.findById(id);
        wineProduct.setProductImages(Collections.emptySet());
        wineCrudService.update(wineProduct);
    }

    @Override
    public void detachWhiskey(Long id, ProductProcessDto dto) {
        WhiskeyProduct whiskeyProduct = whiskeyCrudService.findById(id);
        whiskeyProduct.setProductImages(Collections.emptySet());
        whiskeyCrudService.update(whiskeyProduct);
    }

    @Override
    public void detachLiqueur(Long id, ProductProcessDto dto) {
        LiqueurProduct liqueurProduct = liqueurCrudService.findById(id);
        liqueurProduct.setProductImages(Collections.emptySet());
        liqueurCrudService.update(liqueurProduct);
    }

    @Override
    public void detachRum(Long id, ProductProcessDto dto) {
        RumProduct rumProduct = rumCrudService.findById(id);
        rumProduct.setProductImages(Collections.emptySet());
        rumCrudService.update(rumProduct);
    }

    @Override
    public void detachTequila(Long id, ProductProcessDto dto) {
        TequilaProduct tequilaProduct = tequilaCrudService.findById(id);
        tequilaProduct.setProductImages(Collections.emptySet());
        tequilaCrudService.update(tequilaProduct);
    }
}