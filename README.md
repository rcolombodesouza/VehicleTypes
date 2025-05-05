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

To configure the vehicletype-observability-adapter, please include the following to the run configurations:

-javaagent:./vehicletype-observability-adapter/opentelemetry-javaagent.jar
-Dotel.exporter.otlp.endpoint=http://localhost:4318
-Dotel.service.name=vehicletype
The localhost mention above must be changed to the place where your elasticsearch is running 
(In my case it is running on localhost, but in a docker container. So I have to use the IP address of the docker container).


For the docker-compose file, please define the values for the following environment variables:
- DB_PASSWORD
- DB_USERNAME
- ELASTICSEARCH_PASSWORD
- PGADMIN_DEFAULT_EMAIL
- PGADMIN_PASSWORD


To run the Spring application, you also need to define the following environment variables:
- DB_PASSWORD
- DB_URL
- DB_USERNAME