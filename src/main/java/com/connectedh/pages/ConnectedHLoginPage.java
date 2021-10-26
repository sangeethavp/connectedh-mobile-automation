package com.connectedh.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ConnectedHLoginPage extends BaseConnectedHAutomationPage {

	//private By location = By.xpath("//android.widget.Button[@text = 'ALLOW ONLY WHILE USING THE APP']");

	private By allow = By.xpath("//android.widget.Button[@text = 'ALLOW ONLY WHILE USING THE APP']");

	private By newBooking = By.xpath("//android.widget.TextView[@text = 'New Booking']");

	private By enterMobileNumber = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");

	private By enterAlternateMobileNumber = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");

	private By name = By.id("//android.view.ViewGroup[3]/android.widget.EditText");

	private By clickGender = By.xpath("//android.widget.TextView[@text = 'Male']");

	private By selectGender = By.xpath("//android.widget.CheckedTextView[@text = 'Female']");

	private By clickDate = By.xpath("//android.widget.ScrollView//android.view.ViewGroup[2]");

	
	private By ok = By.xpath("//android.widget.Button[@text = 'OK']");

	private By collDateClick = By.xpath("//android.view.ViewGroup[3]/android.widget.TextView");

	private By clearMapAddress = By.xpath("//android.view.ViewGroup[2]/android.widget.TextView");


	private By toggle = By.xpath("android:id/toggle_mode");
	
	private By hour = By.xpath("android:id/input_hour");
	
	private By minute = By.xpath("android:id/input_minute");
	
	
	
	private By address = By.xpath("//android.widget.EditText");
	
	private By mapSearch = By.xpath("//android.widget.TextView[@text = 'Search on Map']");
	
	private By searchPlaces = By.xpath("//android.widget.EditText[@text = 'Search Places']");
	
	private By selectMapAddress = By.xpath("//android.widget.TextView[@text = 'Narayana Junior College, Sanjeeva Reddy Nagar, Hyderabad, Telangana, India']");
	 
	private By done = By.xpath("//android.widget.TextView[@text = 'Done']");
	
	private By mapBack = By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]");
	
	private By clickAtt = By.xpath("//android.widget.TextView[@text = 'Attach prescription']");
	
	private By clickFile = By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup[2]");
	
	private By selectFile = By.xpath("//android.widget.FrameLayout[1]/com.google.android.material.card.MaterialCardView[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.ImageView[1]");
	
	private By comments = By.xpath("//android.widget.EditText[@text = 'Add your comment']");
	
	private By errorText = By.xpath("android:id/title_template");
	
	private By errorTestMessage = By.xpath("//android.widget.TextView[@text = 'Atleast one test is required']");
	//android.widget.TextView[@text = 'Done']

	private AppiumDriver<MobileElement> driver = null;

	private VisualComparisionPage visualComparision = null;

	private static final Logger logger = Logger.getLogger(ConnectedHLoginPage.class.getName());

	public ConnectedHLoginPage(AppiumDriver<MobileElement> driver) {

		super(driver);

		this.driver = driver;

		visualComparision = new VisualComparisionPage(driver);
	}

	public void clickOnAllow() throws InterruptedException {

		logger.info("Starting of clickOnAllow method");

		sleep(3000);

		driver.findElement(allow).click();

		logger.info("Ending of clickOnAllow method");

	}
	
	public void visualComparisionOfLoginScreen(Enum SCREEN_ID, String pDeviceName) {
		logger.info("Starting of visualComparisionOfLoginScreen method");

		sleep(3000);

		visualComparision.takeScreenShot(SCREEN_ID, pDeviceName);

		logger.info("Ending of visualComparisionOfLoginScreen method");

	}

	public void clickOnNewBooking() {

		logger.info("Starting of clickOnNewBooking method");

		driver.findElement(newBooking).click();

		logger.info("Ending of clickOnNewBooking method");

	}

	public void clickOnPhoneNumber( String pPhone,String aPhone)  {

		logger.info("Starting of clickOnPhoneNumber method");

		

		driver.findElement(enterMobileNumber).sendKeys(pPhone);
		driver.findElement(enterAlternateMobileNumber).sendKeys(aPhone);

		logger.info("Ending of clickOnPhoneNumber method");

	}

	public void clickOnName(String pName) {

		logger.info("Starting of clickOnName method");


		driver.findElement(name).sendKeys(pName);
		
		driver.hideKeyboard();

		logger.info("Ending of clickOnName method");

	}


	public void clickOnGender() {

		logger.info("Starting of clickOnGender method");

		sleep(3000);

		driver.findElement(clickGender).click();

		driver.findElement(selectGender).click();


		logger.info("Ending of clickOnGender method");

	}

	public void clickOnDOB(String dateValue) {

		logger.info("Starting of clickOnDOB method");


		driver.findElement(clickDate).click();
		
		WebElement date = driver.findElement(By.xpath("//android.view.View[@content-desc = '"+dateValue+"']"));
		date.click();
		
		driver.findElement(ok).click();
		
		
	//	private By selectDate = By.xpath("//android.view.View[@content-desc = '26 October 2021']");


		logger.info("Ending of clickOnDOB method");

	}

	public void collDateAndTime(String collDate, String hourValue, String minValue) {

		logger.info("Starting of collDateAndTime method");


		driver.findElement(collDateClick).click();
		
		WebElement colldate = driver.findElement(By.xpath("//android.view.View[@content-desc = '"+collDate+"']"));
		colldate.click();
		
		//private By collDateSelect = By.xpath("//android.view.View[@content-desc = '26 October 2021']");

		driver.findElement(ok).click();
		
		driver.findElement(toggle).click();
		
		driver.findElement(hour).sendKeys(hourValue);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(minute).sendKeys(minValue);
		
		driver.findElement(ok).click();
		
		
		//Need to Implement Scroll Here
		
		logger.info("Ending of collDateAndTime method");

	}

	public void clickOnAddress(String pAddress) {

		logger.info("Starting of clickOnAddress method");

		driver.findElement(address).sendKeys(pAddress);
		
		driver.hideKeyboard();

		logger.info("Ending of clickOnAddress method");

	}

	public void clickOnMapAddress(String pAddress) {

		logger.info("Starting of clickOnMapAddress method");

		driver.findElement(mapSearch).click();
		
		driver.findElement(clearMapAddress).click();

		driver.findElement(searchPlaces).sendKeys(pAddress);
		
		driver.findElement(selectMapAddress).click();
		
		try {
			driver.findElement(done).click();
		} catch (Exception e) {
			driver.findElement(mapBack).click();
		}
		//Scroll TO be implemented
		logger.info("Ending of clickOnMapAddress method");

	}
	public void clickOnAttachment() {
		logger.info("Starting of clickOnAttachment Method");
		
		driver.findElement(clickAtt).click();
		
		driver.findElement(clickFile).click();
		
		driver.findElement(selectFile).click();
		
		//Need to Implement Scroll 
		logger.info("Ending of clickOnAttachment Method");
		
	}

	public void clickOnComments(String commentValue) {

		logger.info("Starting of clickOnComments method");

		driver.findElement(comments).sendKeys(commentValue);

		driver.findElement(done).click();
		
		driver.hideKeyboard();

		logger.info("Ending of clickOnComments method");

	}
	
	public void clickOnDone() {
		
		logger.info("Starting of clickOnComments method");

		driver.findElement(done).click();
		
		logger.info("Ending of clickOnComments method");
		
	}


}
