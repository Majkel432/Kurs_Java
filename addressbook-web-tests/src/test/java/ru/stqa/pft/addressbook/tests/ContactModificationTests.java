package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTests extends TestBase
{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();
    if(app.contact().all().size() == 0)
    {
      app.contact().create(new ContactData().withFirstname("Jan").withLastname("Nowak").withGroup("test1"));
      app.goTo().homePage();
    }
  }
  @Test
  public void testContactModification()
  {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Jan").withLastname("Nowak").withEmail("jan.nowak@interia.pl").withHomePhone("123456789").withGroup("test1");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    
  }
  
}