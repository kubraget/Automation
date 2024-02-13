import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;



public class SetGeoLocation2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 37,127
		//ChromeOptions to include geolocation data and set the language to Spanish      
		ChromeOptions options = new ChromeOptions();        
		options.addArguments("--enable-features=Geolocation");       
		options.addArguments("--lang=es"); 
		// Set the browser language to Spanish
        // Launch Chrome browser with the defined options       
		WebDriver driver = new ChromeDriver(options);
        // Set the geolocation using CDP       
		double latitude = 37;      
		double longitude = 127;        
		double accuracy = 1;       
		DevTools devTools = ((ChromeDriver) driver).getDevTools();       
		devTools.createSession();        
		devTools.send(Emulation.setGeolocationOverride(Optional.of(latitude), Optional.of(longitude), Optional.of(accuracy)));
        // Perform a Google search for "Netflix is open Spanish language"       
		driver.get("https://www.google.com");      
		WebElement searchBox = driver.findElement(By.name("q"));       
		searchBox.sendKeys("Netflix");       
		searchBox.submit();
        // Wait for the results to load and perform other actions as needed      
		Thread.sleep(5000);        
		// Close the browser      
		String title = driver.findElement(By.cssSelector(".LC20lb")).getText();
		System.out.println(title);   
	}

}
