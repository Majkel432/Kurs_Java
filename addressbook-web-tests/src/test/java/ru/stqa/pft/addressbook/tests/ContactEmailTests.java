package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactEmailTests extends TestBase {
  
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Jan").withLastname("Nowak").withAddress("ul.Korfantego 2/4 50-345 Kalisz").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("jan.nowak@interis.pl"));
      app.goTo().homePage();
    }
  }
  
  @Test
  public void testContactEmails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  
    assertThat(contact.getAllEmails(), equalTo(mergedEmails(contactInfoFromEditForm)));
    verifyContactListInUI ();
  }
  
  private String mergedEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            //.map(ContactEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }
}
