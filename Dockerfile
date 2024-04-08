FROM 10.10.102.113:8443/library/zeus-base:1.2.0
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo "Asia/Shanghai" > /etc/timezone
COPY dubbodo-0.0.1-SNAPSHOT.jar  /bootconsumer.jar

ENTRYPOINT [ "sh", "-c", "java -jar $JAVA_OPTS /bootconsumer.jar" ]