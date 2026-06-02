# Pokemon Search API

A Spring Boot REST API developed as part of the **Finfactor Technologies Coding Challenge**. This service fetches Pokemon data from PokeAPI, caches responses for improved performance, and exposes clean RESTful endpoints for frontend consumption.

---

## Features

* Search Pokemon by name
* Integration with PokeAPI
* RESTful API design
* Caffeine-based caching
* Cache expiry handling
* Maximum cache size management
* Swagger/OpenAPI documentation
* Global exception handling
* Input validation
* CORS configuration
* Layered architecture for maintainability and extensibility

---

## Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Web
* Spring Cache
* Caffeine Cache
* SpringDoc OpenAPI (Swagger)
* Maven

---

## Architecture

```text
Controller
    ↓
Service
    ↓
PokeAPI Client
    ↓
PokeAPI
```

---

## API Documentation

Swagger UI is available after starting the application:

```text
http://localhost:8080/swagger-ui/index.html
```

Swagger provides:

* Endpoint documentation
* Request and response schemas
* Interactive API testing
* Error response documentation

---

## API Endpoints

### Get Pokemon Details

```http
GET /api/pokemon/{name}
```

### Example Request

```http
GET /api/pokemon/pikachu
```

### Example Response

```json
{
  "name": "pikachu",
  "height": 4,
  "weight": 60,
  "baseExperience": 112,
  "types": [
    "electric"
  ],
  "abilities": [
    "static",
    "lightning-rod"
  ]
}
```

---

## Cache Configuration

The application uses Caffeine Cache to improve performance and reduce repeated calls to PokeAPI.

| Configuration   | Value              |
| --------------- | ------------------ |
| Cache Provider  | Caffeine           |
| Maximum Entries | 100                |
| Expiry Policy   | 10 Minutes         |
| Cache Strategy  | Automatic Eviction |

### Benefits

* Faster response time for repeated requests
* Reduced vendor API calls
* Automatic cache eviction
* Improved application performance

---

## Error Handling

The application handles common failure scenarios gracefully.

### Supported Scenarios

* Empty Pokemon name
* Invalid Pokemon name
* Pokemon not found
* Vendor API failure
* Network timeout
* Invalid requests
* Cache expiration
* Cache overflow/eviction

### Example Error Response

```json
{
    "message": "Pokemon not found: {invalid name}",
    "success": false
}
```

---

## Running the Application

### Clone Repository

```bash
git clone <YOUR_REPOSITORY_URL>
```

### Navigate to Project

```bash
cd pokemon-search-api
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## Testing the API

### Browser

```http
http://localhost:8080/api/pokemon/pikachu
```

### cURL

```bash
curl http://localhost:8080/api/pokemon/pikachu
```

### Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Project Structure

```text
src/main/java
│
├── controller
├── service
├── client
├── dto
├── config
├── exception
├── cache
└── mapper
```

---

## Frontend Repository

Frontend application is maintained separately.

Repository Link:

```text
https://github.com/Manishh221/PokiDex-ui
```

---

## Performance Considerations

* Response caching implemented using Caffeine
* Cache expiry configured to prevent stale data
* Maximum cache size configured to control memory usage
* DTO-based API responses
* Reduced vendor API dependency through caching

---

## Author

Manish Singh

Developed for the Finfactor Technologies Software Engineer (Java) Coding Challenge.
