# Usar una imagen base de Maven para construir la aplicación
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app

# Copiar el archivo pom.xml y las dependencias de Maven
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente y construir la aplicación
COPY ../src /app/src
RUN mvn package -DskipTests

FROM openjdk:17.0-jdk
WORKDIR /app

# Copiar el archivo JAR de la fase de construcción
COPY --from=build /target/GR04_1BT3_622_24A-1.0-SNAPSHOT-jar-with-dependencies.jar ./

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8092

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "GR04_1BT3_622_24A-1.0-SNAPSHOT-jar-with-dependencies.jar"]