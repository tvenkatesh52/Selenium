package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;



public class TestBase {
	public static WebDriver driver;
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	
	/*
	 *  Select Browser 
	 */
	public static void select_browser(String browser) throws MalformedURLException {
		
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-incognito");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("disable-blink-features=AutomationControlled");
			//options.addArguments("--headless");
            //options.setCapability("screen-resolution","1080x720");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			log.info("Chrome initialized successfully");
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			log.info("Firefox initialized successfully");
		}
		else if (browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			log.info("Internet Explorer initialized successfully");
		}
		else if (browser.equalsIgnoreCase("edge")) {
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put( "profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );
			//prefs.put("download.default_directory", System.getProperty("user.dir"+"//drivers//Download_Pdf"));
			prefs.put("download.prompt_for_download", false);
			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("InPrivate");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("disable-blink-features=AutomationControlled");
			options.addArguments("--window-size=1920,1080");
			driver = new EdgeDriver(options);
			driver.manage().window().maximize();
			log.info("Edge Browser initialized successfully");

		}
	}
	
	/*
	 *  Get Environment
	 */
	public static void get_environment(String env) throws IOException {
		 driver.get(get_Property_Value(env));
		 log.info("Application Launched successfully");
	}
	
	/*
	 *  Select Browser and initialize environment
	 */
	public static void initialize_environment(String browser,String env) throws IOException {
		select_browser(browser);
		get_environment(env);
	}
	/*
	 *  Read Data from properties File
	 */
	public static String get_Property_Value(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\config\\config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	@AfterMethod
	public void teardown() {
		try {
			if (driver != null) {
				driver.quit();
				log.info("Browser quit successfully");
			}
		} catch (Exception e) {
			log.error("Exception occurred during teardown: " + e.getMessage());
		}
	}

}
