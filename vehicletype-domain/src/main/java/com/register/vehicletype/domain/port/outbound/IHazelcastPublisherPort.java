package com.register.vehicletype.domain.port.outbound;

/**
 * The IHazelcastPublisherPort interface represents a port for publishing messages to a specified Hazelcast topic.
 */
public interface IHazelcastPublisherPort {

    /**
     * Publishes a message to a specified Hazelcast topic.
     *
     * @param topic   the topic to which the message will be published
     * @param message the message to be published
     */
    void publishToHazelcast(String topic, Object message);
}
