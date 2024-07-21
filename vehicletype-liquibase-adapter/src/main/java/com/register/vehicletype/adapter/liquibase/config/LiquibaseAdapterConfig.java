package com.register.vehicletype.adapter.liquibase.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "com.register.vehicletype.adapter.liquibase")
@PropertySource("classpath:/application-liquibase.properties")
public class LiquibaseAdapterConfig {
}
