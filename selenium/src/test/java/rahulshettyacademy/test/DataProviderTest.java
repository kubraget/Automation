package rahulshettyacademy.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.testComponent.BaseTest;
import rahushettyacademu.pageobject.CartPage;
import rahushettyacademu.pageobject.CheckOutPage;
import rahushettyacademu.pageobject.ConfirmPage;
import rahushettyacademu.pageobject.ProductCatLogue;

public class DataProviderTest extends BaseTest {
	String name;
	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitorder(String email, String password, String name) throws IOException{

		ProductCatLogue productcatlog = landingPage.LoginApp(email,password);
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
	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "arbuk001@gmail.com", "1112@Arbuk", "ADIDAS ORIGINAL" },
				{ "kubra001@gmail.com", "Kubra@2001", "ZARA COAT 3" } };
	}


}
