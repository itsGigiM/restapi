# Todo List Application
This is a simple todo list application built with Spring Boot, Hibernate, and MySQL. It provides RESTful endpoints to manage todo items, allowing users to create, read, update, and delete tasks.

## Features
- Create new todo items with a title and description.
- Retrieve a list of all todo items.
- Retrieve a specific todo item by its ID.
- Update an existing todo item.
- Delete a todo item.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL

## Prerequisites
Before running the application, ensure you have the following installed:

Java Development Kit (JDK)
MySQL database server
Maven (for building the project)
## Setup Instructions
### Clone the Repository:

```
git clone https://github.com/yourusername/todo-list.git
```
### Configure MySQL:

Create a MySQL database for the application.

Update the database configuration in src/main/resources/application.properties with your database details:

```
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=password
```
### Build the Application:

Navigate to the project directory and run:

```
mvn clean package
```
### Run the Application:

After building the project, you can run the application using Maven or directly running the generated JAR file:

```
java -jar target/todo-list-0.0.1-SNAPSHOT.jar
```
Alternatively, you can run the application from your IDE by running the TodoListApplication class.

### Access the Application:

Once the application is running, you can access the API endpoints using a tool like Postman or curl. The base URL for the API endpoints is http://localhost:8080/api/todo.

## API Documentation
- POST /api/todo: Create a new todo item.
- GET /api/todo: Retrieve all todo items.
- GET /api/todo/{id}: Retrieve a specific todo item by its ID.
- PUT /api/todo/{id}: Update an existing todo item.
- DELETE /api/todo/{id}: Delete a todo item by its ID.


## Short Feedback
It is much easier to complete the task when AI accompanies me. It generates so much boilerplate code and helps me design the working process.

The task took me 2 hours to finish with the help of ChatGPT.

The biggest challenge I had during the task was designing. It requires generally thinking about multiple layers of the application and creating an abstract graph of how it should look.

The general prompts which let AI give me an idea about architecture were the most helpful during the process.
