package rahulshetty.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetty.Abstractcomponents.abstractcomponent;

public class landingpage extends abstractcomponent
{
	WebDriver driver;
	
	public landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
//	driver.findElement(By.cssSelector("#userEmail")).sendKeys("kalla@gmail.com");
//	driver.findElement(By.cssSelector("#userPassword")).sendKeys("Dennys@123");
//	driver.findElement(By.cssSelector("#login")).click();
	@FindBy(css="#userEmail")
	WebElement useremail;
	
	@FindBy(css="#userPassword")
	WebElement password;
	
	@FindBy(css="#login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessgae;
	
	public productcatalogue loginapplication(String email,String pw)
	{
		useremail.sendKeys(email);
		password.sendKeys(pw);
		submit.click();
		productcatalogue productcatalogue= new productcatalogue(driver);
		return productcatalogue;
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	public String geterrormessage()
	{
		waitforwebelementtoappear(errormessgae);
	 return	errormessgae.getText();
	
	}
	
	
	
}
