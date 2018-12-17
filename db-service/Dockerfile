FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
COPY ./entrypoint.sh entrypoint.sh
RUN chmod +x entrypoint.sh && mkdir /logs
COPY ./build/db-service-1.0.0.jar db-service.jar
ENTRYPOINT ["./entrypoint.sh"]