package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class ChangePasswordHelper extends HelperBase{
  
  public ChangePasswordHelper (ApplicationManager app)
  {
    super (app);
  }
  
  public void login (String username, String password){
  
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username") ,username);
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }
  
  public void managementPage ()
  {
    click(By.cssSelector("a[href='/mantisbt-1.2.20/manage_overview_page.php'"));
    click(By.cssSelector("a[href='/mantisbt-1.2.20/manage_user_page.php'"));
    
  }
  
  public void resetPassword (String userName){
  
    type(By.cssSelector("#username"), userName);
    click(By.cssSelector("input[value='Reset Password']"));
  }
  
  public void end (String confirmationLink, String password)
  {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));
  }
  
}
