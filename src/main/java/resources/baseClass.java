package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {
	
	public WebDriver driver;
	
	public WebDriver invokeBrowser() throws IOException {
		
		Properties props = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		props.load(fis);
		
		String browserName= props.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Browser Driver/chromedriver");
			driver= new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Browser Driver/geckodriver");
			driver= new FirefoxDriver();
			
		} else {
			
			System.out.println("Please provide browser name in properties file as chrome or firefox only. No other browser is supported");
		
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(props.getProperty("url"));
		
		return driver;
	
	}
	
	
	public void getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File sourceSS= ts.getScreenshotAs(OutputType.FILE);
		String destinationSS= System.getProperty("user.dir") + "/Screenshots/" + testCaseName + ".png";
		FileUtils.copyFile(sourceSS, new File(destinationSS));
		
	}
	

}
