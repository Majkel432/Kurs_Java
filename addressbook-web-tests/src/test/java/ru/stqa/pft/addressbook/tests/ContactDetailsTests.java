package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactDetailsTests extends TestBase{
  
  @Test
  public void testContactDetailsInfo() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactCheckDetailsInfo = app.contact().checkDetailsInfo(contact);
    ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);
    
    MatcherAssert.assertThat(contactCheckDetailsInfo.getCheckDetailsInfo(), equalTo(mergeCheckDetailsInfo(contactInfoFormEditForm)));
  }
  
  private String mergeCheckDetailsInfo(ContactData contact) {
    if (!(contact.getHomePhone().equals(""))) {
      contact.withHomePhone("H: " + contact.getHomePhone());
    }
    if (!(contact.getMobilePhone().equals(""))) {
      contact.withMobilePhone("M: " + contact.getMobilePhone());
    }
    if (!(contact.getWorkPhone().equals(""))) {
      contact.withWorkPhone("W: " + contact.getWorkPhone());
    }
    if (!(contact.getEmail().equals(""))) {
      if ((contact.getEmail().length()) > 1) {
        String mail = contact.getEmail();
        if (!((mail.indexOf("@")) == -1)) {
          String s = mail.substring(mail.indexOf("@") + 1, mail.length());
          contact.withEmail(contact.getEmail());
        } else {
          String s = mail.substring(1, mail.length());
          contact.withEmail(contact.getEmail());
        }
      }
    }
    if (!(contact.getEmail2().equals(""))) {
      if ((contact.getEmail2().length()) > 1) {
        String mail = contact.getEmail2();
        if (!((mail.indexOf("@")) == -1)) {
          String s = mail.substring(mail.indexOf("@") + 1, mail.length());
          contact.withEmail2(contact.getEmail2());
        } else {
          String s = mail.substring(1, mail.length());
          contact.withEmail2(contact.getEmail2());
        }
      }
    }
    if (!(contact.getEmail3().equals(""))) {
      if ((contact.getEmail3().length()) > 1) {
        String mail = contact.getEmail3();
        if (!((mail.indexOf("@")) == -1)) {
          String s = mail.substring(mail.indexOf("@") + 1, mail.length());
          contact.withEmail3(contact.getEmail3());
        } else {
          String s = mail.substring(1, mail.length());
          contact.withEmail3(contact.getEmail3());
        }
      }
    }
    
    return Arrays.asList(contact.getFirstname() + " " + contact.getLastname(), contact.getAddress() + "\n"
            , contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone() + "\n"
            , contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
