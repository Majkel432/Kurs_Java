package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {
  
  @BeforeMethod
  public void startMailServer ()
  {
    app.mail().start();
  }
  
  @Test
  public void testChangePassword () throws IOException, MessagingException {
    String user = "administrator";
    String password = "root";
    String user1 = "user1";
    String password1 ="password";
    String email1 = "user1@localhost.localdomain";
    app.changePassword().start(user, password);
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email1);
    app.changePassword().stop(confirmationLink, password1);
    assertTrue(app.newSession().login(user1, password1));
  }
  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
  
  @AfterMethod(alwaysRun = true)
  public void stopMailServer ()
  {
    app.mail().stop();
  }
}
