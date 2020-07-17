
### Contexto General:

- El negocio nos pide desarrollar una aplicación que de soporte a consultas
en una interaccion entre clientes que ingresan una consulta a la plataforma y
tecnicos que resuelven el problema mediante un chat en linea. Luego de resolver
el problema, se realiza un pago al técnico y el cliente tiene la opción de
calificar la atención.


### Detalles de la APP:

* Tecnologías utilizadas:
	- Springboot: Framework para desarrollar la API,
	gestión de datos y comunicación entre clientes y
	servidores de la aplicación.
	- PostgreSQL: Sistema de gestión de bases de datos.
	- Phonegap: Framework para desarrollar clientes Web y/o móviles.
	- JPA y Hibernate: Mapeo objeto-relacional (ORM), en el servidor de la aplicación.
	- Bootstrap: Biblioteca multiplataforma o conjunto de herramientas de código abierto para diseño de sitios y aplicaciones web.
	- JQuery: Biblioteca multiplataforma de JavaScript, que permite simplificar la manera de interactuar con los documentos HTML, manipular el árbol DOM, manejar eventos, desarrollar animaciones y agregar interacción con la técnica AJAX a páginas web.​

### Carpetas:
En la entrega anterior exitstian 2 carpetas InstanTecnic_APP e InstanTecnic_API, pero para esta entrega, dado que la aplicacion se realizo practicamente desde cero, pues el anterior avance no se acomodaba mucho a lo que se queria realizar, se definieron dos nuevas carpetras Backend y Frontend. De ahora en adelante se trabajara en estas carpetas.

	Carpetas antiguas (no se utilizaran mas, deben ignorarse):
		- InstanTecnic_APP
		- InstanTecnic_API
	Carpetas actuales (son las que se utilizaran hasta finalizar el proyecto, aqui se encontrara la ENTREGA 3 y la ENTREGA 4):
		- Backend: Aqui se encuentra el backend de la aplicacion.
		- Frontend: Aqui se encuentra el frontend de la aplicacion.
	* *Dentro de cada carpeta hay más detalle de su contenido*.


### Autentificacion:
#### 1. Recibir token:
- **Definición:** `POST /autentificar`
- **Cuerpo:**
```JSON
{
	"username": "usuario",
	"password": "contraseña"
}
```
- **Respuesta:**
```JSON
{
    "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZWJhIiwiZXhwIjoxNTc2NzY4MzIwLCJpYXQiOjE1NzY3MzIzMjB9.amR-byoeVUv65J7J6rsRQl9VH9aGVCRvQMdBbzzZhKQ"
}
```

#### 2. Crear usuario:
- **Definición:** `POST /crear`
- **Cuerpo:**
```JSON
{
	"username": "usuario",
	"password": "contraseña",
	"tipo": "Cliente"
}
```

#### 3. Obtener tipo de Usuario:
Retorna el tipo de usuario que inicio sesion (Cliente o Tecnico)
- **Definición:** `GET /autentificar2`
- **Header:**
```
Authorization: Bearer <jwt>
```
- **Respuesta:** String tipo

#### 4. Obtener id:
Retorna el id del usuario que inicio sesion.
- **Definición:** `GET /ObtenerId`
- **Header:**
```
Authorization: Bearer <jwt>
```
- **Respuesta:** Long id

### Mensajes
#### 1. Añadir mensaje:
- **Definición:** `POST /v1/mensaje/mensaje`
- **Header:**
```
Authorization: Bearer <jwt>
```
- **Cuerpo:**
```JSON
{
    "consulta": 1,
    "mensaje":"hola mundo",
}
```
- **Respuesta:** booleano

#### 2. Listar mensajes:
- **Definición:** `GET /v1/mensaje/{consulta}/{id}`\
Donde _id_ representa el id del último mensaje leido en la _consulta_.
- **Header:**
```
Authorization: Bearer <jwt>
```
- **Respuesta:**
```JSON
[
    {
        "id": 1,
        "mensaje": "hola mundo",
        "consulta": 1,
        "emisor": 1
    },
    {
        "id": 2,
        "mensaje": "nose que poner",
        "consulta": 1,
        "emisor": 2
    }
]
```

### Consultas:
#### 1. Listar consultas:
A partir del JWT se listan las consultas asociadas a ese usuario.
- **Definición:** `GET /v1/consulta/consultas`
- **Header:**
```
Authorization: Bearer <jwt>
```
- **Respuesta:**
```JSON
[
  {
        "id": 1,
        "tecnico": 1,
    	"cliente": 2,
		"titulo": "titulo",
		"descripcion": "descripcion",
		"categoria": "categoria",
		"aceptada": "SI"
  }
]
```

#### 2. Crear consulta:
- **Definición:** `POST /v1/consulta/consulta`
- **Header:**
```
Authorization: Bearer <jwt>
```
- **Cuerpo:**
```JSON
{
    "tecnico": 1,
    "cliente": 2,
		"titulo": "titulo",
		"descripcion": "descripcion",
		"categoria": "categoria"
}
```
- **Respuesta:** booleano

#### 3. Listar consultas no aceptadas:
Lista solamente aquellas consultas que no han sido aceptadas
- **Definición:** `POST /v1/consulta/consultatec`
- **Header:**
```
Authorization: Bearer <jwt>
```
- **Respuesta:** booleano

## Instrucciones de Ejecución:
- Abrir carpeta Backend
- Compilar: `mvn install`
- Ejecutar: `mvn spring-boot:run`
- Abrir aplicacion de Phonegap para PC
- Abrir la carpera Frontend en Phonegap
- Iniciar el proyecto en Phonegap
- Abrir el index de la pagina a traves de Phonegap apretando la IP que se muestra en la parte inferior de la aplicacion

## Consideraciones:
- Se esta ejecutando en el puerto `8000`
- Las instrucciones de compilacion son para ejecutar desde un computador
- Dado que la aplicacion se reformo practicamente completa, pues el avance anterior no se ajustaba muy bien a los requerimientos y resultaba muy incomo trabajar con el, los nuevos archivos se encuentran en las carpetas Backend y Frontend. Las carpetas InsanTecnic_API e InstanTecnic_App corresponden a versiones antiguas.
- Al iniciar dos sesiones en el mismo navegador, este puede reemplazar los datos del local storage por los de la otra sesion, entonces el funcionamiento tanto del chat como del resto de la app puede no ser el correcto. Aun así, esta app no esta diseñada para correr en varias cuentas simultaneas en un mismo dispositivo, si no que esta pensada para correr simultáneamente en varios dispositivos.

## Requisitos Previos:
- Crear la Base de Datos con sus respectivas tablas, para el caso de esta Demo las tablas estan en el archivo `tablas.sql`.
- Se debe colocar todos los datos de la bd y del usuario de postgres en el archivo Backend/main/resources/aplication.properties
- Se debe tener instalado Phonegap para PC
