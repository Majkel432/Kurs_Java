package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

public class AddContactToGroupTest extends TestBase {
  
  @BeforeMethod
  public void ensurePreconditions() {
    
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("Jan").withLastname("Nowak"));
      app.goTo().homePage();
    }
  }
  
  @Test
  public void AddContactToGroupTest ()
  {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
  }
  
}

