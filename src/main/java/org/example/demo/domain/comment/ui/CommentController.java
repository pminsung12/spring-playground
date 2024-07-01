package org.example.demo.domain.comment.ui;

import io.swagger.v3.oas.annotations.Operation;
import org.example.demo.domain.post.Post;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.comment.CommentService;
import org.example.demo.domain.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@Tag(name = "댓글")
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("/posts/{postId}")
    public Comment createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        Post post = postService.findById(postId);
        if (post == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }

        comment.setPost(post);
        return  commentService.save(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "댓글 삭제")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "댓글 조회")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "댓글 목록 조회")
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }


}
