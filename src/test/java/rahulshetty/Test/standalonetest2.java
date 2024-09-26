package rahulshetty.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshetty.POM.cartpage;
import rahulshetty.POM.checkoutpage;
import rahulshetty.POM.confirmationpage;
import rahulshetty.POM.landingpage;
import rahulshetty.POM.orderpage;
import rahulshetty.POM.productcatalogue;
import rahulshetty.testcomponent.basetest;

public class standalonetest2 extends basetest {
	@Test(dataProvider="getdata",groups= {"purchasing"})
	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException {
		String productname = "ZARA COAT 3";
	
			productcatalogue productcatalogue = landingpage.loginapplication(input.get("email"), input.get("password"));

		List<WebElement> listofproducts = productcatalogue.getproductlist();
		productcatalogue.getproductname(input.get("product"));
		productcatalogue.addproductTocart(input.get("product"));

		cartpage cartpage = productcatalogue.cartclick();

		Boolean match = cartpage.verifyproduct(input.get("product"));
		Assert.assertTrue(match);
		checkoutpage checkoutpage = cartpage.checkoutclicking();
		checkoutpage.selectcountry();
		confirmationpage confirmationpage = checkoutpage.placeordercclick();
		String actualtext = confirmationpage.verifyconfirmationmsg();
		Assert.assertEquals(actualtext, "THANKYOU FOR THE ORDER.");

	}
	@Test(dependsOnMethods= {"submitorder"})
	public void orderhistorytest()
	{
		String productname = "ZARA COAT 3";
		productcatalogue productcatalogue = landingpage.loginapplication("kalla@gmail.com", "Dennys@123");
		orderpage orderpage =   productcatalogue.orderclick();
		Assert.assertTrue(orderpage.verifyorderdisplay(productname));
		
		
	}
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		List<HashMap<String, String>> data =	getjsondatatomap(System.getProperty("user.dir")+"//src//test//java//rahulshetty//data//purchaseorder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	

}
