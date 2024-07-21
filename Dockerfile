#FROM eclipse-temurin:21-jre
#
#ADD vehicletype-assembly/target/vehicletype-assembly-0.0.1-SNAPSHOT.jar /vehicletype.jar
#ADD vehicletype-observability-adapter/target/opentelemetry/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar
#ADD vehicletype-observability-adapter/target/opentelemetry/opentelemetry-exporter-jaeger.jar /opentelemetry-exporter-jaeger.jar
#
#ENTRYPOINT java -javaagent:/opentelemetry-javaagent.jar \
#                -jar vehicletype.jar
