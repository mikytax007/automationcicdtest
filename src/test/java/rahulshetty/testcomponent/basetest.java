package rahulshetty.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahulshetty.POM.landingpage;

public class basetest 
{
	public WebDriver driver;
	public landingpage landingpage;
	@Test
	public WebDriver initialisedriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshetty//resources//globaldata.properties");
		prop.load(fis);
		String browsername =	System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
//		String browsername  = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
		    driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();		
		}
		

		
		//String browsername = property.getProperty("browser");
//		if(browsername.contains("chrome"))
//		{
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("headless");
//			if(browsername.contains("headless"))
//			{
//				options.addArguments("headless");
//			}
//			driver = new ChromeDriver(options);
//			driver.manage().window().setSize(new Dimension(1440,900));
//		}
//		else if (browsername.equalsIgnoreCase("firefox")) {
//
//			driver = new FirefoxDriver();
//
//			}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	//	driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1440,900));
		return driver;
	}
	@BeforeMethod(alwaysRun=true)
	public landingpage launchappliation() throws IOException
	{
		driver  = initialisedriver();
		landingpage = new landingpage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.quit();
	}
	
	public List<HashMap<String, String>> getjsondatatomap(String filepath) throws IOException
	{
	String jsoncontent =	FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
	ObjectMapper object = new ObjectMapper();
	List<HashMap<String,String>> data = object.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>()
	{});
	return data;
	}	
	
	public String getscreenshot(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		//has the capability of taking photo from the driver
		File source =    ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+ testcasename+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+ testcasename+".png";
	}
	
}
