package com.springboot.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

//this will format the API response
@Data   //use for getters and setters
public class CommentDto {
    private long id;

    // name shouldn't be null or empty
    @NotEmpty(message = "name should not be null or empty")
    private String name;

    // email should not be null or empty
    // email field validation
    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;

    // comment body should not be null or empty
    // comment body should be minimum of 10 characters
    @NotEmpty
    @Size(min = 10)
    private String body;
}
