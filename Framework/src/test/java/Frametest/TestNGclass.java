package Frametest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.LoginPage;
import Pages.MessengerPage;
import Pages.RoomsPage;

public class TestNGclass {

	private WebDriver driver;
	private LoginPage loginPage;
	private MessengerPage messengerPage;
	private RoomsPage roomsPage;
	
	@BeforeClass
	public void openBrowser()
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kirti\\Documents\\Testing\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void openRoomPage()
	{
		driver.get("https://www.facebook.com/");
		
		loginPage = new LoginPage(driver);
		loginPage.openMessenger();
		
		messengerPage = new MessengerPage(driver);
		messengerPage.openRooms();
		
		roomsPage = new RoomsPage(driver);
		//roomsPage.contactToHelpCenter();
		//roomsPage.goBackToMessenger();
		
	}
	
	@Test
	public void verifyReturnToMessengerButton()
	{
		roomsPage.goBackToMessenger();
		String url= driver.getCurrentUrl();
		String title= driver.getTitle();
		Assert.assertEquals(url, "https://www.messenger.com/");
		Assert.assertEquals(title, "Messenger");
		
		if(url.equals("Pradip")&& title.equals("Kirti")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
	}
	
	@Test
	public void verifyContactToHelpCenterButton()
	{
		roomsPage.contactToHelpCenter();
		
		String url= driver.getCurrentUrl();
		String title= driver.getTitle();
		
		SoftAssert soft= new SoftAssert();
		//soft.assertEquals(url, "https://www.messenger.com/", "URL of HomePage is wrong");
		
	//	boolean result= url.equals("https://www.messenger.com/");
		//soft.assertTrue(result);
		//soft.assertFalse(result);
		//soft.fail();
		soft.assertAll();
		
		if(url.equals("Kirti")&& title.equals("Pradip")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
	}
	
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
		driver.close();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		System.out.println("LOGOUT");
	}
}
