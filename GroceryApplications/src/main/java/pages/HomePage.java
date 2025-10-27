package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class ='nav-item dropdown']//a[@class ='nav-link']")
	WebElement Admin;
	@FindBy(xpath = "//li[@class='nav-item dropdown show']//a[2]")
	WebElement Logout;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Admin Users']")
	WebElement adminusers;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Admin Users']/parent::div/parent::div//a")
	WebElement adminMoreInfo;
	@FindBy(xpath = "//p[text()='Admin Users']/preceding-sibling::h3")
	WebElement adminUsersCount;

	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage News']/parent::div/parent::div/a")
	WebElement manageNewsMoreInfo;
	@FindBy(xpath = "//h1[text()='Manage News']")
	WebElement manageNewsPageTitle;
	@FindBy(xpath = "//div[@class='card-body login-card-body']//p[text()='Sign in to start your session']")
	WebElement loginPageElement;
	@FindBy(xpath = "//div[@class='container-fluid']//h1[text()='Admin Users']")
	WebElement adminPageAssertElement;

	public HomePage verifytheTotalNumberOfAdminUsers() {
		System.out.println("The total count of " + adminusers.getText() + " is : " + adminUsersCount.getText());
		return this;
	}

	public HomePage clickToNavigateToAdminUsersPage() {
		adminMoreInfo.click();
		return this;
	}

	public String adminpageAssetionValidation() {
		String adminAssertion = adminPageAssertElement.getText();
		System.out.println("The admin page headding is :" + adminAssertion);
		return adminAssertion;

	}

	public HomePage clickAdminDropDown() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// wait.until(ExpectedConditions.visibilityOf(Admin));
		// wait.until(ExpectedConditions.elementToBeClickable(Admin));
		Admin.click();
		return this;
	}

	public HomePage clickManageNewsMoreInfo() {
		manageNewsMoreInfo.click();
		return this;
	}

	public String verifyManageNewsPageTitleAssetion() {
		String pageTitleManage = manageNewsPageTitle.getText();
		System.out.println("The page title is: " + pageTitleManage);
		return pageTitleManage;
	}

	public HomePage clickLogoutButtonFromAdminDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(Logout));
		// wait.until(ExpectedConditions.visibilityOf(Logout));
		Logout.click();
		return this;
	}

	public String verifyLogoutAssetion() {
		String logouttoLoginPae = loginPageElement.getText();
		System.out.println("Verify the login page element: " + logouttoLoginPae);
		return logouttoLoginPae;
	}

}
