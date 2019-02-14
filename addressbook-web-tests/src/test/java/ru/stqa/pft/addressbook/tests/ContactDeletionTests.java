package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase
{
  @Test
  public void testContactDeletion()
  {
    if(! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321", "test1"));
    }
    app.getContactHelper().DeleteContact();
    
  }
  
}
