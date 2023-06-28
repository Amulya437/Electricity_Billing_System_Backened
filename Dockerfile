FROM openjdk:18
EXPOSE 8080
ADD ./Electricity1.jar electricity1.jar
ENTRYPOINT ["java","-jar","/electricity1.jar"]