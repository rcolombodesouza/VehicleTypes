package com.register.vehicletype.domain.port.outbound;

import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * The IRepositoryPort interface defines the contract for a repository that provides CRUD operations for objects.
 *
 * @param <T> the type of the objects in the repository
 * @param <I> the type of the object's ID
 */
public interface IRepositoryPort<T, I> {

    /**
     * Find an object by its ID.
     *
     * @param id the ID of the object to find
     * @return the found object, or null if not found
     */
    T findById(I id);

    /**
     * Retrieves a list of objects from the repository in ascending order of their make.
     *
     * @return the list of objects ordered by name
     */
    List<T> findAllByOrderByMakeAsc();

    /**
     * Saves the given object.
     *
     * @param object the object to be saved
     * @return the saved object
     */
    T save(@NotNull T object);

    /**
     * Deletes an object with the specified ID.
     *
     * @param id the ID of the object to delete
     * @return true if the object was deleted successfully, false otherwise
     */
    boolean delete(I id);
}
