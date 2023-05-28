FROM amazoncorretto:19-alpine-jdk

COPY C:\Users\Carde\Documents\workspace-spring-tool-suite-4-4.18.0.RELEASE\api-drogeria-pruebav1_0\target\api-drogeria-pruebav1_0-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java","-jar","/app.jar" ]