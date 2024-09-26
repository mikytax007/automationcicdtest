package rahulshetty.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetty.Abstractcomponents.abstractcomponent;

public class orderpage extends abstractcomponent

{
WebDriver driver;
	public orderpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    @FindBy(css="tr td:nth-child(3)") 
    List<WebElement> productnames;
	
	public Boolean verifyorderdisplay(String productname)
	{
	Boolean match =	productnames.stream().anyMatch(prd->prd.getText().equalsIgnoreCase(productname));
		return match;
	}
}
