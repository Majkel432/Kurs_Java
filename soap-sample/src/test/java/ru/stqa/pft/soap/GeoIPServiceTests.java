package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIPServiceTests {

  @Test
  public void testMyIp ()
  {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("84.38.212.225");
    Assert.assertEquals(ipLocation, "<GeoIP><Country>PL</Country><State>72</State></GeoIP>");
    
  }
  @Test
  public void testInvalidIp ()
  {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("xxx.xxx.xxx.xxx");
    Assert.assertEquals(ipLocation, "<GeoIP><Country>PL</Country><State>72</State></GeoIP>");
    
  }

}
