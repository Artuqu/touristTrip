FROM openjdk:21-ea-12-jdk-oraclelinux8
ADD target/touristTrip-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar touristTrip-0.0.1-SNAPSHOT.jar
