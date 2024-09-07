package org.example.springbootcrud.dao;

import org.example.springbootcrud.model.User;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   void update(User user);
   void delete(Long id);
   User findById(Long id);

}
