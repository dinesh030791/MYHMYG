package pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class EnrollBluelinkPage extends ProjectWrapp{
	

	public  EnrollBluelinkPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	//if(!verifyTitlecontains("Enroll in Blue Link | MyHyundai")){
	//	reportStep("This is not  Enroll in Blue Link | MyHyundai", "FAIL");
	//		}
	}

	public  ManagesubscriptionPage createPIN(String PIN) throws InterruptedException  {
		Thread.sleep(20000);
		
		 Boolean securityHeader=VerifyElementpresentreturn(prop.getProperty("Account.security.verify.xpath")); 
		 
		 	if(securityHeader) { Thread.sleep(4000);
		 clickByXpathExplict(prop.getProperty("current.pin.xpath"));
		 clickByXpathExplict(prop.getProperty("submit.pin.xpath")); 
		 } 
		 	
		 else
		 {
			
enterByXpathExplict(prop.getProperty("Enter.Pin.xpath"),PIN);
enterByXpathExplict(prop.getProperty("EnterConfirm.Pinxpath"),PIN);
clickByXpathExplict(prop.getProperty("submitPin.xpath"));
Thread.sleep(6000);
		}
		return new ManagesubscriptionPage(driver, test);
	
	}

	










}
