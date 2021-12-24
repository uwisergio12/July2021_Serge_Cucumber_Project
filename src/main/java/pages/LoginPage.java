package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement UserName;
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement Password;
	@FindBy(how = How.XPATH, using = "//button[@name='login']") WebElement SignInButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a")
	WebElement bankCash;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	WebElement newAccount;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement accountTitle;
	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
	WebElement description;
	@FindBy(how = How.XPATH, using = "//*[@id=\"balance\"]")
	WebElement initialBalance;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account_number\"]")
	WebElement accountNumber;
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_person\"]")
	WebElement contactPerson;
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_phone\"]")
	WebElement Phone;
	@FindBy(how = How.XPATH, using = "//*[@id=\"ib_url\"]")
	WebElement internetBankingURL;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")
	WebElement submitButton;
	
	// Methods to interact with the elements
	
	
	public void enterUserName(String userName) {
		UserName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickSignInButton() {
		SignInButton.click();
	}
	
	public void clickBankCashButton() {
		bankCash.click();
	}
	
	public void clickNewAccountButton() {
		newAccount.click();
	}
	
	Random rnd = new Random();
	int generatedNumber = rnd.nextInt(999);
	
	public void enterAccountTitle() {
		accountTitle.sendKeys("Checking account" + generatedNumber);
	}
	
	public void enterDescription() {
		description.sendKeys("Cash Deposit and Withdrawal");
	}
	
	public void enterInitialBalance() {
		initialBalance.sendKeys("2000");
	}
	
	public void enterAccountNumber() {
		accountNumber.sendKeys("123456789012345");
	}
	
	public void enterContactPerson() {
		contactPerson.sendKeys("Sergio Ramos" + generatedNumber);
	}
	
	public void enterPhone() {
		Phone.sendKeys("123-456-7890" + generatedNumber);
	}
	
	public void enterInternetBankingURL() {
		internetBankingURL.sendKeys("https://techfios.com/billing/?ng=admin/");
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
