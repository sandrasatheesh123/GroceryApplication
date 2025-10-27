package testscript;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationTestCase.TestngBase;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTestCase extends TestngBase {

	HomePage homepage;
	AdminUsersPage adminpage;

	@Test(description = "Verify the user can able to create news userss")

	public void verifyTheUserCanABleToCreateNewAdminUsers() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue);
		homepage = loginpage.clickLoginButton();
		homepage.clickToNavigateToAdminUsersPage();

		// homepage.verifytheTotalNumberOfAdminUsers();
//The user try to create new admin

		adminpage = new AdminUsersPage(driver); // Add this line
		adminpage.clickOnTheNewButtonTocreateNewAdmin();

		RandomDataUtility randomutility = new RandomDataUtility();
		String newUserNameValue = randomutility.randomUserName();
		String newUserPasswordValue = randomutility.randomPassword();
		adminpage.enterNewUsername(newUserNameValue).enterNewUserPassword(newUserPasswordValue)
				.selectUserTypeFromTheDropDown().saveThenewuserData();
//checking the alert success message
		boolean alertSuccess = adminpage.isAlertDisplayed();
		Assert.assertTrue(alertSuccess, Constant.adminCreationAssert);
		// closing the alert window
		adminpage.clickOnTheAlertCloseButton();
	}

	@Test(description = "Verify the user can able to search the existing user")

	public void verifyTheUserCanAbletoSearchTheExistingAdminUser() throws IOException

	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		RandomDataUtility randomutility = new RandomDataUtility();
		String newUserNameValue = randomutility.randomUserName();
		String newUserPasswordValue = randomutility.randomPassword();
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue);
		homepage = loginpage.clickLoginButton();
		homepage.clickToNavigateToAdminUsersPage();
		// Navigating to the searching page
		adminpage = new AdminUsersPage(driver);
		adminpage.clickOnTheSearchButton();
		String existinguser = adminpage.getTheUserNameExist();
		adminpage.searchUserNameExist(existinguser);
		String existinguserType = adminpage.getTheUserType();
		adminpage.searchTheUserTypeExist(existinguserType).clickButtonToSearchTheExistingAdminUser();
		String actualsearchedname = adminpage.searchedUserNameResult();

		String expected = existinguser;
		String actual = actualsearchedname;
		Assert.assertEquals(actual, expected, Constant.userCanAbletoSearchTheExistingAdminUser);
		adminpage.deleteTheSearchedUser();
		// Switch to alert
		Alert alert = driver.switchTo().alert();
		// Click OK
		alert.accept();
	}

	@Test(description = "User is resetting")

	public void verifyTheAdminClickOnTheResetButton() throws IOException {

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		RandomDataUtility randomutility = new RandomDataUtility();
		String newUserNameValue = randomutility.randomUserName();
		String newUserPasswordValue = randomutility.randomPassword();
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue);
		homepage = loginpage.clickLoginButton();
		homepage.clickToNavigateToAdminUsersPage();
		adminpage = new AdminUsersPage(driver);
		adminpage.clickOnTheNewButtonTocreateNewAdmin().clickOnTheSearchButton().clickOnTheResetButton();

		String expectedNewpageText = adminpage.assertionOfResetPageusingNewpage();
		String actual = "Admin Users Informations";
		String expected = expectedNewpageText;
		Assert.assertNotEquals(actual, expected, "The user is not navigate to the reset page");

		String expectedSearchpageText = adminpage.assertionOfResetPageusingSearchpage();
		String actual1 = "Search Admin Users";
		String expected1 = expectedSearchpageText;
		Assert.assertNotEquals(actual1, expected1, "The user is not navigate to the reset page");

	}
}
