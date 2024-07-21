package com.register.vehicletype.domain.port.inbound;

/**
 * The interface IHazelcastSubscriberPort represents a port for subscribing to Hazelcast topics.
 */
public interface IHazelcastSubscriberPort {

    /**
     * Subscribes to a Hazelcast topic.
     *
     * @param topic the name of the topic to subscribe to
     */
    void subscribeToHazelcast(String topic);
}
