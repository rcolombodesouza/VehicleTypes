package com.register.vehicletype.domain.event;

/**
 * The VehicleSavedEvent class represents an event that occurs when a vehicle is saved.
 *
 * @param <D> the type of payload associated with the event
 */
public class VehicleSavedEvent<D> extends VehicleChangedEvent<D> {

    /**
     * The VehicleSavedEvent class represents an event that occurs when a vehicle is saved.
     *
     * @param payload the type of payload associated with the event
     */
    public VehicleSavedEvent(Object source, D payload) {
        super(source, payload);
    }
}
