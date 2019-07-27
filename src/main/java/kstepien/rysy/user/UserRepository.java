package kstepien.rysy.user;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {

  //User updateUser(User user);
  List<User> findAll();
  void deleteByUserId(Long id);
  User save (User user);
  User findByUserId(Long id);
  User findByLogin(String Login);

}
