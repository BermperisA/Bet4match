FROM adoptopenjdk/openjdk15:ubi
ENV APP_HOME=/Users/antonis/dev/demo
WORKDIR $APP_HOME
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]