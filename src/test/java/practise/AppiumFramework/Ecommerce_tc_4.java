package practise.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;

public class Ecommerce_tc_4 extends base {

	@Test
	public void totalValidation() throws IOException, InterruptedException {
		// 15 -General-Store.apk4.0
		
		service=startServer();

		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		FormPage formPage=new FormPage(driver);
		formPage.getNameField().sendKeys("hello");
		driver.hideKeyboard();
		//driver.findElement(By.xpath("//*[@text='Female']")).click();
		formPage.femaleOption.click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		// if it doesn't work try this line
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum = 0;
		for (int i = 0; i < count; i++) {
			String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText();
			double amount = getAmount(amount1);
			sum += amount;// 280.97
		}
		System.out.println("sum of products: " + sum);
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		total = total.substring(1);
		double totalvalue = Double.parseDouble(total);
		System.out.println("Total value of products: " + totalvalue);
		Assert.assertEquals(sum, totalvalue);
		service.stop();

	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);
		return amount2value;

	}

}
