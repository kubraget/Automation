package rahulshettyacademyBrowserStack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserStacktestdemo2 {

	@Test
	public void titleCheck() throws MalformedURLException {
		//http://bs-local.com:45454/
		//WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.4 :4444"),caps);
		MutableCapabilities caps = new MutableCapabilities();
		WebDriver driver = new RemoteWebDriver(new URL("http://bs-local.com:45454/"),caps);
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());

	}
}