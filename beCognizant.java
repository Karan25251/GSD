package pageObjectModel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//POM
public class beCognizant {
	WebDriver driver;
	WebDriverWait wait;
	TakesScreenshot ts;
	public beCognizant(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// WebElements Locators+identification
	
	@FindBy(className ="_8ZYZKvxC8bvw1xgQGSkvvA==")
	WebElement idElement;
	
	@FindBy(id="mectrl_currentAccount_primary")
	WebElement nameElement;
	
	@FindBy(id="mectrl_currentAccount_secondary")
	WebElement passwordElement;
	
	@FindBy(xpath="//div[@title=\"OneCognizant\"]")
	WebElement onecognizaElement;
	
	
	//Methods
	
	public void screenShot(String name){
		ts=(TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String imgName=name+timeStamp+".png";
		File systemFile=ts.getScreenshotAs(OutputType.FILE);
		File myFile=new File(System.getProperty("user.dir")+ "/ScreenShots/"+ imgName);
		try {
		FileUtils.copyFile(systemFile, myFile);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void diplayProfile() throws InterruptedException {
		Thread.sleep(10000);
		idElement.click();
		Thread.sleep(10000);
		screenShot("profile");
	}
	
	public void getUserName()
	{	
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(nameElement));
		System.out.println("User Name");
		System.out.println(nameElement.getText());
	}
	
	public void getUserEmailID()
	{
		System.out.println("User Email-:");
		System.out.println(passwordElement.getText());
	}
	
	public void navigatingToOneCognizant(){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", onecognizaElement);
		try {
			Thread.sleep(5000);
			screenShot("OneCognizant click");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void newWindow() {
		String parentTabString = driver.getWindowHandle();
		List<String> alltabList = new ArrayList<String>(driver.getWindowHandles());
		alltabList.remove(parentTabString);
		driver.switchTo().window(alltabList.get(0));
	}
	
	public WebDriver switchWindow() {
		return driver;
	}
	
	

	
	
	

}
