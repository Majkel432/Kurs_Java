package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("address"),contactData.getAddress());
    
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  
  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  
  public void DeleteContactById(int id) {
    
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    
  }
  
  public void InitContactModificationById(int id) {
    
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).findElement(By.xpath("//img[@alt='Edit']")).click();
  }
  
  public void SubmitContactModification() {
  
    click(By.name("update"));
  }
  
  public void create(ContactData contact) {
    
    gotoHomePage();
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    gotoHomePage();
    
  }
  
  public void modify(ContactData contact) {
    InitContactModificationById (contact.getId());
    fillContactForm(contact, false);
    SubmitContactModification();
    contactCache = null;
    gotoHomePage();
  }
  
  public void delete(ContactData contact) {
    
    DeleteContactById(contact.getId());
    contactCache = null;
  }

  
  private void gotoHomePage() {
  
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
  
  private Contacts contactCache = null;
  
  public Contacts all() {
    
    if(contactCache != null)
    {
      return new Contacts(contactCache);
    }
    
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String allPhones = cells.get(5).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones));
    }
    return new Contacts(contactCache);
    
  }
  
  public int count() {
  
    return wd.findElements(By.name("selected[]")).size();
  }
  
  public ContactData infoFromEditForm(ContactData contact) {
    InitContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withAddress(address).withEmail(email).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    
  }
}