package rahulshetty.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
   public static ExtentReports getreportobject()
   {
	     String path =  System.getProperty("user.dir")+"//reports//index.html";
	     ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	     reporter.config().setReportName("Web Automation Results");
	     reporter.config().setDocumentTitle("Test results");
	     ExtentReports extent = new ExtentReports();
	     extent.attachReporter(reporter);
	     extent.setSystemInfo("Tester", "Dennys");
	     return extent;
   }
}
