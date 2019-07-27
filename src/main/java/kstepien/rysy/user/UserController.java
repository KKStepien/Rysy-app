package kstepien.rysy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/api/users")
  public List<UserDTO> getUser() {
    List<User> users = userService.findAll();
    List<UserDTO> usersDTO = new ArrayList<>();
    for (int i = 0; i < users.size(); i++) {
      UserDTO userDTO = new UserDTO();
      userDTO.setName(users.get(i).getName());
      userDTO.setSurname(users.get(i).getSurname());
      userDTO.setLogin(users.get(i).getLogin());
      userDTO.seteMail(users.get(i).getEmail());
      usersDTO.add(userDTO);
    }
    return usersDTO;
  }

  @DeleteMapping("/api/user/{id}")
  public void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
  }

  @PutMapping("/api/users")
  public UserDTO createUser(@RequestBody CreateUserDTO createUserDTO) {
    User user = userService.createdUser(createUserDTO.getName(), createUserDTO.getSurname(), createUserDTO.getLogin(),
        createUserDTO.getPassword(), createUserDTO.getPasswordSecond(), createUserDTO.getBirthDate(), createUserDTO.getEmail());
    UserDTO userDTO = new UserDTO();
    userDTO.seteMail(user.getEmail());
    userDTO.setLogin(user.getLogin());
    userDTO.setSurname(user.getSurname());
    userDTO.setName(user.getName());
    return userDTO;
  }

  @PostMapping("/api/user/{id}")
  public UserDTO updateUser(@RequestBody UpdateUserDTO updateUserDTO,@PathVariable Long id) {
    UserUpdate userUpdate = new UserUpdate();
    userUpdate.setLogin(updateUserDTO.getLogin());
    userUpdate.setName(updateUserDTO.getName());
    userUpdate.seteMail(updateUserDTO.geteMail());
    userUpdate.setSurname(updateUserDTO.getSurname());
    User user = userService.updateUser(userUpdate, id);
    UserDTO userDTO = new UserDTO();
    userDTO.seteMail(user.getEmail());
    userDTO.setLogin(user.getLogin());
    userDTO.setSurname(user.getSurname());
    userDTO.setName(user.getName());
    return userDTO;
  }

}
