FROM openjdk:17-oracle

COPY ./build/libs/CI-CD-Beesang-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]