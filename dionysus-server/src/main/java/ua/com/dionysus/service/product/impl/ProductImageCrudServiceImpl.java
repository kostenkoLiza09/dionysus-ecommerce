package ua.com.dionysus.service.product.impl;


import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.repository.product.ProductImageRepository;
import ua.com.dionysus.service.crud.CrudHelperService;
import ua.com.dionysus.service.product.ProductImageCrudService;

import java.util.Set;
import java.util.logging.Logger;

@Service
@Transactional
public class ProductImageCrudServiceImpl implements ProductImageCrudService {




    private final ProductImageRepository productImageRepository;

    private final CrudHelperService<ProductImage, ProductImageRepository> crudHelperService;

    public ProductImageCrudServiceImpl(ProductImageRepository productImageRepository,
                                       CrudHelperService<ProductImage, ProductImageRepository> crudHelperService) {
        this.productImageRepository = productImageRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(ProductImage entity) {
        crudHelperService.create(entity, productImageRepository);
    }

    @Override
    public void update(ProductImage entity) {
        crudHelperService.update(entity, productImageRepository);

    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, productImageRepository);

    }

    @Override
    public ProductImage findById(Long id) {
        return crudHelperService.findById(id, productImageRepository);

    }

    @Override
    public Page<ProductImage> findAll(DataTableRequest dataTableRequest) {
        return crudHelperService.findAll(dataTableRequest, productImageRepository);
    }

    @Override
    public Set<ProductImage> findAllByIdIn(Set<Long> ids) {
        return productImageRepository.findAllByIdIn(ids);
    }
}
