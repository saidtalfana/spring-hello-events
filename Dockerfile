FROM openjdk:21
EXPOSE 9000
ADD /target/Hello-Events.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]