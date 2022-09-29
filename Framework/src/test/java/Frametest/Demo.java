package Frametest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.MessengerPage;
import Pages.RoomsPage;

public class Demo {
	
	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kirti\\Documents\\Testing\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openMessenger();
		
		if(loginPage.checkPasswordIsDisplayed()==true) {
			System.out.println("Display");
		}
		else {
			System.out.println("Not Display");
		}
		
		MessengerPage messengerPage = new MessengerPage(driver);
		messengerPage.openRooms();
		//messengerPage.openFeatures();
		Thread.sleep(3000);
		
		RoomsPage roomsPage = new RoomsPage(driver);
		roomsPage.contactToHelpCenter();
		//roomsPage.goBackToMessenger();
		
		System.out.println(driver.getCurrentUrl());
		
		

	}

}
