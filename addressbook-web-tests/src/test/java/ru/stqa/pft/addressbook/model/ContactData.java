package ru.stqa.pft.addressbook.model;


import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")

@Entity
@Table(name = "addressbook")

public class ContactData {
  
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  
  @Expose
  @Column(name = "firstname")
  private String firstname;
  
  @Expose
  @Column(name = "lastname")
  private String lastname;
  
  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;
  
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;
  
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;
  
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;
  
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  
  @Transient
  private String allPhones;
  
  @Transient
  private String allAddress;
  
  @Transient
  private String allEmails;
  
  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();
  
  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;
  
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;
  
  public File getPhoto() {
    if (photo == null) {
      return null;
    }
    return new File(photo);
  }
 
 public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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
  
  public String getAllEmails() {
    return allEmails;
  }
  
  public ContactData withAllEmails(String allEmails) {
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
  
  public String getAddress() {
    return address;
  }
  
  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
  
  public String getFirstname() {
    return firstname;
  }
  
  public String getLastname() {
    return lastname;
  }
  
  public Groups getGroups() {
    return new Groups(groups);
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) ;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
  
  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
  
  }
  