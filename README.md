# organizers-backend


Spring Boot backend for the Organizer registration + searchable dropdown assignment.


## Features implemented
- POST `/api/organizers` to create organizers with validation and organizerCode generation (ORG00001...)
- GET `/api/organizers/{id}` to fetch a single organizer
- GET `/api/organizers/search?q=...&page=&size=` to search by name/email/phone (partial, case-insensitive) with pagination
- Global exception handling (validation, custom ApiError)
- H2 in-memory DB for quick testing


## Run (Maven)
```
./mvnw spring-boot:run
```
or
```
mvn spring-boot:run
```


Server runs on `http://localhost:8080`.


## Notes
- Organizer code generator uses last saved id to build the next code (sufficient for demo). For production use, prefer DB sequence or distributed id generator.
- You can export H2 console by enabling spring.h2.console.enabled=true in application.yml.
