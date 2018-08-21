FROM openjdk:10-jdk
ADD /build/libs/spring-boot-cache-0.0.1-SNAPSHOT.jar spring-boot-cache.jar
EXPOSE 9192:9192
ENTRYPOINT ["java","-Dserver.port=9192","-jar","spring-boot-cache.jar"]