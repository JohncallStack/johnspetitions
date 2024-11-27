#Dockerfile to move application to a docker container, with a tomcat image,
#exposing port 9090 and running the applicatin.
FROM tomcat:latest
RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2
RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps
ADD target/*.war /usr/local/tomcat/webapps/
EXPOSE 9090
CMD ["catalina.sh", "run"]
