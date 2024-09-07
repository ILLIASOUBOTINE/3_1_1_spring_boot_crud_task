package org.example.springbootcrud.dao;

import org.example.springbootcrud.model.User;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
    public void add(User user) {
      entityManager.persist(user);
    }

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("from User", User.class).getResultList();
   }

   @Override
   public void update(User user) {
      entityManager.merge(user);
   }

   @Override
   public void delete(Long id) {
      User user = entityManager.find(User.class, id);
      if (user != null) {
         entityManager.remove(user);
      }

   }

   @Override
   public User findById(Long id) {
      return entityManager.find(User.class, id);
   }


}
