package com.sortly.qa.testcases;

/**
 * This class serves as the child class for the BaseTest Parent class. Within
 * this class, the following tasks are performed: Creation of test cases by
 * using TestNg annotation i.e. @BeforeMethod, @Test and @AfterMethod. Verify
 * each test cases expected results by using assertions.
 *
 * @author Jayanta kumar panda
 *
 */

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sortly.qa.base.BaseTest;
import com.sortly.qa.pages.HomePage;
import com.sortly.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}

	// TC_01_Verify the Login Page Title
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Sortly", "Login Page title not matched");
	}

	// TC_02_Verify login for the user " Owner"using valid user name and password and the Home page should be displayed after successful login.
	@Test(priority = 2)
	public void loginTestOwner() throws InterruptedException {
		homepage = loginPage.loginOwner(prop.getProperty("email"), prop.getProperty("password"));
	}

	// TC_03_Verify login for the user "Team Member" using valid user name and password and the Home page should be displayed after successful login.
	@Test(priority = 3)
	public void loginTestTeamMember() throws InterruptedException {
		homepage = loginPage.loginTeamMember(prop.getProperty("emailTM"), prop.getProperty("passwordTM"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}