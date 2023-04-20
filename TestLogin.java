package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import objectReporsitory.LoginPageOREdu;
import reUsableFunction.BrowserFactory;

public class TestLogin {
	
	WebDriver driver;
	BrowserFactory browserobj = new BrowserFactory();
	//LoginPageOREdu obj = new LoginPageOREdu(driver);
	LoginPageOREdu obj = new LoginPageOREdu(browserobj.initBrowser("Chrome"));
	
	
	@Before("@Edubridge")
	public void beforeHook()
	{
		System.out.println("Before Hook is running....");
	}
	
	@After("@Edubridge")
	public void afterHook()
	{
		System.out.println("After Hook is running....");
	}
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		obj.launchApplication("https://mail.rediff.com/cgi-bin/login.cgi");
	}

	@When("^user enter valid username \"(.*?)\" and valid password \"(.*?)\"$")
	public void user_enter_valid_username_and_valid_password(String uname, String pwd) {
	   obj.enterUserName(uname);
	   obj.enterPassword(pwd);
	   obj.clickButton();
	}

	@Then("user should be able to login")
	public void user_should_be_able_to_login() {
		boolean flag = obj.isLogoutLinkDisplayed();
		Assert.assertTrue(flag);
	}

	@Then("close the browser")
	public void close_the_browser() {
	   obj.closeBrowser();
	}
	  
	@When("^user enter the username \"(.*?)\" and password \"(.*?)\"$")
	public void user_enter_the_username_and_password(String um, String ps) {
	   obj.enterUserName(um);
	   obj.enterPassword(ps);
	   obj.clickButton();
	 }

	@Then("user should not be able to login")
	public void user_should_not_be_able_to_login() {
	   boolean flag = obj.isForgetPasswordLinkDisplayed();
	   Assert.assertTrue(flag);
	  }
}
