package stepDefinations;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.LoginPage;
import resources.baseClass;

public class stepDefination extends baseClass {
	
	public static Logger log = LogManager.getLogger(stepDefination.class.getName());
	
	@Given("^Intitiate Chrome Browser$")
    public void intitiate_chrome_browser() throws IOException {
		driver= invokeBrowser();
		log.info("Driver is initialized and navigated to Home page.");
    }
    
    @When("^user clicks on login button and provide credentials as (.+) and (.+)$")
    public void user_clicks_on_login_button_and_provide_credentials_as_and(String validusername, String validpassword) {
    	
    	HomePage homePage= new HomePage(driver);
		LoginPage loginPage= new LoginPage(driver);
    	
    	homePage.LoginButton().click();
		log.info("Successfully clicked on Login Button.");
		
		loginPage.UserName().sendKeys(validusername);
		log.info("Successfully entered username");
		
		loginPage.Password().sendKeys(validpassword);
		log.info("Successfully entered password");
		
		loginPage.SubmitButton().click();
		log.info("Successfully clicked on Submit button.");
    }

    @Then("^Post Login page is displayed$")
    public void post_login_page_is_displayed() {
    	log.info("User successfully logged-in.");
    }

    @Then("^Error is shown for wrong credentials$")
    public void error_is_shown_for_wrong_credentials() {
    	log.info("User gets error message for wrong credentials.");
    }
    
    @And("^Close the browser$")
    public void close_the_browser() {
    	driver.quit();
    }
	
}
