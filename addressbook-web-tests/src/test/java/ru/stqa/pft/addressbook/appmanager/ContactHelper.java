package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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
  
  public void DeleteContact(int index) {
  
    wd.findElements(By.name("selected[]")).get(index).click();
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    
  }
  
  public void InitContactModification(int index)
  {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    
  }
  
  public void SubmitContactModification() {
  
    click(By.name("update"));
  }
  
  public void create(ContactData contact) {
    
    gotoHomePage();
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    gotoHomePage();
    
  }
  
  public void modify(int index, ContactData contact) {
    InitContactModification(index);
    fillContactForm(contact, false);
    SubmitContactModification();
    gotoHomePage();
  }
  
  public void delete(int index) {
    DeleteContact(index);
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
  
  public List<ContactData> list() {
  
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(WebElement element: elements)
    {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
        String lastname = cells.get(1).getText();
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
    
  }
}