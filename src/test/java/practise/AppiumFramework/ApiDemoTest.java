package practise.AppiumFramework;

import java.io.IOException;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import pageObjects.HomePage;
import pageObjects.Preferences;

public class ApiDemoTest extends base {

	@Test
	public void apiDemo(String input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// xpath id className, androidUIautomator
		/*
		 * xpath Syntax //tagName[@attribute='value']
		 * 
		 * 
		 */
		HomePage h = new HomePage(driver);
		// Constructor of class will be invoked when you create object for the class

		// default constructor be called

		// constructor can be defined with arguments

		// driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

		// You can call the methods or variables of the class with class object

		h.Preferences.click();

		Preferences p = new Preferences(driver);
		// driver.findElementByXPath("//android.widget.TextView[@text='3. Preference
		// dependencies']").click();
		p.dependencies.click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		// driver.findElementsByClassName("android.widget.Button").get(1).click();
		p.buttons.get(1).click();

	}

}
