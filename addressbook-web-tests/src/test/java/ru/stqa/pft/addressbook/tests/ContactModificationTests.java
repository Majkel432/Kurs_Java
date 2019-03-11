package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase
{
  @Test
  public void testContactModification()
  {
    List<ContactData> before = app.getContactHelper().getContactList();
    if(! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new ContactData(before.get(before.size() - 1).getId(), "Jan", "Nowak", null, null, null));
    }
    app.getContactHelper().InitContactModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Jan", "Nowak", null, null, null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().SubmitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<>(after));
  
    
  }
}