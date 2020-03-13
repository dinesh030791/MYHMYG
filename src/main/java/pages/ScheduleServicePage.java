package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class ScheduleServicePage  extends ProjectWrapp{
	public  ScheduleServicePage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
//	if(!verifyTitlecontains("Manage Subscription | MyHyundai")){
//		
//		reportStep("This is not  Manage Subscription | MyHyundai", "FAIL");
//			}

	}
	
	
	
	public ScheduleServicePage completeScheduleService() throws InterruptedException {
		Thread.sleep(20000);
		List<WebElement> iframesele =listele(prop.getProperty("Scheduler.frames.xpath"));
			driver.findElements(By.xpath("//iframe"));
		System.out.println(iframesele.size());
		Thread.sleep(4000);
		int size =iframesele.size();		
		System.out.println("Total Frames --" +size);
locateFrame(0);
Thread.sleep(10000);
List<WebElement> iframeselesecond =listele(prop.getProperty("Scheduler.frames.xpath"));
		int	sizesecondFrame=iframeselesecond.size();           
		    System.out.println("Total Frames --" +sizesecondFrame);
		    Thread.sleep(10000);
		   // driver.switchTo().frame(0); // Switching to innerframe
		    locateFrame(0);
		System.out.println("Frame has been located");
		Thread.sleep(4000);
		enterByXpathExplict(prop.getProperty("email.schedule.xpath"),"lksingh@mailnesia.com");
		clickByXpathExplict(prop.getProperty("email.schedule.button.xpath"));
		clickByXpathExplict(prop.getProperty("hyundai.button.xpath"));
		clickByXpathExplict(prop.getProperty("hyundai.year.button.xpath"));
		clickByXpathExplict(prop.getProperty("hyundai.year.model.xpath"));
		clickByXpathExplict(prop.getProperty("hyundai.year.continue.xpath"));
		Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("severe.conditions.xpath"));
		clickByXpathExplict(prop.getProperty("click.scheduler.continue.xpath"));
			
		clickByXpathExplict(prop.getProperty("service.ride.xpath"));
				//clickByXpathExplict(prop.getProperty("Service.options.xpath"));
				//clickByXpathExplict(prop.getProperty("Schedule.continue.button.xpath"));
				//clickByXpathExplict(".//span[text()='Search for Recalls']");
			//	clickByXpathExplict(prop.getProperty("Service.appointment.xpath"));	
			//	clickByXpathExplict(prop.getProperty("service.ride.xpath"));		
				clickByXpathExplict(prop.getProperty("service.ride.next.xpath"));
				clickByXpathExplict(prop.getProperty("service.calendar.xpath"));
				clickByXpathExplict(prop.getProperty("service.date.xpath"));
				pageScroll400();
				Thread.sleep(4000);
				clickByXpathExplict(prop.getProperty("click.scheduler.continue.xpath"));
				//clickByXpathExplict(prop.getProperty("service.review.xpath"));
				Thread.sleep(4000);
				//clickByXpathExplict(prop.getProperty("service.review.xpath"));
				enterByXpathExplict(".//input[@id='first_name_input']","Tom");
				enterByXpathExplict(".//input[@id='last_name_input']","Brady");
				enterByXpathExplict(".//input[@id='phone_input']","4084065370");
				pageScroll400();
				clickByXpathExplict(".//div[@class='button-label']");
				verifyTextByXpathExplicitwait("(.//div[starts-with(@class,'success__middle')])[2]","Success!");
				verifyTextByXpathExplicitwait(".//div[starts-with(@class,'success__middle--message')]","We'll send you an email confirmation");
		return this;
	}
	
	
	
	
	
}