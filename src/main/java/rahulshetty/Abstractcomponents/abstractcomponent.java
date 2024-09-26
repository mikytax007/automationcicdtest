package rahulshetty.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshetty.POM.cartpage;
import rahulshetty.POM.orderpage;

public class abstractcomponent {

WebDriver driver;
	public abstractcomponent(WebDriver driver) {
    this.driver=driver;
      PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartmain;
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderpagemain;
	
	By waiting =  By.xpath("//button[text()='Checkout']");
	
	public void waitforelementtoappear(By findby)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforinvisibility(By findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));	
	wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
	}
	
	public void waitforwebelementtoappear(WebElement findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));	
	wait.until(ExpectedConditions.visibilityOf(findby));
	}
	
	public cartpage cartclick()
	{
		cartmain.click();
		waitforelementtoappear(waiting);
		 cartpage cartpage = new cartpage(driver);
		 return cartpage;
	}
	
	public orderpage orderclick()
	{
		orderpagemain.click();
		orderpage orderpage=new orderpage(driver);
		return orderpage;
	}
	
}
