package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class AddContactTests extends TestBase {
  
  
  @Test
  public void AddContactTest() throws Exception {
    
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    
  }
  
}
  
