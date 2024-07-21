package com.register.vehicletype.adapter.db.repository;

import com.register.vehicletype.adapter.db.entity.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * The TruckRepository interface is responsible for managing TruckEntity objects in the database.
 *
 * <p>It extends the JpaRepository interface, providing CRUD operations for the TruckEntity type.
 */
@Repository
public interface TruckRepository extends JpaRepository<TruckEntity, Long> {

    /**
     * Retrieves a collection of TruckEntity objects from the database, ordered by make in ascending order.
     *
     * @return Collection of TruckEntity objects ordered by make
     */
    Collection<TruckEntity> findAllByOrderByMakeAsc();
}