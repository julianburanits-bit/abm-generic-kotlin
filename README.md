# Generic CRUD Kotlin - Portfolio Project

Portfolio project implementing a **fully generic CRUD (Create, Read, Update, Delete) REST API** in Kotlin with Spring Boot, strictly following **hexagonal architecture** (Ports & Adapters).

The goal is to provide a reusable foundation: any domain entity only needs to implement a repository to automatically get complete CRUD endpoints.

## Key Features

- **100% generic**: Works with any entity using Kotlin generics.
- **Clean hexagonal architecture**:
    - Pure `domain` layer (no external dependencies)
    - Driven ports for repositories
    - Framework-independent application services
    - Concrete adapters in `infrastructure`
- **Working example included**: `Product` entity with in-memory repository.
- Full REST endpoints at `/api/products`
- Modern, idiomatic Kotlin code
- Easy to extend (add JPA, MongoDB, validations, etc.)

## Technologies Used

- Kotlin 2.0+
- Spring Boot 3.3+ (WebMVC with functional routing)
- No external database (in-memory demo)
- Maven (depending on your setup)

## Project Structure (Hexagonal)
src/main/kotlin/com/tuportfolio/abmgeneric/
├── domain
│   ├── model          → Generic Entity marker
│   ├── port           → CrudRepository (driven port)
│   └── service        → GenericCrudService (use cases)
├── infrastructure
│   ├── web            → Functional routing and handlers
│   ├── persistence    → Concrete repository implementations
│   └── config         → Spring bean configuration
└── domain/example     → Product (demo entity)

## Quick Start
# Clone and run
git clone https://github.com/your-username/abm-generic-kotlin.git
cd abm-generic-kotlin
./mvnw spring-boot:run

# Test the endpoints
curl http://localhost:8080/api/products                 # GET all
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"27\" Monitor","price":299.99}'           # POST create

curl http://localhost:8080/api/products/1               # GET by ID
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"27\" 4K Monitor","price":399.99}'        # PUT update
curl -X DELETE http://localhost:8080/api/products/1     # DELETE

## How to Extend (Add New Entities)
1. Create your entity (e.g., User) implementing Entity<ID>
2. Implement a repository for it extending CrudRepository<User, Long>
3. Expose a GenericCrudService<User, Long> bean
4. Add a new router block in RouterConfiguration with path /api/users
→ Full CRUD endpoints available instantly.

## Possible Future Improvements
- Bean Validation on entities
- Global exception handling
- JPA + H2/PostgreSQL support
- Pagination and filtering
- OpenAPI/Swagger documentation
- Turn into a reusable Spring Boot starter

***

**Author**: Julian Guillermo Buranits
**LinkedIn**: [julianburanits-bit](https://github.com/julianburanits-bit)
**Date**: December 2025
