package org.example.springbootcrud.service;


import org.example.springbootcrud.dao.UserDao;
import org.example.springbootcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }


   @Override
   public void add(User user) {
      userDao.add(user);
   }


   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }


   @Override
   public void update(User user) {
      userDao.update(user);
   }


   @Override
   public void delete(Long id) {
      userDao.delete(id);
   }

   @Override
   public User findById(Long id) {
      return userDao.findById(id);
   }


}
