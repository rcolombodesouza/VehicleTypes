package com.register.vehicletype.domain.config;

import com.register.vehicletype.domain.dto.CarDTO;
import com.register.vehicletype.domain.dto.MotorcycleDTO;
import com.register.vehicletype.domain.dto.TruckDTO;
import com.register.vehicletype.domain.port.inbound.IServicePort;
import com.register.vehicletype.domain.port.outbound.IHazelcastPublisherPort;
import com.register.vehicletype.domain.port.outbound.IRepositoryPort;
import com.register.vehicletype.domain.service.CarServiceAdapter;
import com.register.vehicletype.domain.service.MotorcycleServiceAdapter;
import com.register.vehicletype.domain.service.TruckServiceAdapter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The DomainConfig class is a configuration class that defines the bean definitions for the domain layer of the application.
 * It provides service ports for managing different types of entities such as cars, trucks, and motorcycles.
 * The service ports are implemented using corresponding service adapters that interact with repository ports and publish
 * application events.
 */
@Configuration
@ComponentScan(value = "com.register.vehicletype.domain")
public class DomainConfig {

    private static final String CAR_SERVICE_BEAN_NAME = "carServicePort";
    private static final String TRUCK_SERVICE_BEAN_NAME = "truckServicePort";
    private static final String MOTORCYCLE_SERVICE_BEAN_NAME = "motorcycleServicePort";


    /**
     * Creates and retrieves a service port for managing CarDTO entities.
     *
     * @param carRepositoryPort          the repository port for CarDTO entities
     * @param applicationEventPublisher  the publisher for application events
     * @return the service port for managing CarDTO entities
     */
    @Bean(name = CAR_SERVICE_BEAN_NAME)
    public IServicePort<CarDTO, Long> carServicePort(IRepositoryPort<CarDTO, Long> carRepositoryPort,
                                                     ApplicationEventPublisher applicationEventPublisher) {
        return new CarServiceAdapter(carRepositoryPort, applicationEventPublisher);
    }

    /**
     * Creates a service port for managing TruckDTO entities. The service port provides methods for saving, deleting,
     * finding by ID, and retrieving all TruckDTO entities. It uses a TruckRepositoryPort and an ApplicationEventPublisher
     * internally for performing the operations.
     *
     * @param truckRepositoryPort         the repository port for TruckDTO entities
     * @param applicationEventPublisher   the event publisher for application events
     * @return the service port for managing TruckDTO entities
     */
    @Bean(name = TRUCK_SERVICE_BEAN_NAME)
    public IServicePort<TruckDTO, Long> truckServicePort(IRepositoryPort<TruckDTO, Long> truckRepositoryPort,
                                                       ApplicationEventPublisher applicationEventPublisher) {
        return new TruckServiceAdapter(truckRepositoryPort, applicationEventPublisher);
    }

    /**
     * Retrieves the motorcycle service port.
     *
     * @param motorcycleRepositoryPort        the repository port for motorcycles
     * @param applicationEventPublisher       the publisher for application events
     * @return the motorcycle service port
     */
    @Bean(name = MOTORCYCLE_SERVICE_BEAN_NAME)
    public IServicePort<MotorcycleDTO, Long> motorcycleServicePort(IRepositoryPort<MotorcycleDTO, Long> motorcycleRepositoryPort,
                                                         ApplicationEventPublisher applicationEventPublisher) {
        return new MotorcycleServiceAdapter(motorcycleRepositoryPort, applicationEventPublisher);
    }
}
