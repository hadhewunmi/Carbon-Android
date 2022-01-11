import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class login extends base{
	
	@Test
	public static void  LoginandRecharge() throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver =capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//1, click skip
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/tutorial_skip")).click();
		//2 click Allow
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		Thread.sleep(3000);
		//3 click Sign in
     	driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/user_type_existing")).click();
     	Thread.sleep(3000);
		//4 click phone number
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/sign_in_phone")).click();
		Thread.sleep(3000);
		//5 type phone number
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/sign_in_phone")).sendKeys("08990001101");
		//6 click pin
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/sign_in_pin")).click();
		//7 Enter Pin
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/sign_in_pin")).sendKeys("1234");
		//click Sign in button
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/sign_in_next")).click();
		
		// Verify that user is directed to homepage
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/title_text")).isDisplayed();
		
		

		//Recharge Airtime
		driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView")).click();
		//Assert recharge  Airtime page
		String actualString = driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/title_text")).getText();
			assertTrue(actualString.contains("Airtime recharge"));
			
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/edit_text_phone_number")).sendKeys("08077112711");
		
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/edit_text_airtime_price")).sendKeys("100");
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[3]")).click();
		
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/button_next")).click();
		
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/cvWallet")).click();
		

		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/cvWallet")).click();

		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/confirm_payment_button")).click();
		
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/button_text_secure_pay")).click();
		
		//Enter Pin
		driver.findElement(By.xpath("///android.widget.FrameLayout[4]")).sendKeys("1234");
		
		
		

	}

}
