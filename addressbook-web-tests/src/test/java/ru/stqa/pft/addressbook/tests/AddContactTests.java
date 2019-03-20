package ru.stqa.pft.addressbook.tests;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class AddContactTests extends TestBase {
  
  @DataProvider
  public Iterator<Object[]> validContactsFromXml () throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml"))))
    {
      String xml = "";
      String line = reader.readLine();
      while (line != null)
      {
        xml+=line;
        line = reader.readLine();
    
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object [] {g}).collect(Collectors.toList()).iterator();
    }
  }
  
  @DataProvider
  public Iterator<Object[]> validContactsFromJson () throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json"))))
    {
      String json = "";
      String line = reader.readLine();
      while (line != null)
      {
        json+=line;
        line = reader.readLine();
    
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
      return contacts.stream().map((g) -> new Object [] {g}).collect(Collectors.toList()).iterator();
    }
  }
  
  @Test (dataProvider = "validContactsFromJson")
  public void AddContactTest(ContactData contact) throws Exception {
      app.goTo().homePage();
      Contacts before = app.db().contacts();
      File photo = new File("src/test/resources/stru.png");
      app.contact().create(contact);
      assertThat(app.contact().count(), equalTo(before.size() + 1));
      Contacts after = app.db().contacts();
  
      assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
  @Test
  public void AddBadContactTest() throws Exception {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData contact = new ContactData().withFirstname("Krzysztof'");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    
    assertThat(after, equalTo(before));
    
  }
  
}
  
