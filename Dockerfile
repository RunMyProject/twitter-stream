FROM openjdk:8-jdk-alpine
ADD target/twitter-stream-0.0.1-SNAPSHOT.jar twitter-stream.jar
ENV JAVA_OPTS=""
ENTRYPOINT /bin/sh
