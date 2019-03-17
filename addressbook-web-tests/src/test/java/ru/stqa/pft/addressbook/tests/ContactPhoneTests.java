package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;




public class ContactPhoneTests extends TestBase {
  
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();
    if(app.contact().all().size() == 0)
    {
      app.contact().create(new ContactData().withFirstname("Jan").withLastname("Nowak").withAddress("ul.Korfantego 2/4 50-345 Kalisz").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("jan.nowak@interis.pl").withGroup("test1"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactPhones()
  {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  
    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
  }
  
  public String cleaned (String phone)
  {
    return phone. replaceAll("\\s","").replaceAll("[-()]","");
  }

}
