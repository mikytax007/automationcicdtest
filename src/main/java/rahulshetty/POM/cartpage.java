package rahulshetty.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import rahulshetty.Abstractcomponents.abstractcomponent;

public class cartpage extends abstractcomponent
{
     WebDriver driver;
	public cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(css=".cartWrap.ng-star-inserted")
	List<WebElement> cartproducts;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutcli;
	
	
//	

   
//	driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Checkout']")));	
//	 List<WebElement> cartproducts =  driver.findElements(By.cssSelector(".cartWrap.ng-star-inserted"));    
//        Boolean match = cartproducts.stream().anyMatch(b->b.findElement(By.cssSelector("h3")).getText()
//        		.equalsIgnoreCase(productname));    
//        Assert.assertTrue(match);       
//        driver.findElement(By.xpath("//button[text()='Checkout']")).click();

	public Boolean verifyproduct(String productname)
	{
		Boolean match = cartproducts.stream().anyMatch(b->b.findElement(By.cssSelector("h3")).getText()
        		.equalsIgnoreCase(productname)); 

		return match;	
	}
	
	public checkoutpage checkoutclicking() throws InterruptedException
	{
		Thread.sleep(2000);
		checkoutcli.click();
		checkoutpage checkoutpage = new checkoutpage(driver);
		return checkoutpage;
	}
	
	
	
}
