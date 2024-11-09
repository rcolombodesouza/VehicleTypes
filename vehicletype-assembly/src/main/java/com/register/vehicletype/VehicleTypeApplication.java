package com.register.vehicletype;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * The VehicleTypeApplication class is a Spring Boot application that serves as the entry point of the application.
 * It initializes and runs the Spring Boot application.
 */
@SpringBootApplication
public class VehicleTypeApplication {

    /**
     * The main method is the entry point of the application.
     * It initializes and runs the Spring Boot application.
     *
     * @param args The command line arguments passed to the application
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(VehicleTypeApplication.class).setAddConversionService(true).run(args);
    }
}
