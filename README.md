# Yandex-temperature
Yandex-temperature is Java Spring boot application, designed as REST service to show today's temperature. Service has a single endpoint `/weather`, which works up request and gets today's temperature from database if it exists, or else extract this value from web page yandex.ru.

## Run
### Prerequisites
- Java 11 + Maven
- Postgres database

### Relevant properties
This service uses Postgres database
```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres?ssl=false&serverTimezone=UTC
spring.datasource.username=postgres
spring.datasource.password=mysecretpassword
spring.datasource.driver-class-name=org.postgresql.Driver
```

###Request

This service processes GET method of HTTP request
```
GET http://localhost:8080/weather
```

###Response

```
{
  "date": "2022-01-08",
  "temperature": "−10"
}
```