# note
Приложение  для создания, редактирования и сохранения заметок в базе данных.
Приложение написано на языка Java с использованием базы H2,основано на Spring Boot.

## запустить приложение с помощью spring-boot-maven-plugin
mvn spring-boot:run

## запустить приложение с помощью jar
./start.sh

## доступ к API приложения
localhost:8080/

## swagger
http://localhost:8080/swagger-ui/index.html#/

## краткое описание методов
"/save" - сохранение заметки, после сохранения возвращается номер запись в базе данных
"/edit/идентификатор" -поиск заметки  по идентификатору для еще изменения; находит нужную запить в базе и изменяет ее; возвращает измененную запись
"/all" - просмотр всех существующих заметок
