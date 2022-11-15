FROM openjdk:8
ADD ejercicio6_microservicio_formacion.jar ejercicio6_microservicio_formacion.jar
ENTRYPOINT ["java","-jar","/ejercicio6_microservicio_formacion.jar"]
