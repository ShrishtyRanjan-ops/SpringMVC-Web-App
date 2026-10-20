
# SpringMVC Login Application

A Java web application built with Spring MVC that provides user authentication backed by a MySQL database. It uses JSP and JSTL for the view layer, Hibernate ORM for persistence, Bean Validation for form input checks, and Spring Security Crypto for password encryption.

The project is packaged as a WAR and runs on Apache Tomcat 10 or later.

---

## Features

- Spring MVC request handling with JSP views
- Server-side form validation using Hibernate Validator (Jakarta Bean Validation)
- Password encryption using Spring Security Crypto, so plain-text passwords are not stored
- Object-relational mapping and database access through Hibernate ORM
- MySQL as the persistent data store
- Maven-based build producing a deployable WAR

## Technology Stack

| Component | Version | Purpose |
|---|---|---|
| Java | 21 | Language and runtime |
| Spring Web MVC | 6.2.12 | Controllers, view resolution, request mapping |
| Jakarta Servlet API | 6.0.0 | Servlet specification (provided by Tomcat) |
| Jakarta JSP API | 3.1.1 | JSP support (provided by Tomcat) |
| JSTL | 3.0 | Tag library for JSP pages |
| Hibernate ORM | 6.6.15.Final | Persistence and entity mapping |
| Hibernate Validator | 8.0.2.Final | Form and entity validation |
| Spring Security Crypto | 6.4.4 | Password encryption |
| MySQL Connector/J | 9.4.0 | JDBC driver |
| Apache Tomcat | 10+ | Servlet container |
| Maven | 3.x | Build and dependency management |

Tomcat 10 or later is required because the project uses the `jakarta.*` namespace. It will not run on Tomcat 9 or earlier, which use `javax.*`.

## Project Structure

```
SpringMVC-Web-App
├── pom.xml          Maven build configuration (WAR packaging)
├── src/main         Application source, resources and web content
└── README.md
```

The `src/main` directory follows the standard Maven layout for a WAR project: Java sources under `java`, configuration and mapping files under `resources`, and JSP views under `webapp`.

## Getting Started

### Prerequisites

- JDK 21
- Apache Maven
- Apache Tomcat 10 or later
- MySQL Server

### Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/ShrishtyRanjan-ops/SpringMVC-Web-App.git
   cd SpringMVC-Web-App
   ```

2. **Create the database**

   ```sql
   CREATE DATABASE <database_name>;
   ```

3. **Configure the database connection**

   Update the JDBC URL, username and password in the project's database or Hibernate configuration so they match your local MySQL instance. Do not commit real credentials to the repository.

4. **Build the WAR**

   ```bash
   mvn clean package
   ```

   The build produces `target/SpringMVCLoginApp.war`.

5. **Deploy to Tomcat**

   Copy the WAR into Tomcat's `webapps` directory and start the server, or run the project from IntelliJ IDEA using the Smart Tomcat plugin.

6. **Open the application**

   ```
   http://localhost:8080/SpringMVCLoginApp/
   ```

## Build

| Command | Result |
|---|---|
| `mvn clean compile` | Compiles the sources |
| `mvn clean package` | Compiles and packages the WAR |

The final artifact name is `SpringMVCLoginApp`, set through `finalName` in `pom.xml`, which also determines the default context path on Tomcat.

## Security Notes

- Passwords are encrypted with Spring Security Crypto before being stored
- Database credentials should be kept out of version control, for example in environment variables or an untracked properties file
- For any deployment beyond local development, serve the application over HTTPS and add CSRF protection to state-changing requests

## Author

**Shrishty Ranjan**
MCA, Galgotias University
