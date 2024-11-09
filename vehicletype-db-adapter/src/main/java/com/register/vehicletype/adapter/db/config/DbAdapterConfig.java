package com.register.vehicletype.adapter.db.config;

import com.register.vehicletype.adapter.db.converter.todto.CarEntityToDTOConverter;
import com.register.vehicletype.adapter.db.converter.todto.MotorcycleEntityToDTOConverter;
import com.register.vehicletype.adapter.db.converter.todto.TruckEntityToDTOConverter;
import com.register.vehicletype.adapter.db.converter.toentity.CarDTOToEntityConverter;
import com.register.vehicletype.adapter.db.converter.toentity.MotorcycleDTOToEntityConverter;
import com.register.vehicletype.adapter.db.converter.toentity.TruckDTOToEntityConverter;
import com.register.vehicletype.adapter.db.outbound.CarRepositoryAdapter;
import com.register.vehicletype.adapter.db.outbound.MotorcycleRepositoryAdapter;
import com.register.vehicletype.adapter.db.outbound.TruckRepositoryAdapter;
import com.register.vehicletype.adapter.db.repository.CarRepository;
import com.register.vehicletype.adapter.db.repository.MotorcycleRepository;
import com.register.vehicletype.adapter.db.repository.TruckRepository;
import com.register.vehicletype.domain.dto.CarDTO;
import com.register.vehicletype.domain.dto.MotorcycleDTO;
import com.register.vehicletype.domain.dto.TruckDTO;
import com.register.vehicletype.domain.port.inbound.HasConverterConfigPort;
import com.register.vehicletype.domain.port.outbound.IRepositoryPort;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;

/**
 * The DbAdapterConfig class is a configuration class for the database adapter.
 * It is responsible for configuring the necessary beans and dependencies for the adapter.
 */
@Configuration
@ComponentScan(value = "com.register.vehicletype.adapter.db")
@PropertySource("classpath:/application-db.properties")
@EnableCaching
public class DbAdapterConfig implements HasConverterConfigPort {

    private static final String CAR_REPOSITORY_PORT_NAME = "carRepositoryPort";
    private static final String TRUCK_REPOSITORY_PORT_NAME = "truckRepositoryPort";
    private static final String MOTORCYCLE_REPOSITORY_PORT_NAME = "motorcycleRepositoryPort";
    private static final String CAR_ENTITY_DTO_CONVERTER_NAME = "carEntityToDTOConverter";
    private static final String TRUCK_ENTITY_DTO_CONVERTER_NAME = "truckEntityToDTOConverter";
    private static final String MOTORCYCLE_ENTITY_DTO_CONVERTER_NAME = "motorcycleEntityToDTOConverter";
    private static final String CAR_DTO_ENTITY_CONVERTER_NAME = "carDTOToEntityConverter";
    private static final String TRUCK_DTO_ENTITY_CONVERTER_NAME = "truckDTOToEntityConverter";
    private static final String MOTORCYCLE_DTO_ENTITY_CONVERTER_NAME = "motorcycleDTOToEntityConverter";


    /**
     * The carRepositoryPort method returns an instance of IRepositoryPort for CarDTO objects.
     *
     * @param carRepository the repository for managing CarEntity objects
     * @param conversionService the conversion service for converting between CarDTO and CarEntity
     * @return an instance of IRepositoryPort for CarDTO
     */
    @Bean(name = CAR_REPOSITORY_PORT_NAME)
    public IRepositoryPort<CarDTO, Long> carRepositoryPort(CarRepository carRepository,
                                                           ConversionService conversionService) {
        return new CarRepositoryAdapter(carRepository, conversionService);
    }

