package com.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage_Locators {
	
	@FindBy (xpath="(//a[contains(text(),'Sign in')])[1]")
	public static WebElement signinButton; 

}
