FROM openjdk:8-jdk-alpine
RUN maven package
COPY target/NewsParser-1.0-SNAPSHOT.jar NewsParser
ENTRYPOINT ["java","-jar","/NewsParser-1.0-SNAPSHOT.jar"]