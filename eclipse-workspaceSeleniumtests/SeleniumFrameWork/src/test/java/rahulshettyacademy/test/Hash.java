package rahulshettyacademy.test;

import java.io.IOException;
import java.util.HashMap;
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

public class Hash extends BaseTest {
	@Test(dataProvider = "goData", groups = { "Hash" })
	public void submit(HashMap<String, String> input) throws IOException {
		ProductCatLogue productcatlogue = landingpage.LoginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcatlogue.getProductList();
		productcatlogue.getProductName(input.get("Pname"));
		productcatlogue.AddProduct(input.get("Pname"));
		CartPage cartpage = productcatlogue.goToCartPage();
		Boolean match = cartpage.VerifyCartProducts(input.get("Pname"));
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheckoutPage();
		checkoutpage.getCountryName();
		ConfirmPage confirmpage = checkoutpage.goToConfirmPage();
		String confirmMessage = confirmpage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}


	@DataProvider
	public Object[][] goData() throws IOException {
		//HashMap<String, String> map = new HashMap<String, String>();
		//map.put("email", "arbuk001@gmail.com");
		//map.put("password", "1112@Arbuk");
		//map.put("Pname", "ADIDAS ORIGINAL");

		//HashMap<String, String> map1 = new HashMap<String, String>();
		//map1.put("email", "kubra001@gmail.com");
		//map1.put("password", "Kubra@2001");
		//map1.put("Pname", "ZARA COAT 3");
		List<HashMap<String,String>> data = getJsonnDataToMap(System.getProperty("user.dir") + "//src//test//java//rahulshettyacademy//data//HashOrder.json");
		return new Object[][] { {data.get(0) }, { data.get(1)} };
	}

}
