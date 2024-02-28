package com.sortly.qa.pages;

/**
*
* @author Jayanta kumar panda
*
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sortly.qa.base.BaseTest;

public class AddressPage extends BaseTest {

	// Initializing the Page Objects:
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}

	// Page Factory - Object Repository:
	@FindBy(xpath = "//span[@class='sc-beySbM exzNuE' and contains(text(),'Delete')]")
	WebElement deleteLnk;

	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Delete Address')]")
	WebElement deleteAddressBtn;
	
	@FindBy(xpath = "//span[@class='sc-beySbM exzNuE' and contains(text(),'Edit')]")
	WebElement editAddressLnk;

	// Actions:
	public void createNewAddress(String name, String address1, String address2, String city, String state, String zipCode) throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Name*']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Address 1*']")).sendKeys(address1);
		driver.findElement(By.xpath("//input[@placeholder='Address 2']")).sendKeys(address2);
		driver.findElement(By.xpath("//input[@placeholder='City*']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@placeholder='State / Province / Region*']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@placeholder='Zip / Postal Code*']")).sendKeys(zipCode);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}

	public AddressPage deleteaddress() throws InterruptedException {
		deleteLnk.click();
		deleteAddressBtn.click();
		Thread.sleep(2000);
		return new AddressPage();
	}
	
	public AddressPage updateaddress(String name) throws InterruptedException {
		editAddressLnk.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name*']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Name*']")).sendKeys(name);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		return new AddressPage();
	}
}