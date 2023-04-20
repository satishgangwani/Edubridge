package objectReporsitory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOREdu {
	
	WebDriver driver;
	
	int a;
	
	@FindBy(id = "login1")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(className = "signinbtn")
	WebElement button;
	
	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	
	@FindBy(linkText = "Forgot Password?")
	WebElement forgetPasswordLink;
	
	public LoginPageOREdu(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void launchApplication(String url)
	{
		driver.get(url);
	}
	
	public void enterUserName(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickButton()
	{
		button.click();
	}
	
	public boolean isLogoutLinkDisplayed()
	{
		try
		{
		logoutLink.isDisplayed();
		return true;
		}catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	public boolean isForgetPasswordLinkDisplayed()
	{
		try
		{
		forgetPasswordLink.isDisplayed();
		return true;
		}catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
}
