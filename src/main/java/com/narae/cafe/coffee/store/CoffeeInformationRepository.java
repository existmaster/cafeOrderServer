package com.narae.cafe.coffee.store;

import com.narae.cafe.coffee.domain.CoffeeInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by existmaster on 2016. 11. 26..
 */
@Repository
//@RepositoryRestResource(collectionResourceRel = "coffeeinfo", path = "coffeeinfo")
public interface CoffeeInformationRepository extends CrudRepository<CoffeeInformation, String> {

    Iterable<CoffeeInformation> findTop5ByOrderBySellCountDesc();
}
