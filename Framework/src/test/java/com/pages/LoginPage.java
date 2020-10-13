package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	
	//this is new commit from Ankit 
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	
	@FindBy(name="username") WebElement uname;
	
	@FindBy(name="password") WebElement password;
	
	
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	
	
	public void loginToCRM(String username, String pass)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		uname.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
		
	}
	
	
	

}
