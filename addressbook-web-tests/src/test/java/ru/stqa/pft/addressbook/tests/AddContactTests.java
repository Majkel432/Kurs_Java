package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class AddContactTests extends TestBase {
  
  @DataProvider
  public Iterator<Object[]> validContacts ()
  {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstname("firstname1").withLastname("lastname1").withGroup("test1")});
    list.add(new Object[] {new ContactData().withFirstname("firstname2").withLastname("lastname2").withGroup("test2")});
    list.add(new Object[] {new ContactData().withFirstname("firstname3").withLastname("lastname3").withGroup("test3")});
    return list.iterator();
  }
  
  @Test (dataProvider = "validContacts")
  public void AddContactTest(ContactData contact) throws Exception {
    
      Contacts before = app.contact().all();
      File photo = new File("src/test/resources/stru.png");
      app.contact().create(contact);
      assertThat(app.contact().count(), equalTo(before.size() + 1));
      Contacts after = app.contact().all();
  
      assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
  @Test
  public void AddBadContactTest() throws Exception {
    
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Krzysztof'").withLastname("Derek").withEmail("krzysztof.derek@interia.pl").withHomePhone("123456789").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    
    assertThat(after, equalTo(before));
    
  }
  
}
  
