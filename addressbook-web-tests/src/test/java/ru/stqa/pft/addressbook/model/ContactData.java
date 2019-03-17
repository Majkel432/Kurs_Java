package ru.stqa.pft.addressbook.model;


import java.util.Objects;



public class ContactData {
  private int id = Integer.MAX_VALUE;;
  private String firstname;
  private String lastname;
  private String email;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String group;
  
  public int getId() {
    return id;
  }
  
  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }
  
  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }
  
  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public String getHomePhone() {
    return homePhone;
  }
  
  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }
  public String getMobilePhone() {
    return mobilePhone;
  }
  
  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }
  public String getWorkPhone() {
    return workPhone;
  }
  
  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }
  
  public ContactData withGroup(String group) {
    this.group = group;
    return this;
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
  
 
  
  public String getGroup() {
    return group;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
  
  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
  
}
