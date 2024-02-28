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

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sortly.qa.base.BaseTest;
import com.sortly.qa.pages.AddressPage;
import com.sortly.qa.pages.HomePage;
import com.sortly.qa.pages.LoginPage;
import com.sortly.qa.util.TestUtil;

public class AddressPageTest extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;
	AddressPage addresspage;

	String sheetName = "address";

	public AddressPageTest() {
		super();
	}

	/**
	 * Test cases should be separated -- independent with each other
	 * Befor each test case -- launch the browser and login
	 * @Test -- execute test case After each test case -- close the browser
	 *
	 */

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		addresspage = new AddressPage();
		homepage = loginPage.loginOwner(prop.getProperty("email"), prop.getProperty("password"));
		homepage = homepage.clickOnSettingsBtn();
		homepage = homepage.clickOnSettingsLink();
		homepage = homepage.clickOnAddressesLnk();

	}

	@DataProvider
	public Object[][] getSortlyAddressTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		System.out.println(" length " + data.length);
		return data;
	}

	// TC_001_Create 3 different users from excel sheet ( Rama Chandra, Damodara and Hare Krishna)
	@Test(priority = 1, dataProvider = "getSortlyAddressTestData")
	public void validateCreateNewAddress(String name, String address1, String address2, String city, String state,
			String zipCode) throws InterruptedException {
		homepage.clickOnNewAddressBtn();
		// addresspopuppage.createNewAddress("Rama Chandra", "Raghuvanahalli Village",
		// "Kanakapura Road", "Bangalore", "Karnataka", "560109");
		addresspage.createNewAddress(name, address1, address2, city, state, zipCode);
		Thread.sleep(2000);
	}

	// TC_002_Delete one user (Hare Krishna)
	@Test(priority = 2)
	public void validateDeleteAddress() throws InterruptedException {
		addresspage = addresspage.deleteaddress();
	}

	// TC_003_Update only the user name (from Damodara to Hrishikesa)
	@Test(priority = 3)
	public void validateUpdateName() throws InterruptedException {
		addresspage = addresspage.updateaddress("Hrishikesa");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}