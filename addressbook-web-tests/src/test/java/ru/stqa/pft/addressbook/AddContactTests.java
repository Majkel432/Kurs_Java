package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
  
  
  @Test
  public void AddContactTest() throws Exception {
    initContactCreation();
    fillContactForm(new GroupData2("Jan", "Nowak", "example@poczta.fm", "987654321"));
    submitContactCreation();
  }
  
}
  
