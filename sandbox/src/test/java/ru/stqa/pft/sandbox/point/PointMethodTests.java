package ru.stqa.pft.sandbox.point;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;


public class PointMethodTests {
  
  @Test
  public void TestDistance ()
  {
    Point p = new Point(2.0,5.0,5.0,9.0);
    Assert.assertEquals(p.distance(), 5.0);
   
  }

}
