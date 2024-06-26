package org.example.demo.domain.comment;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment not found with id " + id));
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new EntityNotFoundException("Comment not found with id " + id);
        }
        commentRepository.deleteById(id);
    }
}
