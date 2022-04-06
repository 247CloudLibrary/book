FROM openjdk:11
ARG JAR_FILE=./build/libs/book-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]