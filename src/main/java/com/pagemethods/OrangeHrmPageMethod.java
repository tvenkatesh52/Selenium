package com.pagemethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.locators.OrangeHrmLocators;
import com.utilities.ExcelReader;
import com.utilities.WaitMethods;
import static com.utilities.GenericMethods.*;

import java.io.IOException;
public class OrangeHrmPageMethod {
	
	public static void Login() throws InterruptedException {
		WaitMethods.wait_for_element_present(OrangeHrmLocators.UsernameText);
		enter_text(OrangeHrmLocators.UserNameEditbx, getUsername(), "User Name Edit box");
		enter_text(OrangeHrmLocators.PasswordEditbx, getPassword(), "Passowrd Edit box");
		clickOnElement_Using_JS(OrangeHrmLocators.loginButton,"loginButton");
		WaitMethods.wait_in_seconds(5);
	
	}
	
	public static void Logout() throws InterruptedException {
		WaitMethods.wait_for_element_present(OrangeHrmLocators.profileCart);
		clickOnElement_Using_JS(OrangeHrmLocators.profileCart,"profileCart");
		clickOnElement_Using_JS(OrangeHrmLocators.logout,"logout");
		WaitMethods.wait_in_seconds(5);
		assertWebElement(OrangeHrmLocators.LoginText);
		WaitMethods.wait_in_seconds(5);
	}
	
	public static void updatePersonalDetails(String sheetname,int row) throws InterruptedException, IOException {
		
		WaitMethods.wait_for_element_present(OrangeHrmLocators.MyInfoMenu);
		clickOnElement_Using_JS(OrangeHrmLocators.MyInfoMenu,"MyInfoMenu");
		enter_text(OrangeHrmLocators.FistNameEditbx,"Thatha", "FistNameEditbx");
		enter_text(OrangeHrmLocators.lastNameEditbx,"Venkatesh", "lastNameEditbx");
		enter_text(OrangeHrmLocators.EmployeeIdEditbx, "VIJ2120", "EmployeeIdEditbx");
		clickOnElement_Using_JS(OrangeHrmLocators.SaveButton,"SaveButton");
		WaitMethods.wait_in_seconds(10);
	}
	
	
	public static void leaveApply() throws InterruptedException  {
		WaitMethods.wait_for_element_present(OrangeHrmLocators.leave);
		clickOnElement_Using_JS(OrangeHrmLocators.leave,"leave");
		WaitMethods.wait_in_seconds(5);
	}
	
	
	
	
	
	
	// Extracting Username and Password
	public static String getUsername(){ 
		String[] text= OrangeHrmLocators.UsernameText.getText().split(" ");
		return text[2];
	}
	public static String getPassword(){ 
		String[] text= OrangeHrmLocators.PasswordText.getText().split(" ");
		return text[2];
	}
	
	public static void clickonDrpOption(String opt) {
		driver.findElement(By.xpath("//div[text()='"+opt+"']")).click();
	}

}
