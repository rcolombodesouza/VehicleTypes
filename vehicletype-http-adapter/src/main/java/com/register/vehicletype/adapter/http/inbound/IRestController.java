package com.register.vehicletype.adapter.http.inbound;

import com.register.vehicletype.adapter.http.validator.Numeric;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Represents a REST controller interface for managing entities.
 * This interface defines methods for saving, deleting, finding by ID, and retrieving entities.
 *
 * @param <D> the type of entity DTO
 */
@RequestMapping(path = "/default")
public interface IRestController<D, I> {

    /**
     * Saves an entity of type T.
     *
     * @param dto the entity to save
     * @return a ResponseEntity with an empty body and HTTP 200 status if the entity is successfully saved,
     *         or an HTTP 400 status if the request body is invalid
     */
    @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<D> save(@Valid @RequestBody D dto);

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity to delete
     * @return a ResponseEntity with an empty body and HTTP 204 status if the entity is successfully deleted,
     *         or an HTTP 404 status if the entity is not found
     */
    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<String> delete(@Numeric @PathVariable(value = "id") I id);

    /**
     * Finds an entity of type T by its ID.
     *
     * @param id the ID of the entity to find
     * @return a ResponseEntity containing the entity if found, or an HTTP 404 status if not found
     */
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<D> findById(@Numeric @PathVariable(value = "id") I id);

    /**
     * Finds all entities of type T and returns them in ascending order by name.
     *
     * @return a ResponseEntity containing the collection of entities
     */
    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Collection<D>> findAllByOrderByMakeAsc(@Numeric int page, @Numeric int size);
}
