package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class=\"col-sm-12\"]//a[1]//i")
	WebElement NewManageNews;
	@FindBy(xpath = "//div[@class='col-sm-12']//a[2]//i")
	WebElement SearchManageNews;
	@FindBy(xpath = "//div[@class=\"form-group\"]//textarea[@id=\"news\"]")
	WebElement enterNews;
	@FindBy(xpath = "//div[@class=\"card-footer\"]//button[@name=\"create\"]")
	WebElement saveNewsButton;
	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement successAlert;
	@FindBy(xpath = "//div[@class='col-sm-12 form-group']//input[@name='un']")
	WebElement enterToSearchTheNews;
	@FindBy(xpath = "//div[@class='card-body']//button[@name='Search']")
	WebElement clickOnTheSearchButtonToSubmitTheSearchedNews;
	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover table-sm\"]//tbody//tr[1]//td[1]")
	WebElement GetSearchedNews;

	public ManageNewsPage verifyandClickonTheManageNewButton() {
		NewManageNews.click();
		return this;
	}

	public ManageNewsPage createNews(String news) {
		enterNews.sendKeys(news);
		saveNewsButton.click();
		return this;
	}

	public boolean successAlertAssertion() {
		return successAlert.isDisplayed();

	}

	public ManageNewsPage verifyandManageSearchNews() {
		SearchManageNews.click();
		return this;
	}

	public ManageNewsPage enterTheNewsYouAreSearching(String searchedNews) {
		enterToSearchTheNews.sendKeys(searchedNews);
		clickOnTheSearchButtonToSubmitTheSearchedNews.click();
		return this;
	}

	public String GetSearchedNewsSuccessAlert() {
		return GetSearchedNews.getText();

	}

}
