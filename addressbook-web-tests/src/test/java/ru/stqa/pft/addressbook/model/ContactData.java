package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String email;
  private final String home;
  
  public ContactData(String firstname, String lastname, String email, String home) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.home = home;
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
}