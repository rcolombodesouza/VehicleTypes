package com.register.vehicletype.adapter.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

/**
 * The CarEntity class represents a car entity, which is a type of vehicle entity.
 * It represents a car with a specific number of doors.
 */
@Entity
@Table(name = "CAR")
public class CarEntity extends VehicleEntity implements Serializable {

    @Column(name = "NUMBER_OF_DOORS")
    private Integer numberOfDoors;

    public CarEntity(Long id, String make, String model, Integer year, Integer numberOfDoors) {
        super(id, make, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    public CarEntity() {
        super();
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
