# Spring Boot Blog REST API

A Java Spring Boot REST API blog project built using this [Udemy tutorial](https://www.udemy.com/course/building-real-time-rest-apis-with-spring-boot)

A RESTful API for a blog application enabling users to:
* create new Post
* get Post(s)
  * with pagination and sorting functionality
* update Post
* delete Post
* get all Post(s) with a specific category

In addition, users can manage comments on specific posts by:
* creating a new Comment
* getting Comment(s)
* updating Comment
* deleting Comment

Users can also manage categories to group blog posts by
* creating a Category
* getting Category(/ies)
* updating Category
* deleting Category

Additional features:
* Posts and Comments are stored in a MySQL database, and the ModelMapper library was implemented to convert JPA entities to and from DTOs
* Field validation on create/update Post endpoints and update Comment endpoint using Hibernate Validator
* Basic Auth implemented via Spring Security
* JWT Authentication implemented via Spring Security
* Database Authentication implemented for users with role-based resource access (user vs. admin)
* Get endpoints are accessible by all users, but Post/Put/Delete endpoints are only accessible to admin users
* Documented using SpringDoc OpenAPI and accessible via `.../swagger-ui/index.html` and `.../v3/api-docs`
  * (e.g. `http://localhost:8080/swagger-ui/index.html`)

Technologies used:
* Java
* Spring
* Spring Boot
* Spring Security
* Spring Data
* MySQL Workbench
* SpringDoc OpenAPI
* Swagger UI



