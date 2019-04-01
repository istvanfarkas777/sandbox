FROM openjdk:11.0.2-jdk-oraclelinux7

ARG SERVICE=foo

ENV BASEDIR=/app
ENV SERVICE=${SERVICE}

#RUN apt-get --no-cache add bash curl vim less

ADD ./build/libs/${SERVICE}.jar ${BASEDIR}/${SERVICE}.jar

EXPOSE 8080

CMD java ${JAVA_OPTS} -jar ${BASEDIR}/${SERVICE}.jar
