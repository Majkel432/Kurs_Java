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
      app.getContactHelper().createContact(new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321", "test1"));
    }
    app.getContactHelper().InitContactModification(before.size() - 1);
    app.getContactHelper().fillContactForm(new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321", null), false);
    app.getContactHelper().SubmitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  
    
  }
}