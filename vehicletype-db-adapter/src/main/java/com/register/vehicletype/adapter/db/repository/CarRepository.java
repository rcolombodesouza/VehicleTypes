package com.register.vehicletype.adapter.db.repository;

import com.register.vehicletype.adapter.db.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * The CarRepository interface provides methods for accessing and manipulating car entities in a repository.
 */
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    /**
     * Retrieves a collection of CarEntity objects from the repository, ordered by make in ascending order.
     *
     * @return the collection of CarEntity objects ordered by make
     */
    Collection<CarEntity> findAllByOrderByMakeAsc();
}