package com.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.TestBase;

public class GenericMethods extends TestBase {

	public static final Logger log = Logger.getLogger(GenericMethods.class.getName());
	public static DateFormat dateFormat;

	//======================================================New Methods for Report======================================
	public static void clickOnElement(WebElement ele,String ElementName) {
		WaitMethods.wait_for_element_to_be_clickable(ele);
		highLightElement(driver,ele);
		ele.click();
		log.info("Clicked on the element " + ElementName);
	}

	public static void clickOnElement_Using_JS(WebElement ele,String ElementName) {
		WaitMethods.wait_for_element_present(ele);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", ele);
		log.info("Clicked on the element " + ElementName);
	}
	/*
	 * Purpose: This method is used to highlight an element using the Java Script
	 * Executor
	 *
	 * @param Webdriver, WebElement
	 *
	 * @return NA
	 */
	public static void highlight_element(WebDriver driver, WebElement element) throws InterruptedException {
		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute javascript
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(3000);
		js.executeScript("arguments[0].style.border=''", element);
	}

	public static void highLightElement(WebDriver driver, WebElement element){
		try {
			JavascriptExecutor Jdriver = (JavascriptExecutor) driver;
			Jdriver.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "border: 2px solid yellow;");
		}catch (Exception e){}
	}

	/*
	 * Purpose: This Java Script Executor Method is used to Scroll down a page
	 *
	 * @param NA
	 *
	 * @return NA
	 */
	public static void scroll_down() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	/*
	 * Purpose: This Java Script Executor Method is used to Scroll down to a
	 * particular WebElement
	 *
	 * @param WebElement
	 *
	 * @return NA
	 */
	public static void scroll_down_to_element(WebElement ele) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	/*
	 * Purpose: This Java Script Executor Method is used display an alert on the web
	 * page
	 *
	 * @param String (alert message)
	 *
	 * @return NA
	 */
	public static void display_slert_Using_JS(String alert_msg) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert(alert_msg);");
	}

	/*
	 * Purpose: This Java Script Executor Method is used to find number of frames in
	 * a web page
	 *
	 * @param String NA
	 *
	 * @return int
	 */
	public static int no_of_frames_using_js() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int frame_size = (int) js.executeScript("document.frames.length;");
		return frame_size;
	}

	public static void click_from_webElementList(List<WebElement> ele, String text) throws InterruptedException {
		WaitMethods.wait_in_seconds(5);
		for (WebElement choice : ele) {
			if (choice.getText().trim().equals(text)) {
				highLightElement(driver,choice);
				choice.click();
				break;
			}
		}
	}
	
	/*
	 * Purpose: This method is used to accept an alert in a webpage
	 *
	 * @param NA
	 *
	 * @return NA
	 */
	public static void accept_alert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if (isAlertPresent() == true) {
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			}
		} else {
			System.out.println("No alert present");
		}

	}

	/*
	 * Purpose: This method is used to check if alert exists
	 *
	 * @param NA
	 *
	 * @return boolean value(true or false)
	 */
	public static boolean isAlertPresent() {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20) /* timeout in seconds */);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	/*
	 * Purpose: This method is used to cancel an alert in a webpage
	 *
	 * @param NA
	 *
	 * @return NA
	 */
	public static void cancel_alert() {
		/*
		 * try { WebDriverWait wait=new WebDriverWait(driver,10);
		 * wait.until(ExpectedConditions.alertIsPresent()); Alert
		 * alt=driver.switchTo().alert(); alt.dismiss(); } catch
		 * (NoAlertPresentException e) { System.out.println("No Alert Present"); }
		 */

		if (isAlertPresent() == true) {
			Alert alt = driver.switchTo().alert();
			alt.dismiss();
		} else {
			System.out.println("No alert present");
		}

	}

	/*
	 * Purpose: This method is used to get the text from a alert in a WebPage
	 *
	 * @param NA
	 *
	 * @return String
	 */
	public static String get_alert_text() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		return text;
	}

	/*
	 * Purpose: This method is used to switching to a frame using frame id
	 *
	 * @param String (id)
	 *
	 * @return NA
	 */
	public static void swith_to_frame_using_id(String id) {
		driver.switchTo().frame(id);
	}

	/*
	 * Purpose: This method is used to switching to a frame using frame name
	 *
	 * @param String (name)
	 *
	 * @return NA
	 */
	public static void swith_to_frame_using_name(String name) {
		driver.switchTo().frame(name);
	}

	/*
	 * Purpose: This method is used to switching to a frame using frame index
	 *
	 * @param String (index)
	 *
	 * @return NA
	 */
	public static void swith_to_frame_using_index(int index) {
		driver.switchTo().frame(index);
	}

	/*
	 * Purpose: This method is used to switching to a default content from a frame
	 *
	 * @param NA
	 *
	 * @return NA
	 */
	public static void swith_to_default_content() {
		driver.switchTo().defaultContent();
	}

	/*
	 *
	 */


	/*
	 * Purpose: This method is used to navigate to a different url
	 *
	 * @param NA
	 *
	 * @return NA
	 */
	public static void navigate_to_url(String url) {
		WaitMethods.wait_for_page_load(10);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("window.focus();");
	}

	/*
	 * Purpose: This method is used to navigate a browser to forward, backward,
	 * refreshing
	 *
	 * @param String (direction)
	 *
	 * @return NA
	 */
	public static void navigate_browser(String direction) {
		if (direction.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}
		if (direction.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}
		if (direction.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}
	}

	/*
	 * Purpose: This method is used for navigating to all windows
	 *
	 * @param NA
	 *
	 * @return NA
	 */
	public static Iterator<String> getAllWindows() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		return itr;
	}

	/*
	 * Purpose: This method is used to select a value from dropdown
	 *
	 * @param WebElement
	 *
	 * @return NA
	 */
	public static void select_from_dropdown(WebElement ele, String type, String textorint) throws InterruptedException {
		WaitMethods.wait_for_element_present(ele);
		Select dropdown = new Select(ele);

		List<WebElement> options =  dropdown.getOptions();
		if (type.equalsIgnoreCase("visibletext")) {
//			
			dropdown.selectByVisibleText(textorint);
		} else if (type.equalsIgnoreCase("value")) {
			dropdown.selectByValue(textorint);
		} else if (type.equalsIgnoreCase("index")) {
			dropdown.selectByIndex(Integer.parseInt(textorint));
			}
	}

	public static String capture_Page_Screenshot(String fileName,String path) {
		if (Objects.equals(fileName, "")) {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+path;
			destFile = new File(
					reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	public static void assertEquals_with_message(String actual, String expected,String message) {
		try {
			Assert.assertEquals(actual, expected, message);
				} catch (AssertionError | NoSuchElementException e) {
			e.printStackTrace(); 
			log.info(e.getMessage());
				}

	}
	/*
	 * Purpose: This method is used to enter the text in a WebElement
	 *
	 * @param WebElement, String (text), String(element name)
	 *
	 * @return String
	 */
	public static void enter_text(WebElement element, String text, String fieldName) throws InterruptedException {
		WaitMethods.wait_for_element_present(element);
		clear(element);
		element.sendKeys(text);
		log.info(text + " entered in the " + fieldName + " field.");
	}
	
	/*
	 *  Assert Webelement is displayed or not
	 */
	public static void assertWebElement(WebElement el) {
		try {
		Assert.assertEquals(el.isDisplayed(),true);
		}catch(Exception e) {
			System.out.println("Element is not Displayed on UI");
			e.printStackTrace();
		};
	}
	
	public static void clear(WebElement el) {
		String text=el.getAttribute("value");
		while(!text.isEmpty()) {
			el.sendKeys(Keys.BACK_SPACE);
			text=el.getAttribute("value");
		}
	}
}

