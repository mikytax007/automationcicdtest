package rahulshetty.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshetty.Abstractcomponents.abstractcomponent;

public class confirmationpage extends abstractcomponent
{
	WebDriver driver;
	
	public confirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="hero-primary")
	WebElement actual;
	
	
//	String actualtext = driver.findElement(By.className("hero-primary")).getText();
//	Assert.assertEquals(actualtext, "THANKYOU FOR THE ORDER.");
	
	public String verifyconfirmationmsg()
	{
	  return actual.getText();
	}

}
