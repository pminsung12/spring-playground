package org.example.demo.domain.post;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found with id " + id));
    }

    @Override
    public Post save(Post post){
        return postRepository.save(post);
    }

    @Override
    public void deleteById(Long id){
        if(!postRepository.existsById(id)) {
            throw new EntityNotFoundException("Post not found with id " + id);
        }
        postRepository.deleteById(id);
    }
}
