# Adobe_Assignment


![](https://github.com/Suresh170411/PayPal_assignment/blob/main/Images/Checklist.jpg)

## About
It is a social media application module where a user can make a post and can like and unlike the post accordingly.

## Features

- 



## Technologies and Dependencies Used
- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Security
- Devtools
- MySQL
- Lombok
- Maven

## Swagger Documentation
```
http://localhost:8888/swagger-ui/index.html
```

## API Root and Endpoint

- Register one user to the database
- Method : POST
```
http://localhost:8888/person/signUp
```
- SignIn the user using the valid credentials
- Method : GET
```
http://localhost:8888/signIn
```
- Post one task into the database
- Method : POST
```
http://localhost:8888/task
```
- Get the task using the taskId
- Method : GET
```
http://localhost:8888/task/{taskId}
```

- Get all the tasks
- Method : GET
```
http://localhost:8888/tasks
```

- Find the percentage of the task complition
- Method : GET
```
http://localhost:8888/task/data/percent
```
