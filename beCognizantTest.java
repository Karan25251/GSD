package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjectModel.MyDriver;
import pageObjectModel.beCognizant;

public class beCognizantTest {
	WebDriver driver;
	WebDriverWait wait;
	beCognizant beCognizantObject;
	
	@Test(priority = 1)
	@Parameters({"browser"})
	void setup(String browser) {
		
		driver=MyDriver.getDriver(browser);
		beCognizantObject=new beCognizant(driver);
		
		
	}
	
	@Test(priority = 2)
	void userInformation() throws InterruptedException {
		beCognizantObject.diplayProfile();

		beCognizantObject.getUserName();
		beCognizantObject.getUserEmailID();
	}
	
	@Test(priority = 3)
	void navigatingToOneCognizant() {
			beCognizantObject.navigatingToOneCognizant();
	}
	
	@Test(priority = 4)
	void windowHandle() {

		beCognizantObject.newWindow();
		MyDriver.updateDriver(beCognizantObject.switchWindow());
	}
}
