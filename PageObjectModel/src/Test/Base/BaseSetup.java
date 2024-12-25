package Test.Base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import org.openqa.selenium.WebDriver;
public class BaseSetup {
	private WebDriver driver;
	
	static String driverPath = "resources\\drivers";
	
	public WebDriver getDriver(){
		return driver;
	}
	
	//hàm này để tùy chọn browser, cho chạy trước khi gọi class này
	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome": {
			driver = initChromeDriver(appURL);
			break;
		}
		case "firefox":{
			driver = initFirefoxDriver(appURL);
			break;
		}
		default:
			System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
			driver = initChromeDriver(appURL);
		}
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser...");
		System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver;
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching Chrome browser...");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver;
		ass
	}
	//chạy hàm initializeTestBaseSetup trước khi class này được gọi
	@Parameters({"browserType","appURL" } );
	@BeforeClass
	public void initializeTestBaseSetUp(String browserType, String appURL) {
		try {
			//khởi tạo driver và browser
			setDriver(browserType, appURL);
		} catch (Exception e) {
			System.out.println("Error..."+e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		Thread.sleep(2000);
		driver.quit();
	}
	

}
