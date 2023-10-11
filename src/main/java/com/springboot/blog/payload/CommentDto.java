package com.springboot.blog.payload;

import lombok.Data;

@Data   //use for getters and setters
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
