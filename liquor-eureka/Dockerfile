FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER 1064275075@qq.com

VOLUME /data/logs

ADD target/liquor-eureka.jar liquor-eureka.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","liquor-eureka.jar"]

