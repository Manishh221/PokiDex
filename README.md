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
* Spring Boot 4
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
    "abilities": [
        "static",
        "lightning-rod"
    ],
    "baseExperience": 112,
    "height": 4,
    "id": 25,
    "image": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
    "name": "pikachu",
    "stats": [
        {
            "base_stat": 35,
            "stat": {
                "name": "hp"
            }
        },
        {
            "base_stat": 55,
            "stat": {
                "name": "attack"
            }
        },
        {
            "base_stat": 40,
            "stat": {
                "name": "defense"
            }
        },
        {
            "base_stat": 50,
            "stat": {
                "name": "special-attack"
            }
        },
        {
            "base_stat": 50,
            "stat": {
                "name": "special-defense"
            }
        },
        {
            "base_stat": 90,
            "stat": {
                "name": "speed"
            }
        }
    ],
    "types": [
        "electric"
    ],
    "weight": 60
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
git clone git@github.com:Manishh221/PokiDex.git
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
├── configuration
├── exception
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
