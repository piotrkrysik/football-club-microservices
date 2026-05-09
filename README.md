# Football Club Management System (Microservices)

System do zarządzania klubami piłkarskimi i zawodnikami oparty na architekturze mikroserwisowej.

## 🚀 Technologie
*   **Java 17 / Spring Boot 3**
*   **Spring Data JPA / MySQL**
*   **Docker & Docker Compose**
*   **Spring Security (Basic Auth)**
*   **REST API (RestTemplate communication)**

## 🛠 Jak uruchomić?

### Opcja 1: Docker (Wszystko naraz)
Wymagany zainstalowany Docker Desktop.
```bash
cd docker-club
docker-compose up --build 
```
Aplikacja Teams dostępna na: localhost:8091

Aplikacja Players dostępna na: localhost:8090

### Opcja 2: Lokalnie (IDE)
Uruchom bazę:
```bash
docker-compose up mysql-books.
```
Uruchom ms-players z profilem local (port 8080).

Uruchom ms-teams z profilem local (port 8070).
