# FlywaySchemaExampleSpringboot

## About flyway :
1) In this Example, I will explore key concepts of Flyway and how we can use this framework to continuously remodel our application's database schema reliably and easily. In addition, present an example of managing a mysql database using a Maven Flyway plugin.
2) Flyway updates a database from one version to the next using migrations. We can write migrations either in SQL with database-specific syntax, or in Java for advanced database transformations.
3) Migrations can either be versioned or repeatable. The former has a unique version and is applied exactly once. The latter doesn't have a version. Instead, they are (re-)applied every time their checksum changes.
4) Within a single migration run, repeatable migrations are always applied last, after pending versioned migrations have been executed. Repeatable migrations are applied in order of their description. For a single migration, all statements are run within a single database transaction. 

## Flyway Maven Plugin :

```
<dependency>
	<groupId>org.flywaydb</groupId>
	<artifactId>flyway-core</artifactId>
</dependency>
```
## Properties File :

```
#spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/flyway_example?autoreconnect=true
spring.datasource.username= root
spring.datasource.password= ******
#spring.datasource.driver-class-name =com.mysql.jdbc.Driver
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
#spring.jpa.show-sql: true
spring.flyway.baseline-on-migrate=true
spring.jpa.open-in-view=false

```

## Define First Migration :

Flyway adheres to the following naming convention for migration scripts:
<Prefix><Version>__<Description>.sql

So let's create a directory db/migration in $PROJECT_ROOT with a migration script named V1__createTableEmployee.sql containing SQL instructions to create the employee table:

```
CREATE TABLE `EMPLOYEE`
(
    `id` int(20)  NOT NULL auto_increment,
    `name`     VARCHAR(100),
    `email`    VARCHAR(100),
    PRIMARY KEY (
                 `id`
        )
) ROW_FORMAT = Default;
```
  
## Execute Migrations :
To execute migrations, please run the application
  
## Define and Execute Second Migration :

Let's see what a second migration looks like by creating a second migration file with the name V2_updateEmployeeTable.sql containing the following query:

```
ALTER TABLE `EMPLOYEE`
ADD COLUMN mobile VARCHAR(100) AFTER email;
```
## How Flyway Works :
  
To keep track of which migrations we've already applied and when, it adds a special bookkeeping table to our schema. This metadata table also tracks migration checksums, and whether or not the migrations were successful.

The framework performs the following steps to accommodate evolving database schemas:

1) It checks a database schema to locate its metadata table (SCHEMA_VERSION by default). If the metadata table doesn't exist, it will create one.
2) It scans an application classpath for available migrations.
3) It compares migrations against the metadata table. If a version number is lower or equal to a version marked as current, it's ignored.
4) It marks any remaining migrations as pending migrations. These are sorted based on the version number and are executed in order.
5) As each migration is applied, the metadata table is updated accordingly.
  
## Conclusion :
In this example, we learned how Flyway works and how we can use this framework to remodel our application database reliably











