package Test.PagesSetup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.This;

public class SignInPageFactory {
	private WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	@FindBy(xpath = "//a[normalize-space()='Forgot Username/Password?']")
	private WebElement headerPageText;
	
	@FindBy(id = "EmailInputEmail")
	private WebElement emailInput;
	
	@FindBy(id = "PasswordInputPassword")
	private WebElement passwordInput;

	@FindBy(id = "SignInButton")
	private WebElement signinBtn;

	@FindBy(id = "signInError")
	private WebElement errorMsgText;

	@FindBy(id = "Pin")
	private WebElement pinInput;
	@FindBy(id = "RequestPinForm_SubmitButton")
	private WebElement submitBtn;
	@FindBy(id = "RequestPinForm_Back")
	private WebElement backBtn;
	@FindBy(id = "RequestPinForm_ResetPin")
	private WebElement resetPintBtn;
	public SignInPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Viết hàm signin không cần dùng các hàm hỗ trợ enter hay click nữa
	public void signin(String username, String password, String Pin) throws Exception {
		setText(emailInput, username);//emailInput.sendKeys(username);
		setText(passwordInput, password);//passwordInput.sendKeys(password);
		clickElement(signinBtn);//signinBtn.click();
		
		setText(pinInput, Pin);//pinInput.sendKeys(Pin);
		clickElement(submitBtn);//submitBtn.click();
		}
	
	private void setText(WebElement element, String valueText) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(valueText);
	}
	private void clickElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	

}
