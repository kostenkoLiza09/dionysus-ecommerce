package ua.com.dionysus.persistence.sql.repository.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.dionysus.persistence.sql.dto.WineDtoMini;
import ua.com.dionysus.persistence.sql.models.product.WineProduct;
import ua.com.dionysus.persistence.sql.repository.BaseEntityRepository;

import java.util.Collection;

@Repository
public interface WineRepository extends BaseEntityRepository<WineProduct> {

    @Query("select distinct new ua.com.dionysus.persistence.sql.dto.WineDtoMini(w.countryType, w.name, w) from WineProduct w")
    Collection<WineDtoMini> find();

    //WineProduct findById(Long id);
}

