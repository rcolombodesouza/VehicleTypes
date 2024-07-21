package com.register.vehicletype.adapter.observability.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "com.register.vehicletype.adapter.observability")
@PropertySource("classpath:/application-observability.properties")
public class ObservabilityConfig {

}
