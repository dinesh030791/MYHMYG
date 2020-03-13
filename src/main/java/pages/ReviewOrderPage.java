package pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class ReviewOrderPage extends ProjectWrapp{
	public  ReviewOrderPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
//	if(!verifyTitlecontains("Manage Subscription | MyHyundai")){
//		
//		reportStep("This is not  Manage Subscription | MyHyundai", "FAIL");
//			}

	}

		public MyH_Dashboardpage verifyorder() throws InterruptedException {
			Thread.sleep(35000);
	verifyTextContainsByXpath(prop.getProperty("verify.confirm.order.xpath"),"Thank");
	Thread.sleep(8000);
	pageScroll400();
	clicklistByxpathExplicitwait(prop.getProperty("click.proceed.selfenrol.dashboard.xpath"));
	Thread.sleep(10000);
		return new MyH_Dashboardpage(driver, test);
		}

	
	
	

}
