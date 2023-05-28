FROM amazoncorretto:19-alpine-jdk
COPY target/api-drogeria-pruebav1_0-0.0.1-SNAPSHOT.jar MY_API.jar
ENTRYPOINT [ "java","-jar","/MY_API.jar" ]