package rahulshettyacademy.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.prgeobject.CartPage;
import rahulshettyacademy.prgeobject.CheckOutPage;
import rahulshettyacademy.prgeobject.ConfirmPage;
import rahulshettyacademy.prgeobject.ProductCatLogue;
import rahulshettyacademy.testComponent.BaseTest;

public class dataProvider extends BaseTest {

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submit(String email, String password,String Pname) {
		ProductCatLogue productcatlogue = landingpage.LoginApplication(email, password);
		List<WebElement> products = productcatlogue.getProductList();
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

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "arbuk001@gmail.com", "1112@Arbuk", "ADIDAS ORIGINAL" },
				{ "kubra001@gmail.com", "Kubra@2001", "ZARA COAT 3" } };
	}

}
