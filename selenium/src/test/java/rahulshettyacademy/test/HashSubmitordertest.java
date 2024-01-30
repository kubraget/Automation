package rahulshettyacademy.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstractcomponents.project.OrderPage;
import rahulshettyacademy.testComponent.BaseTest;
import rahushettyacademu.pageobject.CartPage;
import rahushettyacademu.pageobject.CheckOutPage;
import rahushettyacademu.pageobject.ConfirmPage;
import rahushettyacademu.pageobject.ProductCatLogue;

public class HashSubmitordertest extends BaseTest {
	String name;

	@Test(dataProvider = "getData", groups = { "Hash" })
	public void submitorder(HashMap<String, String> input) throws IOException {

		ProductCatLogue productcatlog = landingPage.LoginApp(input.get("ëmail"), input.get("password"));
		List<WebElement> products = productcatlog.getProductList();
		productcatlog.AddProduct(input.get(name));
		CartPage cartpage = productcatlog.goCart();
		Boolean match = cartpage.verifyProduct(name);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.clickOn();
		checkoutpage.SelectCountry("India");
		ConfirmPage confirm = checkoutpage.SubmitOrder();
		String ConfirmM = confirm.getMess();
		Assert.assertTrue(ConfirmM.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitorder" })
	public void OrderHistory()throws IOException {
		ProductCatLogue productcatlog = landingPage.LoginApp("arbuk001@gmail.com", "1112@Arbuk");
		OrderPage orderpage = productcatlog.goToOrderPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(name));
	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "arbuk001@gmail.com");
		map.put("password", "1112@Arbuk");
		map.put("name", "ADIDAS ORIGINAL");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "kubra001@gmail.com");
		map1.put("password", "Kubra@2001");
		map1.put("name", "ZARA COAT 3");
		return new Object[][] { { map }, { map1 } };

	}

}
