FROM tomcat:11.0

COPY target/fr.businessCase-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war
