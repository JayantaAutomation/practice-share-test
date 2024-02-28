package com.sortly.qa.testcases;

	/**
	 * This class serves as the child class for the BaseTest Parent class. Within this class, the following tasks are performed:
	 * Creation of test cases by using TestNg annotation i.e. @BeforeMethod, @Test and @AfterMethod.
	 * Verify each test cases expected results by using assertions.
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

	public class HomePageTestTM extends BaseTest {

		LoginPage loginPage;
		HomePage homepage;

		public HomePageTestTM() {
			super();
		}

	/**
	* Test cases should be separated -- independent with each other
	* Befor each test case -- launch the browser and login
	* @Test -- execute test case
	* After each test case -- close the browser
	*
	*/

		@BeforeMethod
		public void setup() {
			initialization();
			loginPage = new LoginPage();
			homepage = loginPage.loginTeamMember(prop.getProperty("emailTM"), prop.getProperty("passwordTM"));

		}
		
		// TC_01_Verify the Home Page Title once the user login successfully.
		@Test(priority = 1) 
		public void verifyHomePageTitleTest() {
			String homepageTitle = homepage.verifyHomePageTitle();
			Assert.assertEquals(homepageTitle, "Sortly", "Home page title not matched");
		}

		@Test(priority = 2)
		public void verifyAddressesLinkTest() {
			homepage = homepage.clickOnSettingsBtn();
			homepage = homepage.clickOnSettingsLink();
			homepage = homepage.clickOnAddressesLnk();
		}

		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
