package rahulshetty.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshetty.Abstractcomponents.abstractcomponent;

public class productcatalogue extends abstractcomponent
{
	
	WebDriver driver;

	public productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



    By toast =  By.cssSelector("#toast-container");
	@FindBy(css=".col-lg-4.col-md-6")
	List<WebElement> products;
	
	By productby =  By.cssSelector(".col-lg-4.col-md-6");
	By addtocart = By.cssSelector("i.fa.fa-shopping-cart");
	
	public List<WebElement> getproductlist()
	{
		waitforelementtoappear(productby);
		return products;
	}
	
	public WebElement getproductname(String productname)
	{
		WebElement product = getproductlist().stream()
	.filter(prd -> prd.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productname))
		.findFirst().orElse(null);
		return product;
	}
	
	public void addproductTocart(String productname) throws InterruptedException
	{
		getproductname(productname).findElement(addtocart).click();
		waitforinvisibility(toast);
	//	Thread.sleep(2000);
	}
	
	

}
