package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post (DTO as parameter, entity as response)
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all blog posts
    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    // get post by ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // update post by ID
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") long id){
        //call updatePost method and save in a PostDto
        PostDto postResponse = postService.updatePost(postDto, id);
        //return updated post and status in a ResponseEntity
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // delete post by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id){
        // call deletePostById method
        postService.deletePostById(id);
        // return a response entity with a string to indicate the post was deleted
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
}
