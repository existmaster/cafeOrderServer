package com.narae.cafe.user.store;

import com.narae.cafe.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by existmaster on 2016. 11. 26..
 */

@Repository
public interface UserRepository extends CrudRepository<User, String>{
}
