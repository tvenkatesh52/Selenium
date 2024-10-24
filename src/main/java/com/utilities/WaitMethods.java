package com.utilities;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.base.TestBase;


public class WaitMethods extends TestBase {
	
	public static final Logger log=Logger.getLogger(WaitMethods.class.getName());
	
	/*
	 * Purpose: This method is used to wait implicitly for loading a page
	 * @param time in integers
	 * @return NA
	 */
	
	public static void wait_for_page_load(int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	
	/*
	 * Purpose: This method is used to wait Explicitly for an element to present in a Webpage
	 * @param WebElement
	 * @return NA
	 */
	public static void wait_for_element_present(WebElement wb)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	
	/*
	 * Purpose: This method is used to wait Explicitly for the list to web elements in a Webpage
	 * @param WebElement
	 * @return NA
	 */
	public static void wait_for_elements_present(List <WebElement> wb)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(wb));     
	}
	
	/*
	 * Purpose: This method is used to wait Explicitly for the web element to be clickable
	 * @param WebElement
	 * @return NA
	 */
	public static void wait_for_element_to_be_clickable(WebElement wb)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(wb));
	}

	/*
	 * Purpose: This method is used to wait Explicitly until the existence of particular URl
	 * @param String (url)
	 * @return NA
	 */
	public static void wait_until_url_contains(String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(url));
	}

	/*
	 * Purpose: This method is used to wait Explicitly until a particular text present in a WebElement
	 * @param WebElement (element), String
	 * @return NA
	 */
	public static void wait_until_text_present(WebElement wb,String text)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(wb, text));
	}
	
	/*
	 * Purpose: This method is used to wait Explicitly until an alert present in the WebPage
	 * @param WebElement (element), String
	 * @return NA
	 */
	public static void wait_until_alert_present()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/*
	 * Purpose: This method is used to wait Explicitly until the invisibility of a WebElement
	 * @param WebElement (element)
	 * @return NA
	 */
	public static void wait_until_visibility_of_element(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/*
	 * Purpose: This method is used to wait Explicitly until the WebElement is selected
	 * @param WebElement (element)
	 * @return NA
	 */
	public static void wait_until_element_selected(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	/*
	 * Purpose: This method is used to wait Explicitly until the title contains particular string
	 * @param String
	 * @return NA
	 */
	public static void wait_until_aler_present(String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}

	/*
	 * Purpose: This method is used to wait fluently until the presence of a particular WebElement
	 * @param WebElement (element)
	 * @return NA
	 */
	
	public static void fluent_wait(WebElement ele)
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	/*
	 * Purpose: This is a normal wait method
	 * @param time(seconds) in integers
	 * @return NA
	 */
	public static void wait_in_seconds(int i) throws InterruptedException
	{
		Thread.sleep(1000*i);
	}


}
