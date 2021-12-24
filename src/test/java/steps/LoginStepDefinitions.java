package steps;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DatabasePage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinitions extends TestBase{
	LoginPage loginPage;
	DatabasePage databasePage;
	
	
	@Before
	public void beforeRun() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		databasePage = new DatabasePage();
			
	}
	
	@Given ("^User is on Techfios login page$")
	public void user_is_on_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=admin/");
		
	}
	
	@When ("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username) throws InterruptedException {
		loginPage.enterUserName(username);
		
	}
	
		
	@When ("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) throws InterruptedException {
		loginPage.enterPassword(password);	
		Thread.sleep(3000);
	}
	
	
	@And ("^User clicks on signin button$")
	public void user_clicks_on_signin_button() throws InterruptedException {
			loginPage.clickSignInButton();	
			Thread.sleep(3000);
			
		}		
	
		
	@Then ("^User should land on dashboard page$")
	public void user_should_land_on_dashboard_page() throws IOException, InterruptedException {
	
		String actualTitle = loginPage.getPageTitle();
		String expectedTitle = "Dashboard- iBilling";
		
		Assert.assertEquals("Page titles are not matching!", expectedTitle, actualTitle);
		
		takeScreenshot(driver);
		
		Thread.sleep(3000);
	}
	
	@When("^User enters \"([^\"]*)\" from techfios database$")
	public void user_enters_from_techfios_database(String data) throws Throwable {
		switch (data) {
		case "username":
//			String username = databasePage.getData("username");
			loginPage.enterUserName(databasePage.getData("username"));
			System.out.println("UserName from DB" + databasePage.getData("username"));
			Thread.sleep(3000);
			break; 
		case "password":
			loginPage.enterPassword(databasePage.getData("password"));
			System.out.println("Password from DB" + databasePage.getData("password"));
			Thread.sleep(3000);
			break;
		default:
			break;
		}
	}
	
	@When("^User clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String button) throws Throwable {
		switch (button) {
		case "signin":
			loginPage.clickSignInButton();
			Thread.sleep(3000);
			break; 
		case "bankCash":
			loginPage.clickBankCashButton();
			Thread.sleep(3000);
			break; 
		case "newAccount":
			loginPage.clickNewAccountButton();
			Thread.sleep(3000);
			break; 
		case "submit":
			loginPage.clickSubmitButton();
			Thread.sleep(3000);
			break; 
		default:
			break;
		}
	}
	
	@Then("^User enters \"([^\"]*)\" in accounts page$")
	public void user_enters_in_accounts_page(String data) throws Throwable {
	    switch(data) {
	    case "bankCash":
	    	loginPage.clickBankCashButton();
	    	Thread.sleep(3000);
			break;
	    case "newAccount":
	    	loginPage.clickNewAccountButton();
	    	Thread.sleep(3000);
			break;
	    case "accountTitle":
	    	loginPage.enterAccountTitle();
	    	Thread.sleep(3000);
			break;
	    case "description":
	    	loginPage.enterDescription();
	    	Thread.sleep(3000);
			break;
	    case "initialBalance":
	    	loginPage.enterInitialBalance();
	    	Thread.sleep(3000);
			break;
	    case "accountNumber":
	    	loginPage.enterAccountNumber();
	    	Thread.sleep(3000);
			break;
	    case "contactPerson":
	    	loginPage.enterContactPerson();
	    	Thread.sleep(3000);
			break;
	    case "Phone":
	    	loginPage.enterPhone();
	    	Thread.sleep(3000);
			break;
	    case "internetBankingURL":
	    	loginPage.enterInternetBankingURL();
	    	Thread.sleep(3000);
			break;
	    default:
			break;
		}
	}

	@Then("^User should be able to validate account created successfully$")
	public void user_should_be_able_to_validate_account_created_successfully() throws Throwable {
		String actualTitle = loginPage.getPageTitle();
		String expectedTitle = "Accounts- iBilling";
		
		Assert.assertEquals("Page titles are not matching!", expectedTitle, actualTitle);
		
		takeScreenshot(driver);
		
		Thread.sleep(3000);
	   
	}


	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
