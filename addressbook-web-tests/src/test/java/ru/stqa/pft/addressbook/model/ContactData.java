package ru.stqa.pft.addressbook.model;


import java.io.File;
import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;;
  private String firstname;
  private String lastname;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String homePhone;
  private String mobilePhone;
  private String allPhones;
  private String workPhone;
  private String group;
  private String address;
  private String allAddress;
  private File photo;
  
  public File getPhoto() {
    return photo;
  }
  
  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }
  
  public String getAllPhones() {
    return allPhones;
  }
  
  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  
  public String getAllAddress() {
    return allAddress;
  }
  
  public ContactData withAllAddress(String allAddress) {
    this.allAddress = allAddress;
    return this;
  }
  
  public String getAllEmails ()
  {
    return allEmails;
  }
  public ContactData withAllEmails (String allEmails)
  {
    this.allEmails = allEmails;
    return this;
  }
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
  public String getEmail() {
    return email;
  }
  
  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  
  public String getEmail2() {
    return email2;
  }
  
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  
  public String getEmail3() {
    return email3;
  }
  
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
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
  
  public String getAddress ()
  {
    return address;
  }
  
  public ContactData withAddress (String address)
  {
    this.address = address;
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
