package rahulshetty.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshetty.Abstractcomponents.abstractcomponent;

public class checkoutpage extends abstractcomponent
{
	
	WebDriver driver;
	public checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement selectcountry;
	@FindBy(xpath="//span[normalize-space()='India'] //i")
	WebElement countryselectedindia;
	By waitcountry =  By.cssSelector(".fa.fa-search");
	@FindBy(css=".btnn.action__submit")
	WebElement placeorder;
//	@FindBy(css="[placeholder='Select Country']")
//	WebElement country;

//	a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']"))).sendKeys("Ind").build()
//			.perform();
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa.fa-search")));
//	a.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='India'] //i"))).click().build()
//			.perform();
//	a.moveToElement(driver.findElement(By.cssSelector(".btnn.action__submit"))).click().build().perform();
	
	public void selectcountry()
	{
		Actions a = new Actions(driver);
		//a.sendKeys(country, "India").build().perform();
		a.sendKeys(selectcountry, "Ind").build()
		.perform();
		waitforelementtoappear(waitcountry);
		a.moveToElement(countryselectedindia).click().build()
		.perform();
	}
	public confirmationpage placeordercclick()
	{
		Actions a = new Actions(driver);
		a.moveToElement(placeorder).click().build().perform();
		confirmationpage confirmationpage= new confirmationpage(driver);
		return confirmationpage;
	}
	
	
	}