    /** s
     * Creates and returns an instance of IRepositoryPort for TruckDTO objects.
     *
     * @param conversionService the conversion service for converting between TruckDTO and TruckEntity
     * @param truckRepository the repository for managing TruckEntity objects
     *
     * @return an instance of IRepositoryPort for TruckDTO
     */
    @Bean(name = TRUCK_REPOSITORY_PORT_NAME)
    public IRepositoryPort<TruckDTO, Long> truckRepositoryPort(TruckRepository truckRepository,
                                                               ConversionService conversionService) {
        return new TruckRepositoryAdapter(truckRepository, conversionService);
    }

    /**
     * Creates and returns an instance of IRepositoryPort for MotorcycleDTO objects.
     *
     * @param motorcycleRepository the repository for managing MotorcycleEntity objects
     * @param conversionService the conversion service for converting between MotorcycleDTO and MotorcycleEntity
     * @return an instance of IRepositoryPort for MotorcycleDTO
     */
    @Bean(name = MOTORCYCLE_REPOSITORY_PORT_NAME)
    public IRepositoryPort<MotorcycleDTO, Long> motorcycleRepositoryPort(MotorcycleRepository motorcycleRepository,
                                                                         ConversionService conversionService) {
        return new MotorcycleRepositoryAdapter(motorcycleRepository, conversionService);
    }

    /**
     * Provides a bean for converting CarEntity objects to CarDTO objects.
     *
     * @return an instance of CarEntityToDTOConverter
     */
    @Bean(name = CAR_ENTITY_DTO_CONVERTER_NAME)
    public CarEntityToDTOConverter carEntityToDTOConverter() {
        return new CarEntityToDTOConverter();
    }

    /**
     * Provides a bean for converting TruckEntity objects to TruckDTO objects.
     *
     * @return an instance of TruckEntityToDTOConverter
     */
    @Bean(name = TRUCK_ENTITY_DTO_CONVERTER_NAME)
    public TruckEntityToDTOConverter truckEntityToDTOConverter() {
        return new TruckEntityToDTOConverter();
    }

    /**
     * Provides a bean for converting MotorcycleEntity objects to MotorcycleDTO objects.
     *
     * @return an instance of MotorcycleEntityToDTOConverter
     */
    @Bean(name = MOTORCYCLE_ENTITY_DTO_CONVERTER_NAME)
    public MotorcycleEntityToDTOConverter motorcycleEntityToDTOConverter() {
        return new MotorcycleEntityToDTOConverter();
    }

    /**
     * Provides a bean for converting CarDTO objects to CarEntity objects.
     *
     * @return an instance of CarDTOToEntityConverter
     */
    @Bean(name = CAR_DTO_ENTITY_CONVERTER_NAME)
    public CarDTOToEntityConverter carDTOToEntityConverter() {
        return new CarDTOToEntityConverter();
    }

    /**
     * Provides a bean for converting TruckDTO objects to TruckEntity objects.
     *
     * @return an instance of TruckDTOToEntityConverter
     */
    @Bean(name = TRUCK_DTO_ENTITY_CONVERTER_NAME)
    public TruckDTOToEntityConverter truckDTOToEntityConverter() {
        return new TruckDTOToEntityConverter();
    }

    /**
     * Provides a bean for converting MotorcycleDTO objects to MotorcycleEntity objects.
     *
     * @return an instance of MotorcycleDTOToEntityConverter
     */
    @Bean(name = MOTORCYCLE_DTO_ENTITY_CONVERTER_NAME)
    public MotorcycleDTOToEntityConverter motorcycleDTOToEntityConverter() {
        return new MotorcycleDTOToEntityConverter();
    }

    @Override
    public void registerConverters(ConverterRegistry converterRegistry) {
        converterRegistry.addConverter(new CarDTOToEntityConverter());
        converterRegistry.addConverter(new TruckDTOToEntityConverter());
        converterRegistry.addConverter(new MotorcycleDTOToEntityConverter());
        converterRegistry.addConverter(new CarEntityToDTOConverter());
        converterRegistry.addConverter(new TruckEntityToDTOConverter());
        converterRegistry.addConverter(new MotorcycleEntityToDTOConverter());
    }
}
