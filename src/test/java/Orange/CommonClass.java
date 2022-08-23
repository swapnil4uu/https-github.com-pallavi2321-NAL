package Orange;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonClass{
	public static WebDriver driver;
	
	public void implicitwait(int val) {  										//implicit wait
	driver.manage().timeouts().implicitlyWait(val, TimeUnit.SECONDS);
	}

	/*	public void explicitwait(int sec) {											//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@name='proceedToRetailCheckout']"))); */
	
	public void screenshot() throws IOException{  								//Screen Shot 
		String FilewithPath = "C:\\Users\\Admin\\eclipse-workspace\\Amazon\\Images\\img";
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File(FilewithPath + FileName));
	}
	public void login(String emailID, String PSW) throws InterruptedException {  //Log in Amazon	
		driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(configFileReader(emailID));
		implicitwait(10);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		implicitwait(10);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(configFileReader(PSW));
		implicitwait(10);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		implicitwait(10);
	}
	
	public void orangehrmlogin(String username, String password) throws InterruptedException {  //Log in Orange HRM	
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(configFileReader(username));
		implicitwait(10);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(configFileReader(password));
		implicitwait(10);
		driver.findElement(By.xpath("//input[@name=\"Submit\"]")).click();
		implicitwait(10);
	}

	public static Properties properties;				
	public static String propertyFilePath= "configuration//Configuration.properties";

	public static String configFileReader(String configpropname){
		String value = null;     
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);      				// to load the whole configuration file
				value = properties.getProperty(configpropname);  //value 
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		return value;		
	}
	
	
}