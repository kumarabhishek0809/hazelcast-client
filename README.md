@https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-caching.html 


# spring-boot-docker
spring-boot-docker
docker run --name centos -v c:/Data/centos:/var/lib/centos -d centos tail -f /dev/null

docker exec -it centos bash

docker run -p 9090:9090 -d kumarabhishek0809/spring-boot-docker:0.1.2

docker run -v c:/data:/data centos ls /data

C:\SelfStudy\workspace\spring-boot-docker\src\main\docker>docker>docker build -t spring-boot-docker .


-------------------For Oracle Set Up --------------------
 docker exec -it oracleDB bin/bash
root@eb368f64b8d5:/# sqlplus

SQL*Plus: Release 12.1.0.2.0 Production on Sun Aug 19 11:05:38 2018

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

Enter user-name: system
Enter password: 
Last Successful login time: Sat Aug 11 2018 17:21:51 +00:00

Connected to:
Oracle Database 12c Standard Edition Release 12.1.0.2.0 - 64bit Production

SQL> create table ticket (ticket_id number,booking_date date,destination_station varchar2(255),email varchar2(255),passenger_name varchar2(255),source_station varchar2(255));


INSERT INTO "CACHE"."TICKET" ("TICKET_ID", "BOOKING_DATE", "DESTINATION_STATION", "EMAIL", "PASSENGER_NAME", "SOURCE_STATION") VALUES (1, TO_DATE('2017-07-19 11:41:36', 'YYYY-MM-DD HH24:MI:SS'), 'PUNE', 'KUMAR.ABHISHEK0809@GMAIL.COM', 'KUMAR', 'DELHI');

INSERT INTO "CACHE"."TICKET" ("TICKET_ID", "BOOKING_DATE", "DESTINATION_STATION", "EMAIL", "PASSENGER_NAME", "SOURCE_STATION") VALUES ((SELECT NVL(MAX(TICKET_ID),0) + 1 FROM TICKET ) , TO_DATE('2017-07-19 11:41:36', 'YYYY-MM-DD HH24:MI:SS'), 'PUNE', 'KUMAR.ABHISHEK0809@GMAIL.COM', 'KUMAR', 'DELHI');



--------------------------------
----------------------------------------------------------------------------------
getTicketById::
http://localhost:9192/api/tickets/ticket/{ticketId}
----------------------------------------------------------------------------------
deleteTicket::
http://localhost:9192/api/tickets/ticket/{ticketId}
----------------------------------------------------------------------------------
updateTicket::
http://localhost:9192/api/tickets/ticket/{ticketId}/{newEmail:.+}

Introducing Kitematic.
docker run -d centos tail -f /dev/null
docker exec -it wonderful_lamarr

docker login
gradle buildDocker -Ppush

docker build -f /home/vaishnavi/IdeaProjects/spring-boot-cache-docker/src/main/docker/Dockerfile -t spring-boot-cache-9190 .
docker inspect oracleDB .
docker images 


#For multiple servers.
#Change  into Dockerfile for port.
docker rmi -f image spring-boot-cache-9191
docker build -f /home/vaishnavi/IdeaProjects/spring-boot-cache-docker/src/main/docker/Dockerfile -t spring-boot-cache-9191 .
docker run -p 9190:9190 spring-boot-cache-9190:latest



docker rmi -f image spring-boot-cache
docker build -f /home/vaishnavi/IdeaProjects/spring-boot-cache-docker/src/main/docker/Dockerfile -t spring-boot-cache-9191 .
docker run -p 9191:9191 spring-boot-cache-9191:latest

-------------------------Intializing Hazel Cast.
https://www.youtube.com/watch?v=-_OY-cI0WO4

https://hub.docker.com/r/hazelcast/hazelcast/
docker pull hazelcast/hazelcast
docker run --name hazelcast-5701 -p 5701:5701 hazelcast/hazelcast:latest
docker run --name hazelcast-5702 -p 5702:5702 hazelcast/hazelcast:latest
#172.17.0.3
#172.17.0.4
$ docker run -e JAVA_OPTS="-Dhazelcast.local.publicAddress=<host_ip>:5701" -p 5701:5701 hazelcast/hazelcast
$ docker run -e JAVA_OPTS="-Dhazelcast.local.publicAddress=<host_ip>:5702" -p 5702:5701 hazelcast/hazelcast 

docker pull hazelcast/management-center
docker run --name hazelcastManager -p hazelcast/management-center:latest
http://localhost:32774/hazelcast-mancenter/login.html
https://stackoverflow.com/questions/20385973/how-do-you-programmatically-configure-hazelcast-for-the-multicast-discovery-mech
