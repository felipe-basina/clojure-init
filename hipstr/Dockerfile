FROM openjdk:8-alpine

COPY target/uberjar/hipstr.jar /hipstr/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/hipstr/app.jar"]
