FROM eclipse-temurin:21

WORKDIR /app

COPY target/spring-petclinic-3.4.0-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]