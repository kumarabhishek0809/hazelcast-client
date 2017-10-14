# spring-boot-docker
spring-boot-docker
docker run --name docker-mysql -e MYSQL_ROOT_PASSWORD=root -v c:/Data/mysql:/var/lib/mysql -p 3306:3306 -d mysql

docker run --name centos -v c:/Data/centos:/var/lib/centos -d centos tail -f /dev/null

docker exec -it centos bash

docker run -p 9090:9090 -d kumarabhishek0809/spring-boot-docker:0.1.2

docker run -v c:/data:/data centos ls /data

C:\SelfStudy\workspace\spring-boot-docker\src\main\docker>docker>docker build -t spring-boot-docker .
