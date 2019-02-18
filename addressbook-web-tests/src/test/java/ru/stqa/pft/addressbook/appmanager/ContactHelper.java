package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
  
  public ContactHelper(WebDriver wd) {
    
    super(wd);
  }
  
  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }
  
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("email"), contactData.getEmail());
    type(By.name("home"), contactData.getHome());
    
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else
    {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  
  public void initContactCreation() {
    click(By.linkText("add new"));
  }
  
  public void DeleteContact() {
  
    click(By.name("selected[]"));
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    
  }
  
  public void InitContactModification()
  {
    click(By.xpath("//img[@alt='Edit']"));
    
  }
  
  public void SubmitContactModification() {
  
    click(By.name("update"));
  }
  
  public void createContact(ContactData contact) {
    
    gotoHomePage();
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    
  }
  
  private void gotoHomePage() {
  
    if(isElementPresent(By.id("maintable")))
    {
      return;
    }
    click(By.linkText("home"));
  }
  
  public boolean isThereAContact() {
  
    return isElementPresent(By.name("selected[]"));
  }
  
  public int getContactCount() {
  
    return wd.findElements(By.name("selected[]")).size();
  }
}