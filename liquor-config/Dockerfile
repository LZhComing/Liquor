FROM anapsix/alpine-java:8_server-jre_unlimited

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /liquor-config

WORKDIR /liquor-config

EXPOSE 4001

ADD ./liquor-config/target/liquor-config.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar liquor-config.jar
