package com.register.vehicletype.adapter.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

/**
 * The TruckEntity class represents a truck entity in the database.
 * It is a subclass of the VehicleEntity class and contains additional information specific to trucks.
 */
@Entity
@Table(name = "TRUCK")
public class TruckEntity extends VehicleEntity implements Serializable {

    @Column(name = "PAYLOAD_CAPACITY")
    private double payloadCapacity;

    public TruckEntity(Long id, String make, String model, int year, double payloadCapacity) {
        super(id, make, model, year);
        this.payloadCapacity = payloadCapacity;
    }

    public TruckEntity() {
        super();
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public String toString() {
        return "TruckEntity{} " + super.toString();
    }
}
