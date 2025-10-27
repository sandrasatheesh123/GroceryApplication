package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class=\"col-sm-12\"]//a[@class=\"btn btn-rounded btn-danger\"]")
	WebElement newAdmin;

	@FindBy(xpath = "//h1")
	WebElement pageTitle;
	@FindBy(xpath = "//input[@id='username']")
	WebElement newUserName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement newPassword;
	@FindBy(xpath = "//select[@id='user_type']//option[text()='Admin']")
	WebElement userType;
//@FindBy(xpath="//select[@id='user_type']//option") WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement SavethenewUser;
	@FindBy(xpath = "//div[@class='card-footer center']//a")
	WebElement ResetNewUserDetails;
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
	WebElement alert;
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	WebElement alertExistuser;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//button[@class='close']")
	WebElement alertCloseButton;
	@FindBy(xpath = "//div[@class='col-sm-12']//a[2]")
	WebElement clickSearchButton;
	@FindBy(xpath = "//div[@class='col-sm-6 form-group']//input[@type='text']")
	WebElement serachUsernameExist;
	@FindBy(xpath = "//div[@class='col-sm-6 form-group']//select")
	WebElement chooseUserTypeselected;
	@FindBy(xpath = "//div[@class='card-body']//button[@class='btn btn-block-sm btn-danger']")
	WebElement clickToSearchTheexistingAdminuser;
	@FindBy(xpath = "//td//i[@class='fas fa-trash-alt']")
	WebElement deletingTheExistingUser;
	@FindBy(xpath = "//div[@class='col-sm-12']//a[@class='btn btn-rounded btn-warning']")
	WebElement Reset;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	WebElement getregisteredUsername;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]")
	WebElement getNewlyRegisteredUserType;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td")
	WebElement searchResultUserName;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]")
	WebElement searchResultUserType;
	@FindBy(xpath = "//div[@class=\"card-header\"]//h3[text()=\"Admin Users Informations\"]")
	WebElement adminpageNewAssertText;
	@FindBy(xpath = "//div[@class=\"card-header\"]//h4[text()=\"Search Admin Users\"]")
	WebElement adminpageSearchAssertText;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteSearchedUser;

	public AdminUsersPage clickOnTheNewButtonTocreateNewAdmin() {
		newAdmin.click();
		return this;
	}

	public AdminUsersPage enterNewUsername(String newUserNameValue) {
		newUserName.sendKeys(newUserNameValue);
		return this;
	}

	public AdminUsersPage enterNewUserPassword(String newPasswordValue) {
		newPassword.sendKeys(newPasswordValue);
		return this;
	}

	public AdminUsersPage selectUserTypeFromTheDropDown() {
		userType.click();
		return this;
	}

	public AdminUsersPage saveThenewuserData() {
		SavethenewUser.click();
		return this;
	}

	public AdminUsersPage ResetNewUserDetailsFromtheEnteredField() {
		ResetNewUserDetails.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

	public AdminUsersPage clickOnTheAlertCloseButton() {
		alertCloseButton.click();
		return this;
	}

	public AdminUsersPage clickOnTheSearchButton() {
		clickSearchButton.click();
		return this;
	}

	public String getTheUserNameExist() {
		String userNameRegistered = getregisteredUsername.getText();
		System.out.println("The user type registered is" + userNameRegistered);
		return userNameRegistered;

	}

	public AdminUsersPage searchUserNameExist(String userNameRegistered) {
		serachUsernameExist.sendKeys(userNameRegistered);
		return this;
	}

	public String getTheUserType() {
		String userTypeRegistered = getNewlyRegisteredUserType.getText();
		System.out.println("The user type registered is" + userTypeRegistered);
		return userTypeRegistered;
	}

	public AdminUsersPage searchTheUserTypeExist(String userTypeRegistered) {
		chooseUserTypeselected.sendKeys(userTypeRegistered);
		return this;
	}

	public String searchedUserNameResult() {
		String userNamesearchResult = searchResultUserName.getText();
		System.out.println("The result of searched username: " + userNamesearchResult);
		return userNamesearchResult;
	}

//public void selecttheUserTyperegistered()
//{
	// getNewlyRegisteredUserType.click();
//}
//public void chooseTheUserTypeSelected()
//{
	// chooseUserTypeselected.click();
//}
	public AdminUsersPage clickButtonToSearchTheExistingAdminUser() {
		clickToSearchTheexistingAdminuser.click();
		return this;
	}

	public boolean isAlertExistDisplayed() {
		return alertExistuser.isDisplayed();
	}

	public AdminUsersPage deleteTheSearchedUser() {
		deleteSearchedUser.click();
		return this;
	}

	public AdminUsersPage clickOnTheResetButton() {
		Reset.click();
		return this;
	}

	public String assertionOfResetPageusingNewpage() {
		String assertNewAdminUser = adminpageNewAssertText.getText();
		System.out.println("The new admin page element is: " + assertNewAdminUser);
		return assertNewAdminUser;
	}

	public String assertionOfResetPageusingSearchpage() {
		String assertSearchAdminUser = adminpageSearchAssertText.getText();
		System.out.println("The Search page element is: " + assertSearchAdminUser);
		return assertSearchAdminUser;
	}

}
