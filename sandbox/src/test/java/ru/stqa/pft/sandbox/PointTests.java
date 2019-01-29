package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.stqa.pft.sandbox.MyFirstProgram.distance;

public class PointTests {
  @Test
  public void TestDistance ()
  
  {
     Point p1 = new Point (2,5);
     Point p2 = new Point (5,9);
     
    Assert.assertEquals(distance (p1,p2), 5.0);
     
  }

}


