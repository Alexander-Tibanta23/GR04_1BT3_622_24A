FROM maven:3.8.5-openjdk-17-slim as build
COPY . /usr/GR04_1BT3_622_24A
WORKDIR /usr/GR04_1BT3_622_24A
RUN mvn clean install
RUN mvn package

FROM bitnami/tomcat:10.1.23 as serve
COPY --from=build /usr/GR04_1BT3_622_24A/target/GR04_1BT3_622_24A-1.0-SNAPSHOT.war /opt/bitnami/tomcat/webapps
EXPOSE 8092
CMD ["catalina.sh", "run"]