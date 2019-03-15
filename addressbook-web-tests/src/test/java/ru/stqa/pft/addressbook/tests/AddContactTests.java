package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class AddContactTests extends TestBase {
  
  
  @Test
  public void AddContactTest() throws Exception {
    
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Krzysztof", "Nowak", "example@poczta.fm", "987654321", "test1");
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    
    before.add (contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    
  }
  
}
  
