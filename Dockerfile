FROM openjdk:latest
COPY target/billing-service-0.0.1.jar billing-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/billing-service-0.0.1.jar"]