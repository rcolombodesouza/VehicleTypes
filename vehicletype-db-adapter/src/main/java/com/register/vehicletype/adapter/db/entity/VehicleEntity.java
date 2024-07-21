package com.register.vehicletype.adapter.db.entity;


import jakarta.persistence.*;
import org.springframework.data.annotation.Version;

import java.io.Serializable;

/**
 * The VehicleEntity class is an abstract class that represents a generic vehicle entity.
 * It forms the base class for specific types of vehicles, such as cars, motorcycles, and trucks.
 *
 * <p>The class is annotated with JPA annotations to specify its mapping to a database table.
 * It is also annotated with Lombok annotations to generate getter, setter, and toString methods.
 *
 * <p>Fields:
 * - id: The unique identifier for the vehicle entity. It is generated automatically by the database.
 * - make: The make or manufacturer of the vehicle. It cannot be null.
 * - model: The model name of the vehicle. It cannot be null.
 * - year: The manufacturing year of the vehicle. It cannot be null.
 *
 * <p>Subclasses:
 * - CarEntity: Represents a car entity, which is a type of vehicle entity. It extends VehicleEntity and adds
 *   a property for the number of doors the car has.
 * - MotorcycleEntity: Represents a motorcycle entity, which is a type of vehicle entity. It extends VehicleEntity
 *   and adds a property to indicate whether the motorcycle has a sidecar or not.
 * - TruckEntity: Represents a truck entity, which is a type of vehicle entity. It extends VehicleEntity and adds
 *   a property for the payload capacity of the truck.
 *
 * <p>This class should not be instantiated directly as it is an abstract class.
 * Instead, create instances of specific vehicle types (car, motorcycle, truck) that extend this class.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLE")
public abstract class VehicleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MAKE", nullable = false)
    private String make;

    @Column(name = "MODEL", nullable = false)
    private String model;

    @Column(name = "YEAR", nullable = false)
    private Integer year;

    protected VehicleEntity(Long id, String make, String model, Integer year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    protected VehicleEntity() {
        this(null, null, null, null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
