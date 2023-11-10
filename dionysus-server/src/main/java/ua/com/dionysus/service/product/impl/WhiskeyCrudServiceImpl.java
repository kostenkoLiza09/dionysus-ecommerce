package ua.com.dionysus.service.product.impl;


import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.persistence.sql.models.product.WhiskeyProduct;

import ua.com.dionysus.persistence.sql.repository.product.WhiskeyRepository;

import ua.com.dionysus.service.crud.CrudHelperService;
import ua.com.dionysus.service.product.WhiskeyCrudService;

import java.util.Collection;

@Transactional
@Service
public class WhiskeyCrudServiceImpl implements WhiskeyCrudService {

    private final WhiskeyRepository whiskeyRepository;

    private final CrudHelperService<WhiskeyProduct, WhiskeyRepository> crudHelperService;


    public WhiskeyCrudServiceImpl(WhiskeyRepository whiskeyRepository, CrudHelperService<WhiskeyProduct, WhiskeyRepository> crudHelperService) {
        this.whiskeyRepository = whiskeyRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(WhiskeyProduct entity) {
        crudHelperService.create(entity, whiskeyRepository);
    }

    @Override
    public void update(WhiskeyProduct entity) {
        crudHelperService.update(entity, whiskeyRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, whiskeyRepository);
    }

    @Override
    public WhiskeyProduct findById(Long id) {
        return crudHelperService.findById(id, whiskeyRepository);
    }

    @Override
    public Page<WhiskeyProduct> findAll(DataTableRequest dataTableRequest) {
        return crudHelperService.findAll(dataTableRequest, whiskeyRepository);
    }

    @Override
    public Collection<WhiskeyProduct> findAll() {
        return whiskeyRepository.findAll();
    }
}
