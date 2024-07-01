package org.example.demo.domain.post.ui;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.demo.domain.post.Post;
import org.example.demo.domain.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "게시글")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "게시글 생성")
    public Post createPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "게시글 수정")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "게시글 삭제")
    public void deletePost(@PathVariable Long id) {
        postService.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "게시글 조회")
    public Post getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "게시글 목록 조회")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }
}
