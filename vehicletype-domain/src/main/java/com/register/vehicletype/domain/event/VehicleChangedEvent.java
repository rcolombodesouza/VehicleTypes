package com.register.vehicletype.domain.event;

import org.springframework.context.ApplicationEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * The VehicleChangedEvent class represents an event that occurs when a vehicle is changed.
 *
 * @param <D> the type of payload associated with the event
 */
public abstract class VehicleChangedEvent<D> extends ApplicationEvent {

    private final transient D payload;

    /**
     * The VehicleChangedEvent class represents an event that occurs when a vehicle is changed.
     *
     * @param payload the type of payload associated with the event
     */
    VehicleChangedEvent(Object source, D payload) {
        super(source);
        this.payload = payload;
    }

    /**
     * Returns a map of variables associated with this event.
     *
     * @return a map containing the variables key-value pairs
     */
    public Map<String, Object> getVariables() {
        Map<String, Object> variablesMap = new HashMap<>();
        variablesMap.put("Vehicle", payload);
        return variablesMap;
    }
}
