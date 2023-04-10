# Adobe_Assignment


![](https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/HeroImage.jpg)

## About
It is a social media application module where a user can make a post and can like and unlike the post accordingly.

## Features

- User can signUp using the valid credentials.
- User can able to login using the valid credentials which is authorized by the spring security JWT token.
- User can able to perform logOut as well.
- User can post and like.
- User can able to perform like and unlike functionality.
- User can find top 5 post and top 5 active users as well.
- User can able to perform all the CRUD operations.



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
  <img width="500" height="297" src="https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/SpringBoot%20Server.png">
</p>

```
Home page for front end of Swagger-ui
```
<p align="left">
  <img width="500" height="250" src="https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/EndPoint-1.png">
</p>
<p align="left">
  <img width="500" height="250" src="https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/EndPoint-2.png">
</p>

```
Login a user by using the valid credentials
```
<p align="left">
  <img width="500" height="250" src="https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/SignIn.png">
</p>

```
After login user will be authenticated by bearer token
```
<p align="left">
  <img width="700" height="200" src="https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/Bearer%20Token.png">
</p>
- You can copy this bearer token to use as a token for further authorization

```
Use this bearer token to authenticate to use furhter apis
```
<p align="left">
  <img width="500" height="250" src="https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/Authorization%20using%20Bearer%20token.png">
</p>
<p align="left">
  <img width="500" height="250" src="https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/Authorize.png">
</p>

```
To logout from the application simply hit logout button
```
<p align="left">
  <img width="500" height="250" src="https://github.com/Suresh170411/Adobe_Assignment/blob/main/Images/Logout.png">
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
