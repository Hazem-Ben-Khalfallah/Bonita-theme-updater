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
Alternatively, You may also package the application in the form of a jar and then run the jar file like so:

```bash
mvn clean package
java -jar target/bonita-theme-0.0.1-SNAPSHOT.jar
```


That's it! The application can be accessed at `http://localhost:18080`.

**4. Download bonita portal default theme & cssContent**
Download bonita portal theme zip file and cssContent file locally

**5. Customize style**
Extract the download zip file and customize all that you need. Don't forget to zip the extracted folder when you finish.

**6. upload your customized files**
use the same url to upload the two files `http://localhost:18080`

**7. Go to your Bonita portal and refresh to see the changes**
You may need to remove browser cache to see the changes. no need to restart the app or any thing like that.

Enjoy!
