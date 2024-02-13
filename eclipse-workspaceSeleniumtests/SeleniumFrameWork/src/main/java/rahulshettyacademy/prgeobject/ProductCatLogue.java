package rahulshettyacademy.prgeobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatLogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatLogue(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	By productBy = By.cssSelector(".mb-3");
	@FindBy (css=".mb-3")
	List<WebElement> products; 
	public List<WebElement> getProductList()
	{
		WaitElementAppear(productBy);
		return products;
	}
	public WebElement getProductName(String Pname)
	{
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(Pname)).findFirst()
				.orElse(null);
		return prod;
	}
	By add = By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");
	@FindBy (css=".ng-animating")
	WebElement spinner;
	public void AddProduct(String Pname)
	{
		WebElement prod = getProductName(Pname);
		prod.findElement(add).click();
		WaitElementAppear(toastmessage);
		WaitElementDisAppear(spinner);
		
	}
}
