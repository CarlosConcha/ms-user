# ms-user

  

### Dependencias

|| versión |
| ------------ | ------------ |
| Gradle | 8.5 |
| Java | 17 |
| Spring Boot | 3.2.3 |

#### Script Sql
Se ejecuta automaticamente al levantar el proyecto
[abrir script](./src/main/resources/schema.sql)

### Ejecuta test
En la carpeta del proyecto abrir la consola y ejecutar el comando.

**gitbash**
```sh
./gradlew clean test
```
**CMD**
```sh
gradlew clean test
```

### Como probar

Para  poder  ejecutar el proyecto  se  debe  ir a la  carpeta ms-user, Abrir  la  consola y ejecutar el comando.

**gitbash**
```sh
./gradlew bootRun
```
**CMD**
```sh
gradlew bootRun
```
### Consola h2

http://localhost:8080/h2-console
```sh
JDBC URL: jdbc:h2:mem:testdb
usuario: sa
contraseña: password
```

### Swagger3

| | URL |
| ------------ | ------------ |
| Swagger UI | http://localhost:8080/swagger-ui/index.html |
| Apidocs| http://localhost:8080/v3/api-docs |


### Entrada y Salida

> El campo contraseña del request debe contener entre 4 a 8 caracteres y
> 1 a 3 números para ser valido. La expresion regular puede ser modificada en las properties *app.password.regex*

##### request url

POST http://localhost:8080/api/v1/user

##### cURL

```sh

curl --location 'localhost:8080/api/v1/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "carlos jesyus",
    "email": "carldar@r.cl",
    "password": "bazoad44",
    "phones": [
        {
            "number": "12345678",
            "city_code": "52",
            "country_code": "1"
        },
        {
            "number": "12345689",
            "city_code": "52",
            "country_code": "1"
        }
    ]
}'

```

##### response - 201

```json
{

"usuario": {

"id": "2f35578e-2c4e-4dc6-b913-ed0a0bf3fc1e",

"created": "2024-02-29T23:58:25.362357",

"token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjaGFsbGVuZ2UtbmlzdW0iLCJleHAiOjE3MDkyNjI1MDUsInN1YiI6IjJmMzU1NzhlLTJjNGUtNGRjNi1iOTEzLWVkMGEwYmYzZmMxZSIsImlhdCI6MTcwOTI2MTkwNX0.2Dk5ngou7sBQfnOjwaaMWYkcoXzwy17o9R80SJamP50",

"last_login": "2024-02-29T23:58:25.362357",

"isactive": true

}

}
```
### Diagrama de flujo

![diagrama de flujo ms-user](https://github.com/CarlosConcha/ms-user/blob/main/diagrama_flujo.jpg)
