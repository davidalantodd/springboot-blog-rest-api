package com.springboot.blog.payload;

import lombok.Data;

import java.util.Set;

@Data   //will generate our getter/setter/hashCode/equals methods
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;
}
