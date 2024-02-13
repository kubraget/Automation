import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.devtools.v119.network.model.ConnectionType;



public class Networkspeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		// to put waits
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		devTools.addListener(Network.loadingFailed(), loadingFailed ->
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		//driver.get("http://google.com");
		//driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		//driver.findElement(By.cssSelector(".LC20lb")).click();
		//String title = driver.findElement(By.cssSelector(".default-ltr-cache-jpuyb8")).getText();
		//System.out.println(title);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		driver.close();
		//14742 - 231021
		//541 - 3904
	}

}
