package rahushettyacademu.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.project.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProduct;

	public Boolean verifyProduct(String name) {
		Boolean match = cartProduct.stream().anyMatch(cartP -> cartP.getText().equalsIgnoreCase(name));
		return match;
	}

	@FindBy(css = ".totalRow button")
	WebElement on;

	public CheckOutPage clickOn() {
		on.click();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;

	}
}
