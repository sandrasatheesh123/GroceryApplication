package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(name = "username")
	private WebElement username;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;
	@FindBy(xpath = "//p[text()='Admin Users']")
	private WebElement adminusers;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement supermarket;
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement invalidusernamePasswordAlert;

	public LoginPage enterUserName(String usernameValue) {
		wait.until(ExpectedConditions.visibilityOf(username));
		username.clear();
		username.sendKeys(usernameValue);
		return this;
	}

	public LoginPage enterPassword(String passwordValue) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys(passwordValue);
		return this;
	}

	public HomePage clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
		return new HomePage(driver);
	}

	public boolean adminusers() {
		return wait.until(ExpectedConditions.visibilityOf(adminusers)).isDisplayed();
	}

	public String isTitleDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(supermarket)).getText();
	}

	public boolean invalidcredentials() {
		return wait.until(ExpectedConditions.visibilityOf(invalidusernamePasswordAlert)).isDisplayed();
	}
}