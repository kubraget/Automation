package rahulshettyacademy.StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.prgeobject.CartPage;
import rahulshettyacademy.prgeobject.CheckOutPage;
import rahulshettyacademy.prgeobject.ConfirmPage;
import rahulshettyacademy.prgeobject.LandingPage;
import rahulshettyacademy.prgeobject.ProductCatLogue;
import rahulshettyacademy.testComponent.BaseTest;

public class StepDefinationImpl extends BaseTest {
	public LandingPage landingpage;
	public ProductCatLogue productcatlogue;
	public ConfirmPage confirmpage;
	public WebDriver driver;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingpage = Launch();
	}

	@When("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_username_and_password(String username, String password) {
		productcatlogue = landingpage.LoginApplication(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) {
		List<WebElement> products = productcatlogue.getProductList();
		productcatlogue.AddProduct(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void Checkout_submit_order(String PName) {
		CartPage cartpage = productcatlogue.goToCartPage();
		Boolean match = cartpage.VerifyCartProducts(PName);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheckoutPage();
		checkoutpage.getCountryName();
		confirmpage = checkoutpage.goToConfirmPage();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_ConfirmationPage(String string) {
		String confirmMessage = confirmpage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}


	@Then("{string} message is displayed")
	public void message_displayed(String string) {
		Assert.assertEquals(string, landingpage.getErrorMess());
		
	}

}
