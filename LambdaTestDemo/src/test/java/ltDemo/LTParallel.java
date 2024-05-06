package ltDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LTParallel {
	
	@Parameters({"browserName","browserVersion","osVersion"})
	@Test
	public void loginTest(String browserName, String browserVersion, String osVersion) throws MalformedURLException {
		
		WebDriver driver = null;
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "phanindrakumar05");
		ltOptions.put("accessKey", "LiOOXXPweILTaG94kQ6qotLtGLFWtEhcosmIazaEVFbkXr0a6A");
		ltOptions.put("build", "SeleniumBuild");
		ltOptions.put("project", "SeleniumBuild");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName(osVersion);
			browserOptions.setBrowserVersion(browserVersion);
			
			browserOptions.setCapability("LT:Options", ltOptions);
			
			driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			
			FirefoxOptions browserOptions = new FirefoxOptions();
			browserOptions.setPlatformName(osVersion);
			browserOptions.setBrowserVersion(browserVersion);
			
			browserOptions.setCapability("LT:Options", ltOptions);
			
			driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		}
		
		else if(browserName.equalsIgnoreCase("Edge")) {
			
			EdgeOptions browserOptions = new EdgeOptions();
			browserOptions.setPlatformName(osVersion);
			browserOptions.setBrowserVersion(browserVersion);
			
			browserOptions.setCapability("LT:Options", ltOptions);
			
			driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		}
		
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		driver.findElement(By.name("email1")).sendKeys("admin@email.com");
		
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div/button")).click();
		
		//Assert.assertTrue(driver.getTitle().contains("Automation"));
		
		driver.quit();
	}

}
