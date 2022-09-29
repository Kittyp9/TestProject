package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;

	//Declaration of POM class
	@FindBy(xpath= "//input[@id='email']") 
	private WebElement userName;
	
	@FindBy(xpath= "//input[@aria-label='Password']") 
	private WebElement password;
	
	@FindBy(xpath= "//input[@id='email']") 
	private WebElement loginButton;
	
	@FindBy(xpath= "(//a[@role='button']) [2]") 
	private WebElement createNewAccount;
	
	@FindBy(xpath= "//a[text()='Messenger']") 
	private WebElement messengerlink;
	
	
	//Intialization 
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	//Use
	public void sendUserName() {
		WebDriverWait wait= new WebDriverWait(driver,10); // 10 sec
		wait.until(ExpectedConditions.visibilityOf(createNewAccount));
		userName.sendKeys("Kirti2309@gmail.com");
	}
	
	public boolean checkPasswordIsDisplayed() {
		return password.isDisplayed();
	}
	//public void sendPassword() {
		//password.sendKeys("Kirti123");
	//}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickOnCreatNewAcc() {
		Actions act= new Actions(driver);
		act.moveToElement(createNewAccount).click().build().perform();
		//createNewAccount.click();
	}
	
	public void openMessenger() {
		messengerlink.click();
	}
	
	//OR
	//Complete Functionality
	public void loginFacebook() {
		userName.sendKeys("Kirti");
		password.sendKeys("Kirti123");
		loginButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
