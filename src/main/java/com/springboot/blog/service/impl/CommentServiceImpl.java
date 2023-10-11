package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    //don't need @Autowired since it's a Spring bean and there's only one constructor
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    //POST "/api/posts/{postId}/comments"
    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        //retrieve Post entity by id
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        //set Post to Comment entity
        comment.setPost(post);

        //save Comment entity to database
        Comment newComment = commentRepository.save(comment);

        //return the comment entity, mapped to a DTO
        return mapToDTO(newComment);
    }

    @Override
    public List<CommentDto> getCommentByPostId(long postId) {
        // retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);

        // convert list of comment entities to list of comment DTOs
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    private CommentDto mapToDTO(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }
}
