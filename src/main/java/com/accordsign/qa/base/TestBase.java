package com.accordsign.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.accordsign.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")  + "/src/main/java/com/accordsign/qa/config/config.properties");
			//System.out.println("Loading config file from: " + ip);
			prop.load(ip);

			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		
		  //Proxy proxy = new Proxy();
	        //proxy.setHttpProxy("103.174.150.190:8080");
	       // proxy.setSslProxy("103.174.150.190:8080");
		
		ChromeOptions options = new ChromeOptions();
		//options.setProxy(proxy);
		
		// Disable Chrome password manager
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);

	    // Create a new fresh Chrome profile (important)
	    
//	    options.addArguments("--headless=new"); // or "--headless"
//	    options.addArguments("--no-sandbox");
//	    options.addArguments("--disable-dev-shm-usage");
	    
	    
	    options.addArguments("start-maximized");
	    options.addArguments("disable-infobars");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-save-password-bubble"); // disable password save bubble
	    options.addArguments("--no-default-browser-check");
	    options.addArguments("disable-extensions");
	    options.addArguments("--disable-popup-blocking");

	    // Optional: Use incognito mode (fresh every time)
	    options.addArguments("--incognito");
		
		if (browserName.equalsIgnoreCase("chrome")) {

			
	        driver = new ChromeDriver(options);
	        
	        
	        
		} else if (browserName.equals("ff")) {

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT);

		driver.get(prop.getProperty("url"));

	}

}
