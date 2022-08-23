package Orange;
import java.io.IOException;

import org.testng.annotations.Test;

public class OpenBrowser extends FindPage{
	@Test (enabled = true)
	public void LaunchBrowser() throws InterruptedException, IOException{
		launchbrowser();
		login("emailID", "PSW");
		selectdropdown("str");
		searchitem("item");  
	}
	
	@Test (enabled = false)
	public void orangehrmlogin() throws InterruptedException, IOException {
		launchbrowser();
		orangehrmlogin("username", "password");
	//	clickradiobutton();
	}

}