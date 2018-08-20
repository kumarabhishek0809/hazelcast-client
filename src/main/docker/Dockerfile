FROM java:8
ADD spring-boot-cache-0.1.3.jar spring-boot-cache.jar
EXPOSE 9192:9192
ENTRYPOINT ["java ","-Dserver.port=9192","-jar","spring-boot-cache.jar"]

