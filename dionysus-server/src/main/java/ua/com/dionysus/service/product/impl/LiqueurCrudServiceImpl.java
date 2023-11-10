package ua.com.dionysus.service.product.impl;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.persistence.sql.models.product.LiqueurProduct;
import ua.com.dionysus.persistence.sql.repository.product.LiqueurRepository;
import ua.com.dionysus.service.crud.CrudHelperService;
import ua.com.dionysus.service.product.LiqueurCrudService;

import java.util.Collection;
@Service
@Transactional
public class LiqueurCrudServiceImpl implements LiqueurCrudService {

    private final LiqueurRepository liqueurRepository;

    private final CrudHelperService<LiqueurProduct, LiqueurRepository> crudHelperService;

    public LiqueurCrudServiceImpl(LiqueurRepository liqueurRepository,
                                  CrudHelperService<LiqueurProduct, LiqueurRepository> crudHelperService) {
            this.liqueurRepository = liqueurRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(LiqueurProduct entity) {
        crudHelperService.create(entity, liqueurRepository);


    }

    @Override
    public void update(LiqueurProduct entity) {
        crudHelperService.update(entity, liqueurRepository);

    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, liqueurRepository);

    }

    @Override
    public LiqueurProduct findById(Long id) {
        return crudHelperService.findById(id, liqueurRepository);
    }

    @Override
    public Page<LiqueurProduct> findAll(DataTableRequest dataTableRequest) {
        return crudHelperService.findAll(dataTableRequest, liqueurRepository);

    }

    @Override
    public Collection<LiqueurProduct> findAll() {
        return liqueurRepository.findAll();

    }
}
