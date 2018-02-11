FROM java:8
VOLUME /tmp
ADD cars.jar cars.jar
RUN bash -c 'touch /cars.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/cars.jar"]