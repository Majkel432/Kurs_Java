package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class AddContactTests extends TestBase {
  
  @DataProvider
  public Iterator<Object[]> validContacts () throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null)
    {
      String[] split = line.split(";");
      list.add(new Object[]{new ContactData().withFirstname(split[0]).withLastname(split[1]).withEmail(split[2]).withAddress(split[3]).withHomePhone(split[4])});
      line = reader.readLine();
    }
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
  
