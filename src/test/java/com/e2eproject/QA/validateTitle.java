package com.e2eproject.QA;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class validateTitle extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage landingpage;
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test(priority=0)

	public void validateAppTitle() throws IOException {

		// one is inheritance
		// creating object to that class and invoke methods of it
		landingpage = new LandingPage(driver);
		// compare the text from the browser with actual text.- Error..
		String title=driver.getTitle();
		Assert.assertEquals(title, "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
		log.info("Successfully validated Text message");
		System.out.println("Test completed");

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
