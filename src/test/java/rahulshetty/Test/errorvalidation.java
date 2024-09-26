package rahulshetty.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
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
import org.testng.annotations.Test;

import rahulshetty.POM.cartpage;
import rahulshetty.POM.checkoutpage;
import rahulshetty.POM.confirmationpage;
import rahulshetty.POM.landingpage;
import rahulshetty.POM.productcatalogue;
import rahulshetty.testcomponent.Retry;
import rahulshetty.testcomponent.basetest;

public class errorvalidation extends basetest {
	@Test(groups= {"error"},retryAnalyzer=Retry.class)
	public void loginerrormsg() throws IOException, InterruptedException {
		String productname = "ZARA COAT 3";
		 landingpage.loginapplication("kallaa@gmail.com", "Dennys@123");
       Assert.assertEquals(landingpage.geterrormessage(), "Incorrect email or password."); 
	}
	@Test
	public void producterrorvalidation() throws IOException, InterruptedException {
		String productname = "ZARA COAT 3";

		productcatalogue productcatalogue = landingpage.loginapplication("kalli@gmail.com", "Dennys@123");

		List<WebElement> listofproducts = productcatalogue.getproductlist();
		productcatalogue.getproductname(productname);
		productcatalogue.addproductTocart(productname);

		cartpage cartpage = productcatalogue.cartclick();

		Boolean match = cartpage.verifyproduct("ZARA COAT 33");
		Assert.assertFalse(match);

}
}
