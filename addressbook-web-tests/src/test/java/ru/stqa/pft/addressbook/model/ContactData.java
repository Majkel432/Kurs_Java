package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String email;
  private final String home;
  private String group;
  
  public ContactData(String firstname, String lastname, String email, String home, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.home = home;
    this.group = group;
  }
  
  public String getFirstname() {
    return firstname;
  }
  
  public String getLastname() {
    return lastname;
  }
  
  public String getEmail() {
    return email;
  }
  
  public String getHome() {
    return home;
  }
  
  public String getGroup() {
    return group;
  }
}
