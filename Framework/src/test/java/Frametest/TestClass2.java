package Frametest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.MessengerPage;
import Pages.RoomsPage;

public class TestClass2 {

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
		//messengerPage.openRooms();
		
		//roomsPage = new RoomsPage(driver);
		//roomsPage.contactToHelpCenter();
		//roomsPage.goBackToMessenger();
		
	}
	
	@Test
	public void openMessengerPage() {
		
		messengerPage.openRooms();
	}
	
	@Test
	public void openFeaturePage() {
		
		messengerPage.openFeatures();
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
