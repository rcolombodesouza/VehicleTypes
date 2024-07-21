package com.register.vehicletype.adapter.db.repository;

import com.register.vehicletype.adapter.db.entity.MotorcycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * The MotorcycleRepository interface extends the JpaRepository interface and provides additional methods
 * for managing MotorcycleEntity objects in the repository.
 */
@Repository
public interface MotorcycleRepository extends JpaRepository<MotorcycleEntity, Long> {

    /**
     * Retrieves a collection of MotorcycleEntity objects from the repository, ordered by the make property in ascending order.
     *
     * @return the collection of MotorcycleEntity objects ordered by make in ascending order
     */
    Collection<MotorcycleEntity> findAllByOrderByMakeAsc();
}