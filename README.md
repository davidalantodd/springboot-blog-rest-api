# springboot-blog-rest-api

A Java Spring Boot REST API blog project built using this [Udemy tutorial](https://www.udemy.com/course/building-real-time-rest-apis-with-spring-boot)

A RESTful API for a blog application enabling users to:
* create new Post
* get Post(s)
  * with pagination and sorting functionality
* update Post
* delete Post

In addition, users can manage comments on specific posts by:
* creating a new Comment
* getting Comment(s)
* updating Comment
* deleting Comment

Additional features:
* Posts and Comments are stored in a MySQL database, and the ModelMapper library was implemented to convert JPA entities to and from DTOs
* Field validation on create/update Post endpoints and update Comment endpoint using Hibernate Validator
* Basic Auth implemented via Spring Security

Technologies used:
* Java
* Spring
* Spring Boot
* Spring Security
* MySQL Workbench

