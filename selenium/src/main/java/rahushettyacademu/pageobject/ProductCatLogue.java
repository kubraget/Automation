package rahushettyacademu.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractcomponents.project.AbstractComponent;

public class ProductCatLogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatLogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By productBy = By.cssSelector(".mb-3");

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	public List<WebElement> getProductList() {
		waitEleToAppear(productBy);
		return products;
	}

	public WebElement ProductList(String name) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst()
				.orElse(null);
		return prod;
	}

	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	public void AddProduct(String name) {
		WebElement prod = ProductList(name);
		prod.findElement(addtocart).click();
		waitEleToAppear(toastmessage);
		waitEletoDisappear(spinner);

	}

}
