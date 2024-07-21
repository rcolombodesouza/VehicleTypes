package com.register.vehicletype.domain.event;


/**
 * The VehicleDeletedEvent class represents an event that occurs when a vehicle is deleted.
 * It extends the VehicleChangedEvent class.
 *
 * @param <D> the type of payload associated with the event
 */
public class VehicleDeletedEvent<D> extends VehicleChangedEvent<D> {

    /**
     * The VehicleDeletedEvent class represents an event that occurs when a vehicle is deleted.
     * It extends the VehicleChangedEvent class.
     *
     * @param payload the type of payload associated with the event
     */
    public VehicleDeletedEvent(Object source, D payload) {
        super(source, payload);
    }
}
