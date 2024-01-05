# Bug Report

All the command from this bug report should be executed from the project's root directory.

## Requirements

- Docker
- Java 17

## Build project

```shell
mvn clean install
```

## Generate Diff changelog for Microsoft SQL Server

### Run MS SQL Server from docker

Open a new terminal an run:

```shell
docker compose -f ./docker/sqlserver.yml up 
```

> NOTE:
> Volumes will be generated within the docker directory

### Generate changelog

```shell
mvn clean package -DskipTests liquibase:diff -Psqlserver
```

> Change log will be generated at [liquibase/sqlserver/changelogs/db.diff-changelog.xml](liquibase/sqlserver/changelogs/db.diff-changelog.xml)
>
> Changelog **will not** contain the `my_sequence` from [package-info.java](src/main/java/com/example/demo/model/package-info.java).

## Generate Diff changelog for PostgreSQL

### Run MS SQL Server from docker

Open a new terminal an run:

```shell
docker compose -f ./docker/postgres.yml up 
```

> NOTE:
> Volumes will be generated within the docker directory

### Generate changelog

```shell
mvn clean package -DskipTests liquibase:diff -Ph2
```

> Change log will be generated at [liquibase/postgres/changelogs/db.diff-changelog.xml](liquibase/postgres/changelogs/db.diff-changelog.xml)
>
> Changelog **will** contain the `my_sequence` from [package-info.java](src/main/java/com/example/demo/model/package-info.java), however, the sequence will have **wrong increment size**.


## Generate Diff changelog for h2

### Generate changelog

```shell
mvn clean package -DskipTests liquibase:diff -Ph2
```

> Change log will be generated at [liquibase/h2/changelogs/db.diff-changelog.xml](liquibase/h2/changelogs/db.diff-changelog.xml)
>
> Changelog **will** contain the `my_sequence` from [package-info.java](src/main/java/com/example/demo/model/package-info.java), however, the sequence will have **wrong increment size**.
