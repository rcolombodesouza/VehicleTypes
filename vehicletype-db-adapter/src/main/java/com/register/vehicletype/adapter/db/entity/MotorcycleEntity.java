package com.register.vehicletype.adapter.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

/**
 * The MotorcycleEntity class represents a motorcycle entity in the application.
 * It extends the VehicleEntity class and adds an additional property to indicate
 * whether the motorcycle has a sidecar or not.
 */
@Entity
@Table(name = "MOTORCYCLE")
public class MotorcycleEntity extends VehicleEntity implements Serializable {

    @Column(name = "HAS_SIDECAR")
    private boolean hasSidecar;

    public MotorcycleEntity(Long id, String make, String model, int year, boolean hasSidecar) {
        super(id, make, model, year);
        this.hasSidecar = hasSidecar;
    }

    public MotorcycleEntity() {
        super();
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return "MotorcycleEntity{" +
                "hasSidecar=" + hasSidecar +
                "} " + super.toString();
    }
}
