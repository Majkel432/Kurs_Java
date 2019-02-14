package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddContactTests extends TestBase {
  
  
  @Test
  public void AddContactTest() throws Exception {
    
    
    
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Jan", "Nowak", "example@poczta.fm", "987654321", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }
  
}
  
