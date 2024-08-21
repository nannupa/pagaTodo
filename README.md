# pagaTodo
Evaluación, se creo un proyecto con servicios rest con CRUD básico para administrar empleados 

Pasos de instalación

1.- Ejecutar el script BDpagaTodo.sql para crear la base de datos.
2.- Descargar zip de este repositorio (https://github.com/nannupa/pagaTodo).
3.- Importar proyecto en eclipse.
4.- Agregar servidor tomat 10.1.
5.- Modificar propiedad "spring.datasource.url" del archivo aplication.properties por "spring.datasource.url=jdbc:postgresql://localhost:5432/pagaTodo2" (por el cambio de nombre dela base de datos).
6.- Desplegar proyecto.
7.- Probar en postman.
      Elemplos
      Alta
      POST http://localhost:8080/pagaTodo/emp/v1/empleadoAlta
      En la pestaña Authorization seleccionar Auth Type: Basic Auth, username: admin, password: password
      En la pestaña Body seleccionar raw y JSON
      Payload
      {
      "dep_id":1,
      "emp_nombre":"Rodrigo",
      "emp_puesto":"Vendedor"
      }
      
      Actualización
      PUT http://localhost:8080/pagaTodo/emp/v1/empleado/1
      Donde el ultimo número es el identificador del empleado
      En la pestaña Authorization seleccionar Auth Type: Basic Auth, username: admin, password: password
      En la pestaña Body seleccionar raw y JSON
      Payload
      {
      "emp_id": 1,
      "dep_id":1,
      "emp_nombre":"Angel",
      "emp_puesto":"Administrador"
      }
      
      Borrado
      DELETE http://localhost:8080/pagaTodo/emp/v1/empleado/1
      Donde el ultimo número es el identificador del empleado
      En la pestaña Authorization seleccionar Auth Type: Basic Auth, username: admin, password: password
      
      Consultar por id
      GET http://localhost:8080/pagaTodo/emp/v1/empleado/1
      Donde el ultimo número es el identificador del empleado
      En la pestaña Authorization seleccionar Auth Type: Basic Auth, username: user, password: password

      Consultar todos
      GET http://localhost:8080/pagaTodo/emp/v1/empleados
      En la pestaña Authorization seleccionar Auth Type: Basic Auth, username: user, password: password
8.- Comprobar cambios en la base de datos.
