package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupData2;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  
  
  public WebDriver wd;
  
  
  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }
  
  public void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.id("LoginForm")).submit();
  }
  
  public void returnGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }
  
  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }
  
  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }
  
  public void initGroupCreation() {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test2'])[1]/following::input[1]")).click();
  }
  
  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
  
  public void Logout() {
    wd.findElement(By.linkText("Logout")).click();
  }
  
  public void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }
  
  public void fillContactForm(GroupData2 groupData2) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(groupData2.getFirstname());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(groupData2.getLastname());
    wd.findElement(By.name("lastname")).sendKeys(Keys.DOWN);
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("Nowak");
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(groupData2.getEmail());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(groupData2.getHome());
  }
  
  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }
  
  public void Login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.id("LoginForm")).submit();
  }
  
  public void stop() {
    wd.quit();
  }
  
  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  
  public void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }
  
  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
  
 }
