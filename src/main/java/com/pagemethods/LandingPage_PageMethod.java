package com.pagemethods;

import com.locators.LandingPage_Locators;
import com.utilities.GenericMethods;
import com.utilities.WaitMethods;

public class LandingPage_PageMethod {
	
	public static void navigateSignPage() throws InterruptedException {
		WaitMethods.wait_in_seconds(5);
		GenericMethods.clickOnElement(LandingPage_Locators.signinButton, "SignButton");
		WaitMethods.wait_in_seconds(5);
	}

}
