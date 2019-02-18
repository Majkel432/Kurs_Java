package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase
{
  @Test
  public void testContactDeletion()
  {
    int before = app.getContactHelper().getContactCount();
    if(! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321", "test1"));
    }
    app.getContactHelper().DeleteContact();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
    
  }
  
}
