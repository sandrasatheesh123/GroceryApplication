package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationTestCase.TestngBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTestCase extends TestngBase {
	// LoginPage loginpage;
	HomePage homepage;

	@Test(priority = 1, description = "The user is trying to loging with valid credentials", groups = { "smoke" })
	public void validateUserloginWithValidCredentials() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue);
		homepage = loginpage.clickLoginButton();
		boolean admin = loginpage.adminusers();
		Assert.assertTrue(admin, Constant.validCredentialError);
	}

	@Test(priority = 2, description = "The user is try to login with valid username and invalid password", retryAnalyzer = retry.Retry.class)
	public void valideUserLoginWithValidUsernameInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue).clickLoginButton();
		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected, Constant.loginWithValidUsernameInvalidPassword);
	}

	@Test(priority = 3, description = "The user is try to login with invalid username and valid password")
	public void validateUserLoginWithInvalidUsernameValidPAssword() throws IOException {
		String userNameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue).clickLoginButton();
		boolean alertInvalidCredentials = loginpage.invalidcredentials();
		Assert.assertTrue(alertInvalidCredentials, Constant.loginWithInvalidUsernameValidPAssword);
	}

	@Test(priority = 4, description = "The user is try to login with invalid username and password credentials", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void validateUserLoginWithInvalidUsernameinValidPAssword(String userNameValue1, String PasswordValue1)
			throws IOException {
		// String userNameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		// String PasswordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue1).enterPassword(PasswordValue1).clickLoginButton();
		boolean alertInvalidCredentials = loginpage.invalidcredentials();
		Assert.assertTrue(alertInvalidCredentials, Constant.loginWithInvalidUsernameinValidPAssword);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
// new Object[] {ExcelUtility.getStringData(3,
// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
