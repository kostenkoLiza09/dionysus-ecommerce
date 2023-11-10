package ua.com.dionysus.persistence.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ua.com.dionysus.persistence.sql.BaseEntity;

@NoRepositoryBean
public interface BaseEntityRepository <E extends BaseEntity> extends JpaRepository<E, Long> { }
