package Tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.MyDriver;
import pageObjectModel.oneCognizant;

public class OneCognizantTest {
	WebDriver driver;
	oneCognizant oneCognizantObject;
	List<WebElement> languagelist;
	List<WebElement> countryList;

	@Test(priority = 5)
	void gsdSearch() throws InterruptedException {
//	System.out.println("other test");
		oneCognizantObject = new oneCognizant(MyDriver.getDriver());
		oneCognizantObject.search();
		oneCognizantObject.clickOnGSD();
	}

	@Test(priority = 6)
	void welcomeMsgValidation() throws InterruptedException {
		String welcomeString = oneCognizantObject.welcome_msg();
		String expectedString = "Welcome";
		System.out.println("\nThe welcome message for the GSD Application is:\n" + welcomeString);
		Assert.assertTrue(welcomeString.contains(expectedString), "Welcome Message didn't appeared");
		

	}

	@Test(priority = 7)
	void validateDefaultCountry() throws InterruptedException {
		String expectedCountryString = "India";
		String actualCountryString = oneCognizantObject.get_default_country();
		Assert.assertEquals(actualCountryString, expectedCountryString, "Country Did not matched to India");
	}

	@Test(priority = 8)
	void validateDefaultLanguage() throws InterruptedException {
		String expectedLanguageString = "English";
		String actualLanguageString = oneCognizantObject.get_default_Language();
		Assert.assertEquals(actualLanguageString, expectedLanguageString, "Language Did not matched to English");
	}

	@Test(priority = 9)
	void allLanguage() {
		languagelist = oneCognizantObject.get_all_language();
	}

	@Test(priority = 10)
	void allCountry() throws InterruptedException {
		countryList = oneCognizantObject.get_all_country();
	}

	@Test(priority = 11)
	void toolPins() throws InterruptedException {
		oneCognizantObject.USATooltips();
		oneCognizantObject.ArgentinaTooltips();
		oneCognizantObject.DenmarkTooltips();

	}
	
	@Test(priority = 12)
	void tearDown() {
		MyDriver.clearDriver();
		oneCognizantObject.closing();
	}

}
