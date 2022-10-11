FROM openjdk:11
EXPOSE 8080
COPY /target/hotel-api.jar hotel-api.jar
ENTRYPOINT ["java","-jar","/hotel-api.jar"]