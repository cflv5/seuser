FROM openjdk:11-jre-slim-buster
RUN useradd -ms /bin/bash seuser
USER seuser
WORKDIR /home/seuser
COPY target/se-file.jar app.jar
ENTRYPOINT ["java","-jar","app.jar","-XX:+UseParallelGC -Xloggc:/home/seuser/gc.log -XX:+UseStringDeduplication -XX:+UseStringCache -XX:+OptimizeStringConcat"]