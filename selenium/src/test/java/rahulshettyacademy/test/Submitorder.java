package rahulshettyacademy.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractcomponents.project.OrderPage;
import rahulshettyacademy.testComponent.BaseTest;
import rahushettyacademu.pageobject.CartPage;
import rahushettyacademu.pageobject.CheckOutPage;
import rahushettyacademu.pageobject.ConfirmPage;
import rahushettyacademu.pageobject.ProductCatLogue;

public class Submitorder extends BaseTest {
	String name = "ADIDAS ORIGINAL";
	@Test
	public void submitorder() throws IOException{

		ProductCatLogue productcatlog = landingPage.LoginApp("arbuk001@gmail.com", "1112@Arbuk");
		List<WebElement> products= productcatlog.getProductList();
		productcatlog.AddProduct(name);
		CartPage cartpage = productcatlog.goCart();
		Boolean match = cartpage.verifyProduct(name);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.clickOn();
		checkoutpage.SelectCountry("India");
		ConfirmPage confirm = checkoutpage.SubmitOrder();
		String ConfirmM = confirm.getMess();
		Assert.assertTrue(ConfirmM.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	@Test(dependsOnMethods = {"submitorder"})
	public void OrderHistory()
	{
		ProductCatLogue productcatlog = landingPage.LoginApp("arbuk001@gmail.com", "1112@Arbuk");
		OrderPage orderpage = productcatlog.goToOrderPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(name));
	}

}
