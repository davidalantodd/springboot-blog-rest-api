package com.springboot.blog.repository;

import com.springboot.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

//don't need @Repository annotation here since JpaRepository has that functionality
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
