package testcases;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.initilize.InitializeElements;
import com.pagemethods.LandingPage_PageMethod;
import com.pagemethods.OrangeHrmPageMethod;

public class OrangeHrmTestcases extends TestBase{
	
	@Parameters({"browser","env"})
	@Test
	public static void CheckLoginLogout(String browser,String env) throws IOException, InterruptedException {
		initialize_environment(browser,env);
		InitializeElements.initialize_elements(); // Calling Static method using classname.methodname();
		OrangeHrmPageMethod.Login() ;
		OrangeHrmPageMethod.Logout();
	}
	
	@Parameters({"browser","env"})
	@Test
	public static void updatePresonalDetails(String browser,String env) throws IOException, InterruptedException {
		initialize_environment(browser,env);
		InitializeElements.initialize_elements(); // Calling Static method using classname.methodname();
		OrangeHrmPageMethod.Login() ;
		OrangeHrmPageMethod.updatePersonalDetails("Sheet1",1);
	}

}
