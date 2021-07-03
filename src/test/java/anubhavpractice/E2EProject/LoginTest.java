package anubhavpractice.E2EProject;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

import pageObject.HomePage;
import pageObject.LoginPage;
import resources.baseClass;

public class LoginTest extends baseClass {
	
	public static Logger log = LogManager.getLogger(LoginTest.class.getName());
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException {	
		
		driver= invokeBrowser();
		log.info("Driver is initialized and navigated to Home page.");
		
		HomePage homePage= new HomePage(driver);
		LoginPage loginPage= new LoginPage(driver);
		
		homePage.LoginButton().click();
		log.info("Successfully clicked on Login Button.");
		
		loginPage.UserName().sendKeys(username);
		log.info("Successfully entered username");
		
		loginPage.Password().sendKeys(password);
		log.info("Successfully entered password");
		
		loginPage.SubmitButton().click();
		log.info("Successfully clicked on Submit button.");
		
		loginPage.ForgotButton().click();
		log.info("Successfully clicked on Forgot Password button.");
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data= new Object[2][2];
		
		data[0][0]= "anu.singhal1992@gmail.com";
		data[0][1]= "Test123";
		
		data[1][0]= "abhishek.singhal@gmail.com";
		data[1][1]= "Test12345";
		
		return data;
	}

}
