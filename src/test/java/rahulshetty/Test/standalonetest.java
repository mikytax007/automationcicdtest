package rahulshetty.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class standalonetest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("kalla@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Dennys@123");
		driver.findElement(By.cssSelector("#login")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4.col-md-6")));
		List<WebElement> listofproducts = driver.findElements(By.cssSelector(".col-lg-4.col-md-6"));
		WebElement product = listofproducts.stream()
				.filter(prd -> prd.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ZARA COAT 3"))
				.findFirst().orElse(null);
		product.findElement(By.cssSelector("i.fa.fa-shopping-cart")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Checkout']")));
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']"))).sendKeys("Ind").build()
				.perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa.fa-search")));
		a.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='India'] //i"))).click().build()
				.perform();
		a.moveToElement(driver.findElement(By.cssSelector(".btnn.action__submit"))).click().build().perform();
		Thread.sleep(2000);
		String actualtext = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(actualtext, "THANKYOU FOR THE ORDER.");

	}

}
