# Proyecto para Back End II (Digital Media - Seguridad con Keycloak)
## Especificaciones para correr el proyecto

En la carpeta del proyecto, en la ubicación del archivo docker-compose.yml se debe crear la red definida para los contenedores con el comando:

> docker network create local-keycloak

Luego levantamos los contenedores con el comando:

> docker-compose up

Éste va a generar los contenedores con las imágenes que necesitamos de:

- **Keycloak**: el IAM que vamos  a usar con la importación de las configuraciones, desde el archivo realm-export.json,  para generar el realm **DigitalMedia** con los client, groups, scopes, y todo lo necesario para gestionar la autenticación y los permisos. Además se le configuró una base de datos Postgres para la persistencia.
- **MogoDB**: para que los microservicios de movies-service y users-service tengan su persistencia allí.

Una vez que se levantan los contenedores, desde el Ide que estemos usando, comenzamos a levantar los microservicios en el siguiente orden:

1. eureka-service
2. config-service
3. gateway-service
4. movies-service 
5. users-service 
6. ms-bill

En caso de que se produzca un error en la conexión se puede probar de volver a generar las credenciales de los client: internal, microservicios y api-gateway en la consola de administración de Keycloak (a la cual accedemos con el usuario: admin, password: admin), y luego procedemos a cambiar las credenciales configuradas en los application.yml de los microservicios: api-gateway, movies-service, users-service y ms-bill, según correspondan, y en las variables de entorno de postman, cuando se haga la importación de los test que se adjuntan en el archivo Test Realm DigilalMedia.postman_collection.

#### - Panel Administración Keycloak:

> http://localhost:8082

**username**: admin

**password**: admin

#### - Eureka

> http://localhost:8761

#### - API Gateway

> http://localhost:8080

El gateway mapea a users-service y a movies-service. Por lo que es su punto de acceso y solo se puede acceder a ellos por medio del navegador ya que está configurado para la redirección al login de Keycloak para efectuar  la autenticación y remitir las credebciales a los microservicios que gestionan la autorización por medio del TokenRelay.
Por tal motivo solo se presentan test en Postman del microservicio ms-bill, que es el único que no es mapeado por el gateway. 

Para poder acceder a los endpoint de movies-service y users-service usamos un navegador y nos logueamos con los usuarios correspondientes. La autorización de los endpoint de los microservicios está basada en grupos, por lo que hay que iniciar sesión con el usuario que pertenezca al grupo que tiene permiso, de lo contrario nuestra petición va a ser rechazada.
Para ello es que se genera, cuando se levanta el microservicio de users-service, 3 usuarios que pertenecen a los 3 grupos con los que se trabaja:

#### Usuario Admin:
username: admin

password: admin

group: admin

#### Usuario Client:
username: client

password: client

group: client

#### Usuario Provider:
username: provider

password: provider

group: provider


## Endpoints de consulta en el navegador:

**Movies-service:**
- Listar todas las películas [GROUPS: CLIENT o ADMIN]:
> http://localhost:8080/movies

- Película por Id [GROUPS: CLIENT o ADMIN]:
> http://localhost:8080/movies/{id}

**Users-service:**
- Listar todos los usuarios que no pertenezcan al grupo admin desde Keycloak [GROUPS: ADMIN]:
> localhost:8080/users/admin

- Listar todos los usuarios por first name desde Keycloak [GROUPS: ADMIN]:
> localhost:8080/users/keycloak/{firstName}

- Listar todos los usuarios por username desde Keycloak [GROUPS: ADMIN o PROVIDER o CLIENT]:
> localhost:8080/users/find/{username}

- Usuario por id desde Keycloak [GROUPS: ADMIN]:
> localhost:8080/users/keycloak/id/{id}

- Agregar el atributo nationality a un Usuarios por id en Keycloak [GROUPS: ADMIN]:
> localhost:8080/users/keycloak/{id}/{nationality}

### Los puertos que se utilizan son:

- eureka-service: 8761
- config-service: 8888
- api-gateway: 8080
- movies-service: 8085
- ms-bill: 8086
- users-service: 8087
- Keycloak: 8082
- MongoDB: 27017
- Postgres: 5439

En la colección de Postman también adjunto algunos endpoint de prueba sacados de la documentación con los que me guié para el desarrollo y la conexión con la api de Keycloak.

