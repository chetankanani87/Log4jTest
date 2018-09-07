package log4jTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lib.BrowserDriverUtility;
import lib.ScreenshotUtility;

public class Log4jTest {
	WebDriver dr;
	WebElement ele;
	String path1, path2;
	Logger logger;

	public void ProgStart() {
		logger = Logger.getLogger("Log4jTest");
		PropertyConfigurator.configure("Log4j.properties");
		
		dr = BrowserDriverUtility.InvokeBrowser("webdriver.chrome.driver",
				"C:\\Chetan\\SeleniumSuite\\WebDrivers\\chromedriver.exe", "http://www.ksrtc.in");
		logger.info("Chrome Opened and Browser maximized and KSRTC website opened.");
		
		ScreenshotUtility.CaptureScreenshot(dr, "1_MainPage");
		logger.info("Screenshot captured.");
		
		dr.findElement(By.xpath("//input[@name='searchBtn']")).click();
		logger.info("Clicked on search button.");
		
		String actualMsg = dr.switchTo().alert().getText();
		logger.info("Captured text.");
		
		System.out.println("Alert message is: " + actualMsg);
		
		dr.switchTo().alert().accept();
		logger.info("Accepted alert window.");
	}

	public void tearDown() {
		dr.close();
		logger.info("Browser closed successfully. Congratulations...!!!");
	}
	
	public static void main(String[] args) {
		Log4jTest log = new Log4jTest();
		log.ProgStart();
		log.tearDown();
	}
}
