FROM maven:latest
WORKDIR /SportsTracker
COPY pom.xml /SportsTracker/
COPY . /SportsTracker/
RUN mvn package
CMD ["java", "-jar", "target/SportsTracker.jar"]
