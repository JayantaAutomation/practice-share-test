package com.sortly.qa.pages;

/**
 * This class serves as the child class for the BaseTest Parent class. Within this class, the following tasks are performed:
 * Creation of Object repositories for Home page by using page factory.
 * Initialize the Page Objects.
 * Create Actions or methods
 *
 * @author Jayanta kumar panda
 *
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sortly.qa.base.BaseTest;

public class HomePage extends BaseTest {

	// Page Factory - Object Repository:

	@FindBy(xpath = "//button[@data-testid='settings-button']")
	@CacheLookup
	WebElement settingsBtn;

	@FindBy(xpath = "//span[@class='sc-beySbM kHiRUw'][normalize-space()='Settings']")
	@CacheLookup
	WebElement settingsLink;

	@FindBy(xpath = "//span[normalize-space()='Addresses']")
	@CacheLookup
	WebElement addressesLink;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement newaddressBtn;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public HomePage clickOnSettingsBtn() {
		settingsBtn.click();
		return new HomePage();
	}

	public HomePage clickOnSettingsLink() {
		settingsLink.click();
		return new HomePage();
	}

	public HomePage clickOnAddressesLnk() {
		addressesLink.click();
		return new HomePage();
	}

	public HomePage clickOnNewAddressBtn() throws InterruptedException {
		Thread.sleep(3000);
		newaddressBtn.click();
		return new HomePage();
	}

}
