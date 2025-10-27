package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationTestCase.TestngBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageNewsTestCase extends TestngBase {
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminpage;
	ManageNewsPage manageTestcase;

	@Test(description = "The user is try to create news")

	public void verifyTheUserCanAbleToCreateNews() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		RandomDataUtility randomutility = new RandomDataUtility();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue);
		homepage = loginpage.clickLoginButton();
		homepage.clickManageNewsMoreInfo();
		manageTestcase = new ManageNewsPage(driver);
		manageTestcase.verifyandClickonTheManageNewButton();
		String NewsTextfromExcel = ExcelUtility.getStringData(1, 0, "NewUserRegistration");
		manageTestcase.createNews(NewsTextfromExcel);
		// String expectedNews= manageTestcase.successAlertAssertion();
		// Assert.assertEquals(NewsTextfromExcel, expectedNews, "The searched news is
		// not found");
		boolean alertSuccess = manageTestcase.successAlertAssertion();
		Assert.assertTrue(alertSuccess);

	}

	@Test(description = "The user is try to search existing news")

	public void verifyTheUserCanAbleToSearchNews() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		RandomDataUtility randomutility = new RandomDataUtility();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(PasswordValue);
		homepage = loginpage.clickLoginButton();
		homepage.clickManageNewsMoreInfo();
		manageTestcase = new ManageNewsPage(driver);
		manageTestcase.verifyandManageSearchNews();
		String NewsTextfromExcel = ExcelUtility.getStringData(1, 0, "NewUserRegistration");
		manageTestcase.enterTheNewsYouAreSearching(NewsTextfromExcel);
		String expectedNews = manageTestcase.GetSearchedNewsSuccessAlert();
		Assert.assertEquals(NewsTextfromExcel, expectedNews, "The searched news is not found");

	}

}
