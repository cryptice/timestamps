FROM java:8-jre

COPY src/environments/production/config.yml /opt/timestamps-application/
COPY target/timestamps-application.jar /opt/timestamps-application/

EXPOSE 8950
WORKDIR /opt/timestamps-application

CMD ["java", "-jar", "-Done-jar.silent=true", "timestamps-application.jar", "server", "config.yml"]
