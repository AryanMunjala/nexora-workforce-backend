# Nexora Workforce — Backend

Java 21 and Spring Boot REST API for the Nexora Workforce employee management system, backed by MySQL.

- **Backend API:** https://nexora-backend-production-3f15.up.railway.app
- **Live frontend:** https://nexora-frontend-production-ebc0.up.railway.app
- **Frontend repository:** https://github.com/AryanMunjala/nexora-workforce-frontend
- **Original full-stack repository:** https://github.com/AryanMunjala/nexora-workforce

## Requirements

- JDK 21
- Maven 3.9+
- MySQL 8.x (for a local run)

## Run locally

1. Start MySQL and create/use a database named `nexora_workforce`.
2. Set the database environment variables before starting the application. Spring Boot does **not** automatically load a file named `.env`; `.env.example` is a reference template. Never commit real passwords.

Windows Command Prompt example (replace the username/password with your local MySQL credentials):

```bat
set DB_URL=jdbc:mysql://localhost:3306/nexora_workforce?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
set DB_USERNAME=root
set DB_PASSWORD=your_local_mysql_password
set PORT=8080
mvn spring-boot:run
```

PowerShell example:

```powershell
$env:DB_URL = "jdbc:mysql://localhost:3306/nexora_workforce?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "your_local_mysql_password"
$env:PORT = "8080"
mvn spring-boot:run
```

The API listens on port `8080` by default. If you change the port, update the frontend's `VITE_API_BASE_URL` accordingly.

## Build and verify

```bash
mvn -B verify
```

The Dockerfile builds the application with Maven and runs it on Java 21. Configure database connection variables in your deployment environment; do not bake credentials into the image.
