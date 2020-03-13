package pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class VehicleRegistrationPage extends ProjectWrapp{

	public  VehicleRegistrationPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		
		

	}

	public  VehicleRegistrationPage enterOdometer(String odometer) throws IOException, InterruptedException {
		
enterByXpathExplict(prop.getProperty("enterodometer.xpath"),odometer);
clickByXpathExplict(prop.getProperty("Vehicleregistration.form.xpath"));
Thread.sleep(1000);
		return this;
	}
	
	public  VehicleRegistrationPage PersonalInfoForm_VehicleRegForm(String Fname,String Lname,String Address,String City,String Postal,String Mobilenumber,String MobileType) throws IOException, InterruptedException {
		Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("edit.button.xpath"));
enterByXpathExplict(prop.getProperty("PersonalInfo.FirstName.xpath"),Fname);
		enterByXpathExplict(prop.getProperty("PersonalInfo.lastName.xpath"),Lname);
		enterByXpathExplict(prop.getProperty("addressline.first.xpath"),Address);
		enterByXpathExplict(prop.getProperty("newcity.xpath"),City);
		selectVisibileTextByXPath(prop.getProperty("state.dropdown.xpath"),Postal);
		enterByXpathExplict(prop.getProperty("Phone.number.xpath"),Mobilenumber);
		selectVisibileTextByXPath(prop.getProperty("phonetype.xpath"), MobileType);
		pageScroll400();
		pageScroll400();
		pageScroll400();
	return this;
	}
	
	public  EnrollBluelinkPage clickActivateButton() throws IOException, InterruptedException {
pageScroll400();
pageScroll400();
Thread.sleep(10000);

		clickByXpathExplict(prop.getProperty("yes.activate.xpath"));
	clickByXpathExplict(prop.getProperty("Activate.button.xpath"));

	return new EnrollBluelinkPage(driver, test);
	}
	
	public  MyH_Dashboardpage enrolLaterButton() throws IOException, InterruptedException {
		Thread.sleep(8000);

		clickByXpathExplict(prop.getProperty("EnrollLater.xpath"));
		clickByXpathExplict(prop.getProperty("Activate.button.xpath"));
		Thread.sleep(5000);
		
		return new MyH_Dashboardpage(driver, test);
		
	
	}
	
	
	
	
	
	
}
