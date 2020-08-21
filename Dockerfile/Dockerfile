FROM centos

run yum install -y java

VOLUME /tmp
ADD /spring-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:dev/./urandom", "-jar", "/myapp.jar"]