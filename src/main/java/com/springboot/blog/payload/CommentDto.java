package com.springboot.blog.payload;

import lombok.Data;

//this will format the API response
@Data   //use for getters and setters
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
