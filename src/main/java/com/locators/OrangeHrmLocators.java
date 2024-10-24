package com.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHrmLocators {
	

	@FindBy (xpath="(//div[contains(@class,'orangehrm-demo-credentials')]/p)[1]")
	public static WebElement UsernameText;
	
	@FindBy (xpath="(//div[contains(@class,'orangehrm-demo-credentials')]/p)[2]")
	public static WebElement PasswordText;
	
	@FindBy (name="username")
	public static WebElement UserNameEditbx;
	
	@FindBy (name="password")
	public static WebElement PasswordEditbx;
	
	@FindBy (xpath="//button[@type='submit']")
	public static WebElement loginButton;
	
	
	
	
	@FindBy (xpath="//span[@class='oxd-userdropdown-tab']")
	public static WebElement profileCart;
	
	@FindBy (xpath="//a[text()='Logout']")
	public static WebElement logout;
	
	@FindBy (xpath="//h5")
	public static WebElement LoginText;
	
	// ===================== Personal Details Locators ============================
	
	@FindBy (xpath="//ul[@class='oxd-main-menu']/li[6]/a/span")
	public static WebElement MyInfoMenu;
	
	@FindBy (name="firstName")
	public static WebElement FistNameEditbx;
	
	@FindBy (name="lastName")
	public static WebElement lastNameEditbx;
	
	@FindBy (xpath="(//label[text()='Employee Id']/following::input[@class='oxd-input oxd-input--active'])[1]")
	public static WebElement EmployeeIdEditbx;
	
	@FindBy (xpath="(//*[@type='submit'])[1]")
	public static WebElement SaveButton;
	
	
	@FindBy (xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[3]")
	public static WebElement bloodGroupDropdown;
	
	
	//======================= Apply Leave Locators==================================
	
	@FindBy (xpath="//ul[@class='oxd-main-menu']//li[3]//span")
	public static WebElement leave;
	
	@FindBy (xpath="(//a[text()='Apply'")
	public static WebElement apply;
	
	@FindBy (xpath="(//div[@class='oxd-select-text--after']")
	public static WebElement leavetypedrpdown;
	
	@FindBy (xpath="(//div[@class='oxd-select-text--after']")
	public static WebElement leavetypedrpown;
	
	//CAN - FMLA
	
	@FindBy (xpath="((//*[@class='oxd-icon bi-calendar oxd-date-input-icon'])[1]")
	public static WebElement fromdatedrpdown;
	
	
	@FindBy (xpath="(//div[@class='oxd-calendar-date --selected --today'")
	public static WebElement selectdate;
	
	@FindBy (xpath="((//*[@class='oxd-icon bi-calendar oxd-date-input-icon'])[2]")
	public static WebElement todatedrpdown;
	
	@FindBy (xpath="(//div[@class='oxd-calendar-date --selected --today']")
	public static WebElement selectdateto;
	
	@FindBy (xpath="(//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	public static WebElement comments;
	
	@FindBy (xpath="(//button[@type='submit']")
	public static WebElement submit;
	
}
