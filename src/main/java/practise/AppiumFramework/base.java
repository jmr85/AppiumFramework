package practise.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(appName));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// String device=(String) prop.get("device");
		String device = System.getProperty("device");
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);

		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}
