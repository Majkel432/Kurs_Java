package ru.stq.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

  
  public class TestBase {
    
    private boolean isIssueOpen(int issueId) throws IOException {
      Set<Issue> issues = getIssues();
      Iterator<Issue> iterator = issues.iterator();
      while (iterator.hasNext()) {
        Issue issue = iterator.next();
        if (issue.getId() == issueId) {
          if (issue.getState_name().equals("resolved")) {
            return false;
          } else return true;
        }
      }
      return false;
    }
    
    private Set<Issue> getIssues() throws IOException {
      RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
      String json = RestAssured.get("http://demo.bugify.com/api/issues.json").asString();
      JsonElement parsed = new JsonParser().parse(json);
      JsonElement issues = parsed.getAsJsonObject().get("issues");
      return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
      }.getType());
    }
    
    public void skipIfNotFixed(int issueId) throws IOException {
      if (isIssueOpen(issueId)) {
        throw new SkipException("Ignored because of issue " + issueId);
      }
    }
  }