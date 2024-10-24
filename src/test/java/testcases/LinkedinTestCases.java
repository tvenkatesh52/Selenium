package testcases;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.initilize.InitializeElements;
import com.pagemethods.LandingPage_PageMethod;

public class LinkedinTestCases extends TestBase{
	
	@Parameters({"browser","env"})
	@Test
	public static void SignButtonValidation(String browser,String env) throws IOException, InterruptedException {
		initialize_environment(browser,env);
		InitializeElements.initialize_elements(); // Calling Static method using classname.methodname();
		LandingPage_PageMethod.navigateSignPage();
	}

}
