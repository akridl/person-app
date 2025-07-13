#
# build stage
#
FROM maven:3.9.10-eclipse-temurin-21-alpine as builder
WORKDIR /build

COPY pom.xml .
COPY api/ api/
COPY client/ client/
COPY server/ server/
COPY runtime/ runtime/

RUN mvn clean install

#
# deploy stage
#
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
RUN chmod 777 .
EXPOSE 8080

ARG SERVICE
ARG SERVICE_JAR

COPY --chown=185 --from=builder "/build/${SERVICE}/target/${SERVICE_JAR}" app.jar
COPY --chown=185 entrypoint.sh .

USER 185
ENTRYPOINT ["./entrypoint.sh"]
