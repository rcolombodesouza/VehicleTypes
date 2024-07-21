package com.register.vehicletype.adapter.http.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "com.register.vehicletype.adapter.http")
@PropertySource("classpath:/application-http.properties")
public class HttpAdapterConfig {
}
