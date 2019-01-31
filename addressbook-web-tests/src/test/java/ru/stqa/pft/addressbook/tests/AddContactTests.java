package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData2;

public class AddContactTests extends TestBase {
  
  
  @Test
  public void AddContactTest() throws Exception {
    app.initContactCreation();
    app.fillContactForm(new GroupData2("Jan", "Nowak", "example@poczta.fm", "987654321"));
    app.submitContactCreation();
  }
  
}
  
