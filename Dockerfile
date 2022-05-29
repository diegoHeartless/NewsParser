FROM openjdk:8-jdk-alpine
COPY target/NewsParser-1.0-SNAPSHOT.jar NewsParser-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/NewsParser-1.0-SNAPSHOT.jar"]