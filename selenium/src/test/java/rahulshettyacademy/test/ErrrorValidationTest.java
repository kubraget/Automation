package rahulshettyacademy.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.testComponent.BaseTest;
import rahushettyacademu.pageobject.CartPage;
import rahushettyacademu.pageobject.ProductCatLogue;

public class ErrrorValidationTest extends BaseTest {
	String name = "ADIDAS ORIGINAL";
	@Test(groups = {"ErrorHandling"})
	public void Error() throws IOException{

		landingPage.LoginApp("arbuk002@gmail.com", "1112@Arbuk");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMess());
	}
	@Test
	public void productErrorVal() throws IOException
	{
		String name = "ADIDAS ORIGINAL";
		ProductCatLogue productCatLogue = landingPage.LoginApp("arbuk001@gmail.com", "1112@Arbuk");
		productCatLogue.getProductList();
		productCatLogue.AddProduct(name);
		CartPage cartpage = productCatLogue.goCart();
		Boolean match = cartpage.verifyProduct("ADIDAS ORIGINAL 33");
		System.out.println(match);
		Assert.assertFalse(match);
	

	}
	
		

	
}
