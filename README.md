# Adobe_Assignment


![](https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/HeroImage.jpg)

## About
It is a social media application module where a user can make a post and can like and unlike the post accordingly.

## Features

- User can signUp using the valid credentials
- User can able to login using the valid credentials which is authorized by the spring security JWT token.
- User can able to perform logOut as well.
- User can post and like.
- User can able to perform like and unlike functionality.
- User can find top 5 post and top 5 active users as well.



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
- Swagger-ui

## Setup and user guide

```
Starting up the server from the springBoot application
```
<p align="left">
  <img width="436" height="297" src="https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/SpringBoot%20Server.png">
</p>

## Swagger Documentation
```
http://localhost:8888/swagger-ui/index.html
```

## API Root and Endpoint

- Register one user to the database
- Method : POST
```
http://localhost:8888/users
```
- SignIn the user using the valid credentials
- Method : GET
```
http://localhost:8888/signIn
```

- Retrive one user using user id
- Method : GET
```
http://localhost:8888/users/{id}
```

- Update a user's credentials 
- Method : PUT
```
http://localhost:8888/users/{id}
```

- Delete a user by id
- Method : DELETE
```
http://localhost:8888/users/{id}
```

- Retrieve the total number of users
- Method : GET
```
http://localhost:8888/analytics/users
```

- Retrieve the top 5 most active users
- Method : GET
```
http://localhost:8888/analytics/users/top-active
```

- Create a new post
- Method : POST
```
http://localhost:8888/posts
```

- Retrieve a post by id
- Method : GET
```
http://localhost:8888/posts/{id}
```

- Update a post's content by id
- Method : PUT
```
http://localhost:8888/posts/{id}
```

- Delete a post by id
- Method : DELETE
```
http://localhost:8888/posts/{id}
```

- Increment the like count of a post by id
- Method : POST
```
http://localhost:8888/posts/{id}/like
```

- Decrement the like count of a post by id
- Method : POST
```
http://localhost:8888/posts/{id}/unlike
```

- Retrieve the total number of posts
- Method : GET
```
http://localhost:8888/analytics/posts
```

- Retrieve the top 5 most liked posts
- Method : GET
```
http://localhost:8888/analytics/posts/top-liked
```
