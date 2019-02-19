package ru.stqa.pft.addressbook.model;

import java.util.Objects;

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
  
  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", email='" + email + '\'' +
            ", home='" + home + '\'' +
            ", group='" + group + '\'' +
            '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(email, that.email) &&
            Objects.equals(home, that.home) &&
            Objects.equals(group, that.group);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, email, home, group);
  }
}
