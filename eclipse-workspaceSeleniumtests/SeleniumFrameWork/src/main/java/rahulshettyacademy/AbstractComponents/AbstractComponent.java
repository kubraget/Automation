package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.prgeobject.CartPage;
import rahulshettyacademy.prgeobject.OrderPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void WaitElementAppear(By findBy)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	public void WaitElementApp(WebElement findby)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(findby));
	}
	public void WaitElementDisAppear(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	@FindBy (css="[routerlink*='cart']")
	WebElement cartclick;
	public CartPage goToCartPage()
	{
		cartclick.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
}
