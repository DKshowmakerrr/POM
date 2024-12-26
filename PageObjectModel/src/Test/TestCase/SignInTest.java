package Test.TestCase;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Base.BaseSetup;
import Test.PagesSetup.SignInPage;
import Test.PagesSetup.SignInPageFactory;
public class SignInTest extends BaseSetup {
	private WebDriver driver;
	public SignInPage signInPage;
	public SignInPageFactory signInPageFactory;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	
	@Test
	public void SignIn() {
		System.out.println(driver);
		//signInPage = new SignInPage(driver);
		assertEquals(signInPage.getSignInPageTitle(), "Sign In page title doesn't match");
		
		signInPageFactory = new SignInPageFactory(driver);
		signInPageFactory.signin(dat, abc123, 33);
	}
	
	
	
	
}
