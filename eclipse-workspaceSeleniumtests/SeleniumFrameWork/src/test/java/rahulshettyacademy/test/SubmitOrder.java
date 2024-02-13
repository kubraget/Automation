package rahulshettyacademy.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.prgeobject.CartPage;
import rahulshettyacademy.prgeobject.CheckOutPage;
import rahulshettyacademy.prgeobject.ConfirmPage;
import rahulshettyacademy.prgeobject.OrderPage;
import rahulshettyacademy.prgeobject.ProductCatLogue;
import rahulshettyacademy.testComponent.BaseTest;

public class SubmitOrder extends BaseTest {
	String Pname = "ADIDAS ORIGINAL";
	@Test
	public void submit() {
		ProductCatLogue productcatlogue = landingpage.LoginApplication("arbuk001@gmail.com", "1112@Arbuk");
		productcatlogue.getProductName(Pname);
		productcatlogue.AddProduct(Pname);
		CartPage cartpage = productcatlogue.goToCartPage();
		Boolean match = cartpage.VerifyCartProducts(Pname);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheckoutPage();
		checkoutpage.getCountryName();
		ConfirmPage confirmpage = checkoutpage.goToConfirmPage();
		String confirmMessage = confirmpage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "submit" })
	public void SubmitPage() {
		ProductCatLogue productcatlogue = landingpage.LoginApplication("arbuk001@gmail.com", "1112@Arbuk");
		productcatlogue.getProductName(Pname);
		productcatlogue.AddProduct(Pname);
		OrderPage orderpage = productcatlogue.goToOrderPage();
		Boolean match = orderpage.VerifyOrderDisplay(Pname);
		Assert.assertTrue(match);

	}
	

	

}
