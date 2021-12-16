package org.ethiosouth.shoppingapi.repositories;

import org.ethiosouth.shoppingapi.domain.Address;
import org.ethiosouth.shoppingapi.domain.Follower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends CrudRepository<Follower, Long> {
}
