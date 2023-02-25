FROM openjdk:11
EXPOSE 8080
ADD target/devops-automation-rxjava-1.0.0.jar devops-automation-rxjava-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/devops-automation-rxjava-1.0.0.jar"]