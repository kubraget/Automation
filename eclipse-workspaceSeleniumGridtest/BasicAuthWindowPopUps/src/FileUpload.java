import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		// https://www.ilovepdf.com/pdf_to_jpg
		String downloadpath = System.getProperty("user.dir");// C:\Users\kanee\eclipse-workspaceSeleniumGridtest\BasicAuthWindowPopUps\src\FileUpload.java
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		Map<String, Object> Chromeprefs = new HashMap<String, Object>();
		Chromeprefs.put("profile.default_content_settings.popups", 0);
		Chromeprefs.put("download.default_directory", downloadpath);
		option.setExperimentalOption("prefs", Chromeprefs);

		WebDriver driver = new ChromeDriver(option);
		// WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.id("browse")).click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("C:\\Users\\kanee\\OneDrive\\Documents\\check\\fileuploaD.exe");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");// "submit_btn"
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[id='submit_btn']")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".w-5.h-5.animate-spin")));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		driver.findElement(By.linkText("Download")).click();
		// File f = new
		// File("C:\\Users\\kanee\\Downloads\\Solutiontoallexercises_1.zip");
		Thread.sleep(1000);
		File f = new File(downloadpath + "/Solutiontoallexercises_1.zip");
		if (f.exists()) {
			// System.out.println("file found");
			// f.delete();
			Assert.assertTrue(f.exists());
			if (f.delete())
				System.out.println("file deleted");
		}

	}

}
