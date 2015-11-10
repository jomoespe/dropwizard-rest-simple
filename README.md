# Dropwizard REST simple

Ejemplo de una aplicación sencilla construida con Dropwizard. 


## Entorno

 - JDK Java 8, instalado y configurado en el path
 - Maven 3.2.x


## Construcción

    ${project_home}/mvn clean package


## Ejecución

### Arranque de la aplicación

    ${project_home}/java -jar target/helloworld.jar server

### Acceso a la aplicación

La aplicación expone dos endpoints:

 - [http://localhost:<port>/hi[?name=a_name]](http://localhost:8080/hi?name=a_name): Devuelve el 
   siguiente contenido (como text/plain): **hello <unknown>**. El puerto, por defecto es 8080.


##  Docker

El proyecto incluye una posibilidad de generar un contenedor Docker. Para ello docker ha de estár
instalado en la máquina y configurado para poder ser eejcutado con el usuario (no ha de requerir 
permisos de super usuario).

### Construcción del contenedor

    mvn clean package docker:build

### Ejecución del docker

    docker run [--rm] [-ti] [-p 8080:8080] helloworld

