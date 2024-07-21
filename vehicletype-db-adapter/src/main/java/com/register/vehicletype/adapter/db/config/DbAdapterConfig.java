package com.register.vehicletype.adapter.db.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.register.vehicletype.adapter.db.outbound.CarRepositoryAdapter;
import com.register.vehicletype.adapter.db.outbound.MotorcycleRepositoryAdapter;
import com.register.vehicletype.adapter.db.outbound.TruckRepositoryAdapter;
import com.register.vehicletype.adapter.db.repository.CarRepository;
import com.register.vehicletype.adapter.db.repository.MotorcycleRepository;
import com.register.vehicletype.adapter.db.repository.TruckRepository;
import com.register.vehicletype.domain.dto.CarDTO;
import com.register.vehicletype.domain.dto.MotorcycleDTO;
import com.register.vehicletype.domain.dto.TruckDTO;
import com.register.vehicletype.domain.port.outbound.IRepositoryPort;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * The DbAdapterConfig class is a configuration class for the database adapter.
 * It is responsible for configuring the necessary beans and dependencies for the adapter.
 */
@Configuration
@ComponentScan(value = "com.register.vehicletype.adapter.db")
@PropertySource("classpath:/application-db.properties")
@EnableCaching
public class DbAdapterConfig {

    private static final String CAR_REPOSITORY_PORT_NAME = "carRepositoryPort";
    private static final String TRUCK_REPOSITORY_PORT_NAME = "truckRepositoryPort";
    private static final String MOTORCYCLE_REPOSITORY_PORT_NAME = "motorcycleRepositoryPort";
    private static final String OBJECT_MAPPER_NAME = "objectMapper";


    /**
     * The carRepositoryPort method returns an instance of IRepositoryPort for CarDTO objects.
     *
     * @param carRepository the repository for managing CarEntity objects
     * @param objectMapper the conversion service for converting between CarDTO and CarEntity
     * @return an instance of IRepositoryPort for CarDTO
     */
    @Bean(name = CAR_REPOSITORY_PORT_NAME)
    public IRepositoryPort<CarDTO, Long> carRepositoryPort(CarRepository carRepository,
                                                           ObjectMapper objectMapper) {
        return new CarRepositoryAdapter(carRepository, objectMapper);
    }

    /** s
     * Creates and returns an instance of IRepositoryPort for TruckDTO objects.
     *
     * @param objectMapper the conversion service for converting between TruckDTO and TruckEntity
     * @param truckRepository the repository for managing TruckEntity objects
     *
     * @return an instance of IRepositoryPort for TruckDTO
     */
    @Bean(name = TRUCK_REPOSITORY_PORT_NAME)
    public IRepositoryPort<TruckDTO, Long> truckRepositoryPort(TruckRepository truckRepository,
                                                               ObjectMapper objectMapper) {
        return new TruckRepositoryAdapter(truckRepository, objectMapper);
    }

    /**
     * Creates and returns an instance of IRepositoryPort for MotorcycleDTO objects.
     *
     * @param motorcycleRepository the repository for managing MotorcycleEntity objects
     * @param objectMapper the conversion service for converting between MotorcycleDTO and MotorcycleEntity
     * @return an instance of IRepositoryPort for MotorcycleDTO
     */
    @Bean(name = MOTORCYCLE_REPOSITORY_PORT_NAME)
    public IRepositoryPort<MotorcycleDTO, Long> motorcycleRepositoryPort(MotorcycleRepository motorcycleRepository,
                             ObjectMapper objectMapper) {
        return new MotorcycleRepositoryAdapter(motorcycleRepository, objectMapper);
    }

    /**
     * The objectMapper method returns an instance of ObjectMapper.
     *
     * @return an instance of ObjectMapper
     */
    @Bean(name = OBJECT_MAPPER_NAME)
    public ObjectMapper objectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        return om;
    }
}
