package ua.com.dionysus.service.crud;

import org.springframework.data.domain.Page;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.persistence.sql.BaseEntity;
import ua.com.dionysus.persistence.sql.repository.BaseEntityRepository;

public interface CrudHelperService<E extends BaseEntity, R extends BaseEntityRepository<E>> {

    void create(E entity, R repository);
    void update(E entity, R repository);
    void delete(Long id, R repository);
    E findById(Long id, R repository);
    Page<E> findAll(DataTableRequest request, R repository);
    void checkExists(Long id, R repository);
}

