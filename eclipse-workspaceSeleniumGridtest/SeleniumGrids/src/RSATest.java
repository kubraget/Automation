import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RSATest {
@Test
public void HomePage() throws MalformedURLException
{
	DesiredCapabilities caps = new DesiredCapabilities(); 
	//caps.setBrowserName("chrome");
	//caps.setPlatform(Platform);
	//caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
	WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.4 :4444"),caps);
	driver.get("http://rahulshettyacademy.com");
	System.out.println(driver.getTitle());
	driver.close();
}
}
