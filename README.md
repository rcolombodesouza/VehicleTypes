# VehicleTypes

The intention of this code is to use some resources related to Spring Boot.
The code is a simple REST api that manages vehicles into the database.
- Spring Boot 3.3.4
- Spring Aspects (AOP)
- Spring Boot Actuator
- JPA
- Spring cache with Redis 
- Liquibase
- Docker
- PostgreSQL
- OpenTelemetry
- Elasticsearch
- Kibana
- APM Server

The application is also configured to use APM Server, but for now, the Docker container is commented out.

In order to configure the vehicletype-observability-adapter, please include the following to the run configurations:

-javaagent:./vehicletype-observability-adapter/elastic-otel-javaagent-1.0.0.jar
-Dotel.exporter.otlp.endpoint:http://host.docker.internal:4318
-Dotel.service.name:vehicletype
