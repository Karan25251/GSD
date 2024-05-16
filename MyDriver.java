package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyDriver {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriver getDriver(String driver1) {

		if (driver1.equalsIgnoreCase("chrome")) {
			if (driver == null) {
				driver = new ChromeDriver(); // or any other driver
				driver.manage().window().maximize();
				driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
		}

		if (driver1.equalsIgnoreCase("edge")) {
			if (driver == null) {
				driver = new EdgeDriver(); // or any other driver
				driver.manage().window().maximize();
				driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
		}
		return driver;
	}

	public static void updateDriver(WebDriver newdriver) {
		driver = newdriver;
	}
	
	public static void clearDriver() {
		driver=null;
	}

}
