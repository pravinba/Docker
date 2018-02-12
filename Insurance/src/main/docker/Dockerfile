FROM java:8
VOLUME /tmp
ADD insurance.jar insurance.jar
RUN bash -c 'touch /insurance.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/insurance.jar"]