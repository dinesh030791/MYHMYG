package pages;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CcadminPages  extends ProjectWrapp{
	public  CcadminPages(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	//if(!verifyTitlecontains("Vehicle Health | MyHyundai ")){
	//	reportStep("This is not Vehicle Health | MyHyundai ", "FAIL");
		//	}
	}
	
	
	
	public  CcadminPages getccUrl() throws InterruptedException {
		
		
		geturl("https://stg.cc.blui.hyundaiusa.com/");
		selectVisibileTextByXPath(prop.getProperty("SelectType.ccadmin.xpath"),"HAEA/ADMIN");
clickByXpathExplict(prop.getProperty("ccAdmin.go.xpath"));
	
//clickByXpathExplict(prop.getProperty("ccAdmin.cancel.button.xpath"));


String uname="HKE";
String sym="\"";
String ID="HIS60848";	
	
String CCADMINID=uname+sym+ID;  
System.out.println(CCADMINID);
	enterByXpathExplict(prop.getProperty("ccAdminUsername.xpath"),CCADMINID);
	enterByXpathExplict(prop.getProperty("ccAdminUserpwd.xpath"),"kawaXX0109");
	
	clickByXpathExplict(prop.getProperty("ccAdminUsersign.button.xpath"));
	
	
Thread.sleep(10000);
	
	enterByXpathExplict(prop.getProperty("Enter.VIN.xpath"),"KM8J74A62KT308388");
	
	clickByXpathExplict(prop.getProperty("button.search.xpath"));
	
	

		
		return this;
		
	}
	
	
	

}
