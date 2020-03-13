package testcases;

import org.testng.annotations.Test;
import pages.ForgotPassword;
import wrappers.ProjectWrapp;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;

public class Tc0017_ForgotPassword_TemporaryPasswd extends ProjectWrapp{
  
  @BeforeClass(groups={"common"})
  public void setDatag() {
	  testCaseName="Forgot Password";
	  testDescription="Forgot_Password_Mail_Temporary_Password";
	  browserName="Chrome";
	  category="Smoke";
	  authors="MuthuMuniyandi";
	  dataSheetName="MyHTestData.xlsx";
	  testKeyword="Forgot_Password_Mail_Temporary_Password";
	}	
  
  @Test(groups={"sanity"},dataProvider="fetch")
  public void loginPositivecase(String Keyword, String Mailid, String SecQstn) throws InterruptedException, IOException, AWTException{
	  
	  driver.navigate().refresh();
	  Thread.sleep(4000);
	  new ForgotPassword(driver, test)
	  .clickForgotpassword()
	  .giveMailIDtoReset(Mailid)
	  .passwordresetSecurityQstn(SecQstn)
	  .passwordresetSendToMail()
	  .passwordresetMailTemporaryCodePswd()
	  .passwordresetChangePassword()
	  .clickLogout();
	  }
}
