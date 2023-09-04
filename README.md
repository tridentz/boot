
# Spring Boot with Java 11 sample
- Java 11
- Spring boot 2
- Maven
- Restful API
- Liquibase
- Lombok
- Postgresql

# Start Project
- Profile
    - local
        - Create [application-local.properties](src/main/resources/application-local.properties)
        - Add environment variable : `spring.profiles.active=local`
- Database
    - Postgresql by Docker
        - ```docker pull postgres```
        - ```docker run -itd -e POSTGRES_USER=sa -e POSTGRES_PASSWORD=pw -p 5432:5432 -v /data:/var/lib/postgresql/data --name postgresql postgres```
        - ```docker ps -a```
        - ```docker restart <containerId>```
    - Config
        - Spring Config: [application.properties](src/main/resources/application.properties)
        - Liquibase Config: [liquibase.properties](liquibase.properties)
            - Development Sql change:
                - Set `update` to `spring.jpa.hibernate.ddl-auto` in [application.properties](src/main/resources/application.properties)
                - Default is `validate`
                - Database schema will automatically update depends on the @Entity classes
            - If anything have to change manually to update the change log sql
                1. On the project root, run ` liquibase updateSQL`
                2. That will make use o the config of Liquibase
                3. copy those sql from the result and run it on the database client
        - Other Reminder
            - [liquibase.properties](liquibase.properties) is for liquibase cli to use (externally)
            - liquibase.searchPath in [liquibase.properties](liquibase.properties) : to allow liquibase to found the migration folder that under resource (Structure for liquibase dependency)
            - Java version: if you have multiple java version, you may use jenv to change it
                - Jenv Check Versions and what version is available: ```jenv versions```
                - Jenv add java verison: ```jenv add /Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home/```
                - Update version for the local project: ```jenv local openjdk64-11.0.20.1```
                - Check java REAL version: ```javac -version```
                - If this is not work  (java version is not what you want): ```export PATH="$HOME/.jenv/bin:$PATH"``` & ```eval "$(jenv init -)"```
                - And check the java again: ```which java```
                - Check for Maven version: ```mvn -version```
                - If maven java. is still not u want: ```export JAVA_HOME=/Library/Java/JavaVirtualMachines/<your java path>/Contents/Home/```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#web)
* [Liquibase Migration](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.liquibase)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

