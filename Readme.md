## Bonita theme import/export using postgres

## Steps to Setup

**1. Clone the repository** 

```bash
git clone https://github.com/Hazem-Ben-Khalfallah/Bonita-theme-updater.git
```

**2. Configure application.properties file**
```yaml
spring.postgresql.datasource.url=jdbc:postgresql://[SERVER_URL]:[PORT]/[BONITA_DB]
spring.postgresql.datasource.username=[USERNAME]
spring.postgresql.datasource.password=[PASSWORD]
```

**3. Run the app using maven**

```bash
mvn spring-boot:run
```

That's it! The application can be accessed at `http://localhost:18080`.

You may also package the application in the form of a jar and then run the jar file like so -

```bash
mvn clean package
java -jar target/bonita-theme-0.0.1-SNAPSHOT.jar
```
