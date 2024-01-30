package rahushettyacademu.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractcomponents.project.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By CountryBy = By.cssSelector(".ta-results");
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement button;
	@FindBy(css = ".action__submit")
	WebElement action;

	public void SelectCountry(String Cname) {
		Actions a = new Actions(driver);
		a.sendKeys(country, "India").build().perform();
		waitEleToAppear(CountryBy);
		button.click();
		}
	public ConfirmPage SubmitOrder()
	{
		action.click();
		ConfirmPage confirm = new ConfirmPage(driver);
		return confirm;

	}

}
