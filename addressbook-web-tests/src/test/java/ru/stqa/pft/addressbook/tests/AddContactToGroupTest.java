package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    
    app.contact().cuurentGroupPage();
    Contacts before = app.db().contacts2();
    ContactData contactAddedToGroup = before.iterator().next();
    app.contact().AddContactToGroup(contactAddedToGroup);
   
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.db().contacts2();
    //assertThat(after, equalTo(before.without(contactAddedToGroup)));
  
    
  }
  
}

