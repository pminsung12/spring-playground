package org.example.demo.domain.comment.ui;

import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.comment.CommentService;
import org.example.demo.domain.post.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

//    @PostMapping("/posts/{postId}")
//    public Comment createComment(@PathVariable Long postId, @RequestBody Comment comment) {
//        // comment 만들기
//        Comment newComment = commentService.save(comment);
//        return newComment;
//    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }


}
