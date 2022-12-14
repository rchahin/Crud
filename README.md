# Crud
importar examenpromerica.sql para crear Base de Datos en Mysql

Clonar proyecto usando el siguiente link https://github.com/rchahin/Crud.git

Importar proyecto Java desde Eclipse / Spring Boot

Ejecutar el proyecto y usar los siguientes Endpoints
Obtener Productos
GET http://localhost:9090/api/producto
Crear Productos
POST http://localhost:9090/api/producto
BODY
{
        "nombres": "producto",
        "descripcion": "producto 1",
        "precio": 1000.00
}

Actualizacion de Productos
PUT http://localhost:9090/api/producto/{codigo producto}
{
        "nombres": "nuevo nombre",
        "descripcion": "nueva descripcion",
        "precio": 10000.0,
        "estado": "A"
}

Eliminar productos
DELETE http://localhost:9090/api/productos/{codigo producto}



