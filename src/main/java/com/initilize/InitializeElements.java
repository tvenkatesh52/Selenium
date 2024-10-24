package com.initilize;

import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.locators.LandingPage_Locators;
import com.locators.OrangeHrmLocators;


public class InitializeElements extends TestBase {
		public static void initialize_elements()
		{
			PageFactory.initElements(driver, LandingPage_Locators.class);
			PageFactory.initElements(driver, OrangeHrmLocators.class);
			
		}

	}

