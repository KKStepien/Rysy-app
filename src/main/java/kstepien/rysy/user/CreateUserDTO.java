package kstepien.rysy.user;

import java.util.Date;

public class CreateUserDTO {
  private String name;
  private String surname;
  private String login;
  private String password;
  private String passwordSecond;
  private Date birthDate;
  private String email;

  public String getPasswordSecond() {
    return passwordSecond;
  }

  public void setPasswordSecond(String passwordSecond) {
    this.passwordSecond = passwordSecond;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


}
