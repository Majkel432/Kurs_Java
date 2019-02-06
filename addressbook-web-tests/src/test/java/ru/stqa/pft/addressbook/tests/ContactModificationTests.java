package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase
{
  @Test
  public void testContactModification()
  {
    app.getContactHelper().InitContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Mateusz", "Wilk", "example3@poczta.fm", "654321789"));
    app.getContactHelper().SubmitContactModification();
  }
}