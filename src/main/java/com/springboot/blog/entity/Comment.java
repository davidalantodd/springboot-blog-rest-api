package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok annotation for boilerplate code
@Data
@AllArgsConstructor
@NoArgsConstructor

//making this class a JPA Entity
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //could use @Column here to map a column name to this field, but JPA by default will make the field names the column names
    private String name;
    private String email;
    private String body;

    //establish connection between Post and Comment
    @ManyToOne(fetch = FetchType.LAZY) //only fetch related entities
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;


}
