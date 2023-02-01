FROM tomcat:10.1.5-jre17-temurin-jammy
COPY /target/ms1.war /usr/local/tomcat/webapps
COPY postgresql-42.5.1.jar /usr/local/tomcat/lib
EXPOSE 8080
CMD ["catalina.sh","run"]