package ua.com.dionysus.facade.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.ProductImageDto;
import ua.com.dionysus.facade.crud.ProductImageCrudFacade;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.service.product.ProductImageCrudService;

import java.util.List;

@Service
public class ProductImageCrudFacadeImpl implements ProductImageCrudFacade {

    private final ProductImageCrudService productImageCrudService;

    public ProductImageCrudFacadeImpl(ProductImageCrudService productImageCrudService) {
        this.productImageCrudService = productImageCrudService;
    }
    @Override
    public void create(ProductImageDto dto) {
        ProductImage productImage = new ProductImage();
        productImage.setImageUrl(dto.getImageUrl());
        productImage.setAlcoholType(dto.getAlcoholType());
        productImage.setMainImage(dto.getMainImage());
        productImageCrudService.create(productImage);
    }

    @Override
    public void update(Long id, ProductImageDto dto) {
        ProductImage productImage = productImageCrudService.findById(id);
        productImage.setImageUrl(dto.getImageUrl());
        productImage.setAlcoholType(dto.getAlcoholType());
        productImage.setMainImage(dto.getMainImage());
        productImageCrudService.create(productImage);
    }

    @Override
    public void delete(Long id) {
        productImageCrudService.delete(id);
    }

    @Override
    public ProductImageDto findById(Long id) {
        return new ProductImageDto(productImageCrudService.findById(id));
    }

    @Override
    public DataTableResponse<ProductImageDto> findAll(DataTableRequest request) {
        Page<ProductImage> page = productImageCrudService.findAll(request);
        DataTableResponse<ProductImageDto> dataTableResponse = new DataTableResponse<>(request, page);
        List<ProductImageDto> list = page.getContent().stream().map(ProductImageDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
