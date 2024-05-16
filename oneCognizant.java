package pageObjectModel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class oneCognizant {

	WebDriver driver;
	TakesScreenshot ts;
	public oneCognizant(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements Locators+identification
	@FindBy(id = "oneC_searchAutoComplete")
	WebElement searchBoxElement;
	
	@FindBy(className = "searchTopBar")
	WebElement advanceElement;
	
	@FindBy(id = "oneCSearchTop")
	WebElement advanceSearchElement;

	@FindBy(className = "searchInputIcon")
	WebElement searchButtonElement;

	@FindBy(xpath = "//div/div[contains(@class,'appsResultText')]")
	WebElement gsdElement;

	@FindBy(id = "appFrame")
	WebElement framElement;

	@FindBy(xpath = "//p[@class='Welcome-automated-text']")
	WebElement welcomeElement;

	@FindBy(xpath = "//form[@class='d-flex ms-auto']//span[@class=\"optionCountrySelected\"]")
	WebElement defaultCountryElement;

	@FindBy(xpath = "//form[@class='d-flex ms-auto']//span[@class=\"optionLangSelected\"]")
	WebElement defaultLanElement;

	@FindBy(xpath = "//a[@id=\"menu1\"]")
	WebElement languageBoxElement;

	@FindBy(xpath = "//form//a[@class='dropdown-item p-0'][@data-langid][@role='menuitem']")
	List<WebElement> languagesList;

	@FindBy(xpath = "//a[@id=\"menu2\"]")
	WebElement countryBoxElement;

	@FindBy(xpath = "//form//a[@class='dropdown-item p-0'][@data-countrycode][@role='menuitem']")
	List<WebElement> countriesList;

	@FindBy(xpath="//div[@class='col-md-12 application-tiles']")
	List<WebElement> applicationTileList;
	
	public void screenShot(String name){
		ts=(TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String imgName=name+" "+timeStamp+".png";
		File systemFile=ts.getScreenshotAs(OutputType.FILE);
		File myFile=new File(System.getProperty("user.dir")+ "/ScreenShots/"+ imgName);
		try {
		FileUtils.copyFile(systemFile, myFile);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void search() {
//		searchBoxElement.sendKeys("GSD");
//		searchButtonElement.click();
//		
		if (searchBoxElement.isDisplayed()) {
			searchBoxElement.sendKeys("gsd");
			searchButtonElement.click();
		} else {
			advanceElement.click();
			advanceSearchElement.sendKeys("gsd");
		}
	}

	public void clickOnGSD() throws InterruptedException {
		Thread.sleep(2000);
		gsdElement.click();
	}

	public String welcome_msg() throws InterruptedException {
		driver.switchTo().frame(framElement);
		Thread.sleep(5000);
//		String welcomeString = welcomeElement.getText();
//		String expectedString = "Welcome";
//		System.out.println("\nThe welcome message for the GSD Application is:\n" + welcomeString);
//		Assert.assertTrue(welcomeString.contains(expectedString), "Welcome Message didn't appeared");
		screenShot("GSD page");
		return welcomeElement.getText();
	}

	public String get_default_country() {
		return defaultCountryElement.getText();

	}

	public String get_default_Language() {

		return defaultLanElement.getText();

	}

	public List<WebElement> get_all_language() {
		languageBoxElement.click();
		System.out.println("All languages");
		for (WebElement x : languagesList) {
			System.out.println(x.getText());
		}
		return languagesList;
	}

	public List<WebElement> get_all_country() throws InterruptedException {
		Thread.sleep(10000);
		countryBoxElement.click();
		System.out.println("\nAll Countries");
		for (WebElement x : countriesList) {
			System.out.println(x.getText());
		}
		return countriesList;
	}

	public void USATooltips() {
		for (WebElement x : countriesList) {
			if (x.getText().equals("United States")) {
				x.click();
				System.out.println("\nclicked on United States");
				System.out.println("---------------------------------------------------");
			}
		}
		screenShot("USA");
		for (WebElement y : applicationTileList) {
			System.out.print(y.getText()+"-:");
			System.out.println(y.getAttribute("data-bs-original-title"));
		}	
	}
	
	public void ArgentinaTooltips() {
		countryBoxElement.click();
		for (WebElement x : countriesList) {
			if (x.getText().equals("Argentina")) {
				x.click();
				System.out.println("clicked on Argentina");
				System.out.println("---------------------------------------------------");
			}
		}
		screenShot("Argentina");
		for (WebElement y : applicationTileList) {
			System.out.print(y.getText()+"-:");
			System.out.println(y.getAttribute("data-bs-original-title"));
		}	
	}
	
	public void DenmarkTooltips() {
		countryBoxElement.click();
		for (WebElement x : countriesList) {
			if (x.getText().equals("Denmark")) {
				x.click();
				System.out.println("clicked on Denmark");
				System.out.println("---------------------------------------------------");
			}
		}
		screenShot("Denmark");
		for (WebElement y : applicationTileList) {
			System.out.print(y.getText()+"-:");
			System.out.println(y.getAttribute("data-bs-original-title"));
		}	
	}
	
	public void closing() {
		driver.quit();
	}

}
