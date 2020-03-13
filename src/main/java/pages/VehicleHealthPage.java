package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;

import com.relevantcodes.extentreports.ExtentTest;
import wrappers.ProjectWrapp;
public class VehicleHealthPage extends ProjectWrapp{
	public  VehicleHealthPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	//if(!verifyTitlecontains("Vehicle Health | MyHyundai ")){
	//	reportStep("This is not Vehicle Health | MyHyundai ", "FAIL");
		//	}
	}
	public ScheduleServicePage clickScheduleButton() throws InterruptedException {
		clickByXpathExplict(prop.getProperty("Click.schedule.button.xpath"));
		Thread.sleep(10000);
	return new ScheduleServicePage(driver, test);
	}
	
	
	
	
	
	public VehicleHealthPage verifyPreferreddealerSection() {
		verifyTextByXpathExplicitwait(prop.getProperty("VerifyServiceLocation.xpath"),"Benson Hyundai");
	return this;
	}
	public VehicleHealthPage scheduleServicePage() throws InterruptedException {
		Thread.sleep(10000);

		try {
		int size = driver.findElements(By.xpath("iframe")).size();
		System.out.println(size);
		
		}
		catch (Exception e) {
			// TODO: handle exception

			System.out.println(e);
		}
		
		Thread.sleep(4000);
enterByXpathExplict(prop.getProperty("enter.Scheduleservice.xpath"),"lksingh@mailnesia.com");
		clickByXpathExplict(prop.getProperty("search.scheduler.button.xpath"));
	
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}