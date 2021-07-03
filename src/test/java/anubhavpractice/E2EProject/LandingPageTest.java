package anubhavpractice.E2EProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObject.HomePage;
import resources.baseClass;

public class LandingPageTest extends baseClass {
	
	public static Logger log = LogManager.getLogger(LandingPageTest.class.getName());
	public WebDriver driver;
	
	@Test
	public void basePageNavigation() throws IOException {	
		
		driver= invokeBrowser();
		log.info("Driver is initialized and navigated to Home page.");
		
		HomePage homePage= new HomePage(driver);
		Assert.assertEquals(homePage.CourseHeader().getText(), "FEATURED COURSES123");
		log.info("Course Header content Matched");
		
		Assert.assertTrue(homePage.NavBar().isDisplayed());
		log.info("Presence of Navigation Bar validated.");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
