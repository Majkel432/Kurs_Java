package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase
{
  @Test
  public void testContactModification()
  {
  
    if(! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321", "test1"));
    }
    app.getContactHelper().InitContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321", null), false);
    app.getContactHelper().SubmitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}