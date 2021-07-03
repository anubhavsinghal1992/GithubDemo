package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}
	
	By loginButton= By.cssSelector("a[href*=sign_in]");
	By registerButton= By.cssSelector("a[href*=sign_up]");
	By courseHeader= By.xpath("//section[@id='content']/div/div/h2");
	By navBar= By.cssSelector(".nav.navbar-nav.navbar-right");
	By popUp= By.xpath("//button[text()='NO THANKS'");
	
	
	
	public WebElement LoginButton() {
		return driver.findElement(loginButton);
	}
	
	public WebElement RegisterButton() {
		return driver.findElement(registerButton);
	}
	
	public WebElement CourseHeader() {
		return driver.findElement(courseHeader);
	}
	
	public WebElement NavBar() {
		return driver.findElement(navBar);
	}
	
	public List<WebElement> GetPopUpSize() {
		return driver.findElements(popUp);
	}
	
	public WebElement GetPopUp() {
		return driver.findElement(popUp);
	}
}
