import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
public class SetGeolocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		double latitude = 37;
		double  longitude = 127;
		double accuracy = 1;
		devtools.createSession();
		devtools.send(Emulation.setGeolocationOverride(Optional.of(latitude), Optional.of(longitude), Optional.of(accuracy)));
		driver.get("https://www.google.com");      
		WebElement searchBox = driver.findElement(By.name("q"));       
		searchBox.sendKeys("Netflix");       
		searchBox.submit();
		Thread.sleep(5000);
		String title = driver.findElement(By.cssSelector(".LC20lb")).getText();
		System.out.println(title); 
	}

}
