package org.example.springbootcrud.service;

import org.example.springbootcrud.model.User;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void update(User user);
    void delete(Long id);
    User findById(Long id);
}
