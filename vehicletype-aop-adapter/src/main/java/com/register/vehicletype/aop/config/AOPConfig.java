package com.register.vehicletype.aop.config;

import com.register.vehicletype.aop.aspect.CarServiceAdapterAspect;
import com.register.vehicletype.aop.aspect.MotorcycleServiceAdapterAspect;
import com.register.vehicletype.aop.aspect.TruckServiceAdapterAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AOPConfig is a configuration class that defines beans for aspect classes that provide AOP functionality for service adapter classes.
 */
@Configuration
public class AOPConfig {

    private static final String CAR_SERVICE_ASPECT_BEAN_NAME = "carServiceAspect";
    private static final String TRUCK_SERVICE_ASPECT_BEAN_NAME = "truckServiceAspect";
    private static final String MOTORCYCLE_SERVICE_ASPECT_BEAN_NAME = "motorcycleServiceAspect";

    /**
     * The carServiceAdapterAspect() method is a factory method that creates and returns an instance of the CarServiceAdapterAspect class.
     * It is annotated with the @Bean annotation and has the name attribute set to "carServiceAspect".
     * The CarServiceAdapterAspect class is an aspect class that provides AOP (Aspect-Oriented Programming) functionality for the CarServiceAdapter class.
     * The aspect class contains advice methods that are executed before and after specific methods in the CarServiceAdapter class, allowing additional behavior to be applied.
     *
     * @return A new instance of the CarServiceAdapterAspect class.
     */
    @Bean(name = CAR_SERVICE_ASPECT_BEAN_NAME)
    public CarServiceAdapterAspect carServiceAdapterAspect() {
        return new CarServiceAdapterAspect();
    }

    /**
     * The truckServiceAdapterAspect() method is a factory method that creates and returns an instance of the TruckServiceAdapterAspect class.
     * It is annotated with the @Bean annotation and has the name attribute set to "truckServiceAspect".
     * The TruckServiceAdapterAspect class is an aspect class that provides AOP (Aspect-Oriented Programming) functionality for the TruckServiceAdapter class.
     * The aspect class contains advice methods that are executed before and after specific methods in the TruckServiceAdapter class, allowing additional behavior to be applied.
     *
     * @return A new instance of the TruckServiceAdapterAspect class.
     */
    @Bean(name = TRUCK_SERVICE_ASPECT_BEAN_NAME)
    public TruckServiceAdapterAspect truckServiceAdapterAspect() {
        return new TruckServiceAdapterAspect();
    }

    /**
     * The motorcycleServiceAdapterAspect() method is a factory method that creates and returns an instance of the MotorcycleServiceAdapterAspect class.
     * It is annotated with the @Bean annotation and has the name attribute set to "motorcycleServiceAspect".
     * The MotorcycleServiceAdapterAspect class is an aspect class that provides AOP (Aspect-Oriented Programming) functionality for the MotorcycleServiceAdapter class.
     * The aspect class contains advice methods that are executed before and after specific methods in the MotorcycleServiceAdapter class, allowing additional behavior to be applied
     * .
     *
     * @return A new instance of the MotorcycleServiceAdapterAspect class.
     */
    @Bean(name = MOTORCYCLE_SERVICE_ASPECT_BEAN_NAME)
    public MotorcycleServiceAdapterAspect motorcycleServiceAdapterAspect() {
        return new MotorcycleServiceAdapterAspect();
    }
}
