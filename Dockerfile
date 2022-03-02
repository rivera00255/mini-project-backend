FROM openjdk:11.0.13-jre
COPY ./build/libs/moduleproject3-0.0.1-SNAPSHOT.jar /moduleproject3.jar
CMD java -jar /moduleproject3.jar