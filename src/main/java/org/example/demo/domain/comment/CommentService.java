package org.example.demo.domain.comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(Long id);

    Comment save(Comment comment);

    void deleteById(Long id);
}
