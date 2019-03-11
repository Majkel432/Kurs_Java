package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class AddContactTests extends TestBase {
  
  
  @Test
  public void AddContactTest() throws Exception {
    
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321", "test1");
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  
    int max = 0;
    for (ContactData c : after)
    {
      if(c.getId() > max)
      {
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add (contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<>(after));
    
  }
  
}
  
