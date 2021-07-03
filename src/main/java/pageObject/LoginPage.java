package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	By username= By.id("user_email");
	By password= By.id("user_password");
	By submit= By.name("commit");
	By forgotButton= By.linkText("Forgot Password?");
	
	
	public WebElement UserName() {
		return driver.findElement(username);
	}
	
	public WebElement Password() {
		return driver.findElement(password);
	}
	
	public WebElement SubmitButton() {
		return driver.findElement(submit);
	}
	
	public WebElement ForgotButton() {
		return driver.findElement(forgotButton);
	}
	
}
