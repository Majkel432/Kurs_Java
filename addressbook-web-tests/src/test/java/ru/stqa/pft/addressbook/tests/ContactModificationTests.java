package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase
{
  @Test
  public void testContactModification()
  {
    app.getContactHelper().InitContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321"));
    app.getContactHelper().SubmitContactModification();
  }
}