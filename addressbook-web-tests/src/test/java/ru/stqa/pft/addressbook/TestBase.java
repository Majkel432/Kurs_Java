package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
  
  public WebDriver wd;
  
  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
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
  
  
  protected void returnGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }
  
  protected void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }
  
  protected void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }
  
  protected void initGroupCreation() {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test2'])[1]/following::input[1]")).click();
  }
  
  protected void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
  
  protected void Logout() {
    wd.findElement(By.linkText("Logout")).click();
  }
  
  protected void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }
  
  protected void fillContactForm(GroupData2 groupData2) {
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
  
  protected void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }
  
  private void Login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.id("LoginForm")).submit();
  }
  
  
  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
    
  }
  
  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  
  protected void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }
  
  protected void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
  
  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  
  }
}

