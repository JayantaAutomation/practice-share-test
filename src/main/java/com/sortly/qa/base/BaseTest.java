package com.sortly.qa.base;

/**
 * This class serves as the parent class for all other classes. Within this base
 * class, the following tasks are performed: Initialize the properties,
 * Initialize the webdriver, Maximize the window, Set page load timeout, Define
 * Implicit wait, Delete all cookies,and Launch the URL.
 *
 * @author Jayanta kumar panda
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.sortly.qa.util.TestUtil;
import com.sortly.qa.util.WebEventListener;


public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public BaseTest() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/jayantakumarpanda/eclipse-workspace/AddressesCRUDOnSortlyUIAutomation"
							+ "/src/main/java/com/sortly/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/jayantakumarpanda/Downloads/chromedriver-mac-x64/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/jayantakumarpanda/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Edge")){
			System.setProperty("webdriver.edge.driver", "/Users/jayantakumarpanda/Downloads/edgedriver");
			driver = new EdgeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
