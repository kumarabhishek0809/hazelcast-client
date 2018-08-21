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

INSERT INTO "CACHE"."TICKET" ("TICKET_ID", "BOOKING_DATE", "DESTINATION_STATION", "EMAIL", "PASSENGER_NAME", "SOURCE_STATION") VALUES ((SELECT MAX(TICKET_ID) + 1 FROM TICKET ) , TO_DATE('2017-07-19 11:41:36', 'YYYY-MM-DD HH24:MI:SS'), 'PUNE', 'KUMAR.ABHISHEK0809@GMAIL.COM', 'KUMAR', 'DELHI');



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




docker build -f /home/vaishnavi/IdeaProjects/spring-boot-cache-docker/src/main/docker/Dockerfile -t spring-boot-cache .
docker rmi -f image spring-boot-cache
docker images 
docker run -p 9192:9192 spring-boot-cache:latest
