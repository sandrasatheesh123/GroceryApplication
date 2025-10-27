package automationTestCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pages.HomePage;
import testscript.LoginTestCase;
import utilities.ScreenshotUtility;

public class TestngBase {
	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browsers")
	public void initializeBrowser() {
//driver= new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();// maximize window size.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//LoginTestCase.verifytheUserSuccessfullyLogoutFromtheApplication();
	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
//driver.quit();

	}
}