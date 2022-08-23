package Orange;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPage extends CommonClass{
	
		public void launchbrowser() throws InterruptedException{			//Launch Browser
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(configFileReader("url1"));
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	public void selectdropdown(String str) throws InterruptedException {		//select drop down

		Select dropval = new Select(driver.findElement(By.id("searchDropdownBox")));
		dropval.selectByIndex(16);
		// dropval.selectByValue("search-alias=mobile-apps");
		//dropval.selectByVisibleText(configFileReader(str)); 
	}
	public void searchitem(String item) throws InterruptedException, IOException{
			
		driver.findElement(By.id("nav-search-bar-form")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(configFileReader(item));
		driver.findElement(By.id("nav-search-submit-text")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Set<String> allwindows = driver.getWindowHandles();
		int count = allwindows.size();
		System.out.println("Total windows:" + count);
		for (String child : allwindows) {
			driver.switchTo().window(child);
			if (!parent.equalsIgnoreCase(child)) {
				System.out.println(child);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//driver.findElement(By.id("wishListMainButton")).click();
				//implicitwait(10);
				driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
				implicitwait(10);
/*				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@name='proceedToRetailCheckout']"))); */
				driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
				implicitwait(10);
				screenshot();
			}
		//	driver.switchTo().window(parent);
		//	System.out.println("Parent window is:"+parent);
		}
	}
}
	
	
		
	/*public void clickradiobutton() {
		
		try {
			Boolean var = driver.findElement(By.xpath(propertyFilePath)).isDisplayed();
			if(var)
			{
				driver.findElement(By.xpath(propertyFilePath)).click();
			}
		}
		catch(Exception e)
		{
			System.out.println("Value is not available");
		}
	} */
	