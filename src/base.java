import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	
	static AndroidDriver<AndroidElement> driver;
	DesiredCapabilities capabilities;
	static File appDir = new File("src");
    static File app = new File(appDir, "carbon_ng-v6.7.1_signed.apk");
    
		@BeforeTest
		
		public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
			
		    
		     
		    	DesiredCapabilities capabilities = new DesiredCapabilities();
				
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
				capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 240);
			    
			    driver = new AndroidDriver<>(new URL("http://127.0.01:4723/wd/hub"),capabilities);
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    
			    return driver;
		}
		
		@AfterTest
		public static void teardownDriver() throws IOException {
			driver.close();
			driver.quit();

		}
}
