package testcases;

import org.testng.annotations.Test;
import pages.MyH_Homepage;
import wrappers.ProjectWrapp;
import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.BeforeClass;

public class Tc0013_LoginPage_FromAll_Pages extends ProjectWrapp{
  
  @BeforeClass(groups={"common"})
  public void setDatag() {
	  testCaseName="Login Page";
	  testDescription="Login Page from All Source";
	  browserName="Chrome";
	  category="Smoke";
	  authors="MuthuMuniyandi";
	  dataSheetName="MyHTestData.xlsx";
	  testKeyword="Login Page from All Source";
	}	
  
  @Test(groups={"sanity"},dataProvider="fetch")
  public void loginPositivecase(String Keyword, String username, String Passwrd, String pagetitle, String errormsg, String pageRsrctitle, String rsrcerrormsg) throws InterruptedException, IOException, AWTException{
	  
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  new MyH_Homepage(driver, test)
	  .entercredentials(username, Passwrd)
	  .verifyPageTitle(pagetitle, errormsg)
	  .clickLogout()
	  .WelcomToMyH_Login(username, Passwrd)
	  .verifyPageTitle(pagetitle, errormsg)
	  .clickLogout()
	  .HamburgrMenuMyH_Login(username, Passwrd)
	  .verifyPageTitle(pagetitle, errormsg)
//	  .clickLogout()
//	  .ResourcesPage_Login(username, Passwrd)
//	  .verifyPageTitle(pageRsrctitle, rsrcerrormsg)
	  .clickLogout();
	  }
}