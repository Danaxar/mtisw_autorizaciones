call mvnw clean install -DskipTests
call docker build -t danaxar/autorizaciones-microservice .
call docker push danaxar/autorizaciones-microservice