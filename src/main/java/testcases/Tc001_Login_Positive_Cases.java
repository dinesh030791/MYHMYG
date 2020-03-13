package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pages.MyH_Homepage;
import wrappers.ProjectWrapp;

public class Tc001_Login_Positive_Cases  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="MyH Login -Valid Credential";
		testDescription="Login in MyH Using valid UserName/Password";
		browserName="Chrome";
		category="Smoke";
		authors="Boopathi";
		dataSheetName="MyHTestData.xlsx";
		testKeyword="Login Positive Case";
		

	}
		
		
		

	@Test(groups={"sanity"},dataProvider="fetch")
	public void loginPositivecase(String Keyword,String username,String Password,String title ,String ErrorMsg) throws InterruptedException, IOException, AWTException{
Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.navigate().refresh();
new MyH_Homepage(driver, test)
.entercredentials(username,Password)
.verifyPageTitle(title,ErrorMsg);


	}
}