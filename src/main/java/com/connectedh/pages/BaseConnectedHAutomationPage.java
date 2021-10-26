package com.connectedh.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseConnectedHAutomationPage {
	protected AppiumDriver<MobileElement> driver = null;

	private static final Logger logger = Logger.getLogger(BaseConnectedHAutomationPage.class.getName());

	public BaseConnectedHAutomationPage(AppiumDriver<MobileElement> driver) {

		this.driver = driver;

	}

	public void implicitWait() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	public void sleep(int sec) {

		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {

		}

	}
}
