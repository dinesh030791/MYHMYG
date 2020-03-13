package testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyH_Homepage;
import wrappers.ProjectWrapp;
public class Tc007_ScheduleService  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="Schedule Service ";
		testDescription="MyH Schedule Service ";
		browserName="Chrome";
		category="Smoke";
		dataSheetName="MyHTestData.xlsx";
		authors="Boopathi";		
		testKeyword="Schedule Service";

	}

	@Test(groups={"sanity"},dataProvider="fetch")
	public void scheduleservice(String Keyword,String Username,String Password) throws InterruptedException, IOException, AWTException{
new MyH_Homepage(driver, test)
.entercredentials(Username,Password)
.clickhamburgermenu()
.clickVehicleHealthMenu()
.clickScheduleButton()
.completeScheduleService();



			}
	

	
	
	
}