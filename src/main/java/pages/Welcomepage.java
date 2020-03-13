package pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Welcomepage extends ProjectWrapp{
	public  Welcomepage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	//if(!verifyTitlecontains("Saved Builds Dashboard")){
		//reportStep("This is not  Saved Builds Dashboard | MyHyundai", "FAIL");
		//	}
	}
	
	public  VehicleRegistrationPage ClickAddVehicleButtonAndEnterVIN(String VIN) throws IOException, InterruptedException {
		Thread.sleep(10000);
		pageRefresh();
		Thread.sleep(5000);
clickByXpathExplict(prop.getProperty("AddaVehicle.button.xpath"));
enterByXpathExplict(prop.getProperty("EnterVin.xpath"), VIN);
clickByXpathExplict(prop.getProperty("click.VIN.submit.xpath"));

Thread.sleep(6000);
		return new VehicleRegistrationPage(driver, test);
	}
	
	
	
	

}