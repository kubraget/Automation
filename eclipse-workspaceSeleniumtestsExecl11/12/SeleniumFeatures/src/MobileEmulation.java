import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class MobileEmulation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
//devtools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(),Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty()));
		Map<String, Object> datametrics = new HashMap<String, Object>();
		datametrics.put("width", 600);
		datametrics.put("height", 1000);
		datametrics.put("deviceScaleFactor", 50);
		datametrics.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", datametrics);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Library")).click();

	}

}
