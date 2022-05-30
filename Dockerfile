FROM maven:3.5-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

COPY --from=build /home/app/target/NewsParser-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/local/lib/NewsParser-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/NewsParser-1.0-SNAPSHOT.jar"]