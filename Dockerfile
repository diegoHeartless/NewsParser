FROM openjdk:8-jdk-alpine as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

COPY --from=build /home/app/target/NewsParser-1.0-SNAPSHOT.jar /usr/local/lib/NewsParser-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/NewsParser-1.0-SNAPSHOT.jar"]