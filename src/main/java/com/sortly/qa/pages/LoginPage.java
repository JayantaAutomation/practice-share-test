package com.sortly.qa.pages;

/**
 * This class serves as the child class for the BaseTest Parent class. Within
 * this class, the following tasks are performed: Creation of Object
 * repositories for Login page by using page factory. Initialize the Page
 * Objects. Create Actions or methods
 *
 * @author Jayanta kumar panda
 *
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sortly.qa.base.BaseTest;

public class LoginPage extends BaseTest {

	// Page Factory - Object Repository:
	@FindBy(xpath = "//input[@name='email']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	@CacheLookup
	WebElement continueBtn;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public HomePage loginOwner(String em, String pwd) {
		email.sendKeys(em);
		password.sendKeys(pwd);
		continueBtn.click();

		return new HomePage();
	}

	public HomePage loginTeamMember(String emtm, String pwdtm) {
		email.sendKeys(emtm);
		password.sendKeys(pwdtm);
		continueBtn.click();

		return new HomePage();
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

}
