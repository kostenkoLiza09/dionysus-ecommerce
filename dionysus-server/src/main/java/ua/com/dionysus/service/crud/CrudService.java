package ua.com.dionysus.service.crud;

import org.springframework.data.domain.Page;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.persistence.sql.BaseEntity;

public interface CrudService <E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Long id);
    E findById (Long id);

    Page<E> findAll(DataTableRequest dataTableRequest);

}