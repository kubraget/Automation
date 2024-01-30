package rahushettyacademu.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import abstractcomponents.project.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> oderProduct;
	

	public Boolean VerifyOrderDisplay(String name) {
		Boolean match = oderProduct.stream().anyMatch(Product -> Product.getText().equalsIgnoreCase(name));
		return match;

	}

}
