package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase
{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new ContactData("Jan", "Nowak", null, null, "test1"));
      app.getNavigationHelper().gotoHomePage();
    }
  }
  
  @Test
  public void testContactDeletion()
  {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().DeleteContact(before.size() - 1);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
  
}
