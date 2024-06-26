package org.example.demo.domain.user;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
