package com.register.vehicletype.domain.port.inbound;

import java.util.Collection;


/**
 * The IServicePort interface represents a service port for managing entities. It defines methods for saving, deleting, finding by ID, and retrieving all entities.
 *
 * @param <T> the type of entity DTO.
 * @param <I> the type of entity ID.
 */
public interface IServicePort<T, I> {

    /**
     * Saves an entity.
     *
     * @param dto the object representing the entity to be saved.
     * @return the saved entity if the save operation is successful, null otherwise.
     */
    T save(T dto);

    /**
     * Deletes an entity with the specified ID.
     *
     * @param id the ID of the entity to delete.
     * @return true if the entity is successfully deleted, false otherwise.
     */
    boolean delete(I id);

    /**
     * Finds an entity by its ID.
     *
     * @param id the ID of the entity.
     * @return the entity with the specified ID if found, null otherwise.
     */
    T findById(I id);

    /**
     * Retrieves all entities from the collection, ordered by make in ascending order.
     *
     * @return a collection of entities, ordered by name in ascending order.
     */
    Collection<T> findAllByOrderByMakeAsc();
}
