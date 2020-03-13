package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;
import wrappers.ProjectWrapp;

public class ForgotPassword extends ProjectWrapp{
	
	public  ForgotPassword(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	static WebDriverWait wait;
	
	public ForgotPassword clickForgotpassword() throws InterruptedException
	{
		Thread.sleep(10000);
		pageRefresh();
		try {
			clickByLinkText(prop.getProperty("homepage.forgotpassword.link"));
			Thread.sleep(10000);
			pageRefresh();
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("resetCancel"))));
			Thread.sleep(3000);			  
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	static String UserMailId;
	public ForgotPassword giveMailIDtoReset(String UserName)
	{
		try {
			UserMailId =UserName;
			driver.findElement(By.id("username")).clear();
			  driver.findElement(By.id("username")).sendKeys(UserMailId);
			  Thread.sleep(1000);
			  driver.findElement(By.cssSelector("input.next_security_que.submit_button")).click();
			  wait = new WebDriverWait(driver,30);
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("txt_reset_security_answer"))));
			  Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	public ForgotPassword passwordresetSecurityQstn(String SecQstn)
	{
		try {
			driver.findElement(By.id("txt_reset_security_answer")).click();
			  driver.findElement(By.id("txt_reset_security_answer")).sendKeys(SecQstn);
			  Thread.sleep(1000);
			  driver.findElement(By.id("btn_answer")).click();			  
			  try {
				  wait = new WebDriverWait(driver,30);
				  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='reset_verification_code']/div/div[1]/input[1]"))));
				  System.out.println("Send To Phone - Option Available");
			} catch (Exception e) {
				wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='reset_verification_code']/div/div[2]/div/input"))));
				System.out.println("Send To Email - Option ONLY Available");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	public ForgotPassword PswdVerificationCodePage(String key, String Option1, String Option2)
	{
		String temp_Pswd=null;
		try {
			driver.findElement(By.linkText("Verification Code")).click();
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Cancel"))));
			Thread.sleep(3000);
			
			switch (key) {
			case "1":
				driver.findElement(By.id("reset_password_phone")).click();
				driver.findElement(By.id("reset_password_phone")).sendKeys(Option1);
				Thread.sleep(1000);
				driver.findElement(By.id("reset_zipcode")).click();
				driver.findElement(By.id("reset_zipcode")).sendKeys(Option2);
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("input.next-sending-details.submit_button")).click();
				
				 try {
					  	wait = new WebDriverWait(driver,30);
						wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='sending_details']/div/div[1]/input"))));
						System.out.println("Send To Phone - Option Available");
				  	} catch (Exception e) {
						wait = new WebDriverWait(driver,30);
						wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='sending_details']/div/div[2]/input"))));
						System.out.println("Send To Email - Option ONLY Available");
				  	}
				  
				  driver.findElement(By.xpath(".//*[@id='sending_details']/div/div[2]/input")).click();
				  Thread.sleep(1000);
				  
				  wait = new WebDriverWait(driver,30);
				  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Cancel"))));
				  Thread.sleep(2000);
				 
				  temp_Pswd = GenericWrappers.PswdRst_Tmp(UserMailId);
				  
				  driver.findElement(By.id("verify_code")).click();
				  driver.findElement(By.id("verify_code")).clear();
				  driver.findElement(By.id("verify_code")).sendKeys(temp_Pswd);
				  Thread.sleep(1000);
				  driver.findElement(By.cssSelector("input.next-temp-pass.submit_button")).click();
				  wait = new WebDriverWait(driver,30);
				  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Cancel"))));
				  Thread.sleep(2000);				
				break;
				
			case "2":				  
				  driver.findElement(By.id("reset_vinnum")).click();
				  driver.findElement(By.id("reset_vinnum")).sendKeys(Option1);
				  Thread.sleep(1000);
				  driver.findElement(By.id("reset_zipcode2")).click();
				  driver.findElement(By.id("reset_zipcode2")).sendKeys(Option2);
				  Thread.sleep(1000);
				  driver.findElement(By.cssSelector("input.next-sending-details.submit_button")).click();
				  
				  
				  try {
					  	wait = new WebDriverWait(driver,30);
						wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='sending_details']/div/div[1]/input"))));
						System.out.println("Send To Phone - Option Available");
				  	} catch (Exception e) {
						wait = new WebDriverWait(driver,30);
						wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='sending_details']/div/div[2]/input"))));
						System.out.println("Send To Email - Option ONLY Available");
				  	}
				  
				  driver.findElement(By.xpath(".//*[@id='sending_details']/div/div[2]/input")).click();
				  Thread.sleep(1000);
				  
				  wait = new WebDriverWait(driver,30);
				  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Cancel"))));
				  Thread.sleep(2000);
				 
				  temp_Pswd = GenericWrappers.PswdRst_Tmp(UserMailId);
				  
				  driver.findElement(By.id("verify_code")).click();
				  driver.findElement(By.id("verify_code")).clear();
				  driver.findElement(By.id("verify_code")).sendKeys(temp_Pswd);
				  Thread.sleep(1000);
				  driver.findElement(By.cssSelector("input.next-temp-pass.submit_button")).click();
				  wait = new WebDriverWait(driver,30);
				  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Cancel"))));
				  Thread.sleep(2000);
				  
			default:
				
				break;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	public ForgotPassword passwordresetSendToPhone()
	{
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	public ForgotPassword passwordresetSendToMail()
	{
		try {
			driver.findElement(By.xpath(".//*[@id='reset_verification_code']/div/div[2]/div/input")).click();
			System.out.println("Clicked Send To Email - Option");
			Thread.sleep(1000);
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Cancel"))));
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	public ForgotPassword passwordresetMailTemporaryCodePswd()
	{
		try {
			String temp_Pswd = GenericWrappers.PswdRst_Tmp(UserMailId);
			driver.findElement(By.id("password_temp")).click();
			driver.findElement(By.id("password_temp")).clear();
			driver.findElement(By.id("password_temp")).sendKeys(temp_Pswd);
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("input.next-password-new.submit_button")).click();
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Cancel"))));
			Thread.sleep(3000);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	public MyH_Dashboardpage passwordresetChangePassword()
	{
		try {
			long tmp_psswrd = System.currentTimeMillis();
			String Passwrd = "test"+String.valueOf(tmp_psswrd).substring(5,9).trim();
			System.out.println("Changed Password: "+Passwrd); 
			driver.findElement(By.id("reg_password")).click();
			driver.findElement(By.id("reg_password")).sendKeys(Passwrd); //inpt_flt_lbl input-pwd disablepaste input_error // Based on the Input Class getting change dynamically
			driver.findElement(By.id("confirm_password")).sendKeys(Passwrd);
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("input.reset-end.submit_button")).click();
			  
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Dashboard.customize.link.xpath"))));
			Thread.sleep(1000);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new MyH_Dashboardpage(driver, test);
	}
	
	public static void checkallurls()
	  {
		  try {
			  List<WebElement> links = driver.findElements(By.tagName("a"));
			  System.out.println(links.size());
			  
			  for (int i = 1; i<=links.size(); i=i+1)
			  {
				  System.out.println(links.get(i).getText());		  
			  }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	  }

}
