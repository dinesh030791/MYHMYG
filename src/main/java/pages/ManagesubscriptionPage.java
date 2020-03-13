package pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class ManagesubscriptionPage extends ProjectWrapp{
	public  ManagesubscriptionPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
//	if(!verifyTitlecontains("Manage Subscription | MyHyundai")){
//		reportStep("This is not  Manage Subscription | MyHyundai", "FAIL");
//			}
//	}
	}
		

		public  ReviewOrderPage  selectPackages() throws IOException, InterruptedException {
			Thread.sleep(30000);
//			clickByXpathExplict(prop.getProperty("click.cc.package.xpath"));
//			pageScroll400();		
//			Thread.sleep(2000);
//
//		
//		  clickByXpathExplict(prop.getProperty("click.remote.package.xpath"));
//		  pageScroll400(); Thread.sleep(2000);
//		  
//		 clickByXpathExplict(prop.getProperty("click.guidance.package.xpath"));
//		 //clickByXpathExplict(prop.getProperty("click.agreecheckbox.xpath"));
//		  
//		  clickByXpathExplict(prop.getProperty("click.placeorder.xpath"));
//		  Thread.sleep(20000);
//		
		clickByXpathExplict(prop.getProperty("Agree.checkbox.xpath"));
		Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("enrolplaceOrder.button.xpath"));

		Thread.sleep(40000);
		
	
			return new ReviewOrderPage(driver, test);
		}
	

		public  MyH_Dashboardpage  performCancelssubscription() throws IOException, InterruptedException {
			clickByXpathExplict(prop.getProperty("cancel.subscripiton.xpath"));
			pageScroll400();
			Thread.sleep(8000);
clickByXpathExplict(prop.getProperty("cancel.button.subscripiton.xpath"));
Thread.sleep(40000);

verifyTextContainsByXpathexplictwait(prop.getProperty("cancel.valMsg.xpath"),"Your Blue Link subscription will now be canceled");
Thread.sleep(2000);
clickByXpathExplict(prop.getProperty("close.cancelpopup.xpath"));
Thread.sleep(10000);
verifyTextContainsByXpathexplictwait(prop.getProperty("cancel.valMsgCWP.xpath"),"Your subscription is now canceled");
Thread.sleep(4000);
clickByXpathExplict(prop.getProperty("click.okButton.cancelpage.xpath"));
Thread.sleep(20000);

return new MyH_Dashboardpage(driver, test);
		}
}
