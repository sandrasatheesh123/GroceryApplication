package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationTestCase.TestngBase;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class HomeTestCase extends TestngBase {
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminpage;

	@Test(description = "Verify the uer is successfully navigate to the admin users page")

	public void validatetheUSerIsSuccessfullyNaviagtetoAdminUSersPAge() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		RandomDataUtility randomutility = new RandomDataUtility();
		String newUserNameValue = randomutility.randomUserName();
		String newUserPasswordValue = randomutility.randomPassword();
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue).clickLoginButton();
		homepage.verifytheTotalNumberOfAdminUsers().clickToNavigateToAdminUsersPage();
		String ValidatePageTitleofAdminPage = homepage.adminpageAssetionValidation();
		String expected = "Admin Users";
		String actual = ValidatePageTitleofAdminPage;
		Assert.assertEquals(actual, expected, Constant.userIsSuccessfullyNaviagtetoAdminUSersPAge);

	}

	@Test(description = "Verify the user is successfully navigate to the manage news page")

	public void validatetheUserIsSuccessfullyNavigatetoManageNewsPage() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		RandomDataUtility randomutility = new RandomDataUtility();
		String newUserNameValue = randomutility.randomUserName();
		String newUserPasswordValue = randomutility.randomPassword();
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue).clickLoginButton();
		homepage.clickManageNewsMoreInfo();
		String pageTitleManagenews = homepage.verifyManageNewsPageTitleAssetion();
		String expected = "Manage News";
		String actual = pageTitleManagenews;
		Assert.assertEquals(actual, expected, Constant.userIsSuccessfullyNavigatetoManageNewsPage);

	}

	@Test(description = "Verify the user is successfully logout from the application")
	public void validateUserSuccessfullyLogout() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		RandomDataUtility randomutility = new RandomDataUtility();
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		String newUserNameValue = randomutility.randomUserName();
		String newUserPasswordValue = randomutility.randomPassword();
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue).clickLoginButton();
		homepage.clickAdminDropDown().clickLogoutButtonFromAdminDropDown();
		String assertLogout = homepage.verifyLogoutAssetion();
		String expected = "Sign in to start your session";
		String actual = assertLogout;
		Assert.assertEquals(actual, expected, Constant.userSuccessfullyLogout);
	}

}
