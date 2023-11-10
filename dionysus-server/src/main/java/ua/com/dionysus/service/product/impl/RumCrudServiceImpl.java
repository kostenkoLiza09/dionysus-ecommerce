package ua.com.dionysus.service.product.impl;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;
import ua.com.dionysus.persistence.sql.repository.product.RumRepository;
import ua.com.dionysus.service.crud.CrudHelperService;
import ua.com.dionysus.service.product.RumCrudService;

import java.util.Collection;

@Service
@Transactional
public class RumCrudServiceImpl implements RumCrudService {

    private final RumRepository rumRepository;

    private final CrudHelperService<RumProduct, RumRepository> crudHelperService;

    public RumCrudServiceImpl(RumRepository rumRepository,
                              CrudHelperService<RumProduct, RumRepository> crudHelperService) {
        this.rumRepository = rumRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(RumProduct entity) {
        crudHelperService.create(entity, rumRepository);
    }

    @Override
    public void update(RumProduct entity) {
        crudHelperService.update(entity, rumRepository);

    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, rumRepository);

    }

    @Override
    public RumProduct findById(Long id) {
        return crudHelperService.findById(id, rumRepository);

    }

    @Override
    public Page<RumProduct> findAll(DataTableRequest dataTableRequest) {
        return crudHelperService.findAll(dataTableRequest, rumRepository);
    }

    @Override
    public Collection<RumProduct> findAll() {
        return rumRepository.findAll();
    }
}
