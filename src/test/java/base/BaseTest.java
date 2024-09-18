package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.driver.Driver;
import com.enums.ConfigProperties;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.PropertiesReader;

public class BaseTest {

	protected BaseTest() {}
	
	protected WebDriver driver;	
	protected LoginPage loginPage;
	protected HomePage homePage;
	
	
	@BeforeMethod
	public void setup() {
		driver = Driver.initDriver(PropertiesReader.get(ConfigProperties.BROWSER));
		loginPage = new LoginPage(driver);
	}
	
	@AfterMethod
	public void teardown() {
		
	}
}
