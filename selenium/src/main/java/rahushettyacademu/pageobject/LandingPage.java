package rahushettyacademu.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.project.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login")
	WebElement submit;
	@FindBy(id = "userEmail")
	WebElement userEmail;
	@FindBy(id = "userPassword")
	WebElement Password;

	public ProductCatLogue LoginApp(String email, String password) {
		userEmail.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
		ProductCatLogue productcatlog = new ProductCatLogue(driver);
		return productcatlog;
	}

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public String getErrorMess() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
