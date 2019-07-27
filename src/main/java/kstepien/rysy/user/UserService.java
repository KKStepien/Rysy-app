package kstepien.rysy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  User updateUser(UserUpdate userUpdate, Long id) {
    User user = userRepository.findByUserId(id);
    if (userUpdate.getName() != null) {
      user.setName(userUpdate.getName());
    }
    if (userUpdate.getSurname() != null) {
      user.setSurname(userUpdate.getSurname());
    }
    if (userUpdate.geteMail() != null) {
      if (!checkEmail(userUpdate.geteMail())) {
        user.setEmail(userUpdate.geteMail());
      } //todo jeśli nie komunikat że taki e-mail juz istnieje
    }
    if (userUpdate.getLogin() != null) {
      if (!checkLogin(userUpdate.getLogin())) {
        user.setLogin(userUpdate.getLogin());
      }//todo jeśli nie komunikat że taki e-mail już istnieje
    }
    return userRepository.save(user);
  }

  private boolean checkLogin(String login) {
    // todo: sprawdzić czy login istnieje
    return false;
  }

  public boolean checkEmail(String email) { //todo dodac sprawdzanie po Liscie rowniez dla Moderatorow
    List<User> users = findAll();
    boolean yesOrNo;
    for (int i = 0; i < users.size(); i++) {
      yesOrNo = Objects.equals(users.get(i).getEmail(), email);
      if (yesOrNo) {
        return true;
      }
    }
    return false;
  }


  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Transactional
  public void deleteUser(Long id) {
    userRepository.deleteByUserId(id);
  }

  public User createdUser(String name, String surname, String login, String password, String secendPassword,
                          Date birthDate, String eMail) {
    User user = new User();
    user.setCreatedDate(LocalDateTime.now());
    //todo wyjątki jeśli null i jeśli powtarza się login lub email
    if (name != null) {
      user.setName(name);
    }
    if (surname != null) {
      user.setSurname(surname);
    }
    if (login != null) {
      if (!checkLogin(login)) {
        user.setLogin(login);
      }
    }
    if (password != null && Objects.equals(password, secendPassword)) {
      user.setPassword(password);
    }
    if (birthDate != null) {
      user.setBirthDate(birthDate);
    }
    if (eMail != null) {
      if (!checkEmail(eMail)) {
        user.setEmail(eMail);
      }
    }

    return userRepository.save(user);
  }

  public User findUserByLogin(String login) {
    return userRepository.findByLogin(login);
  }
}

