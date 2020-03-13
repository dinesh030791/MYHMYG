package testcases;

import org.testng.annotations.Test;
import pages.ForgotPassword;
import wrappers.ProjectWrapp;
import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.BeforeClass;

public class Tc0018_ForgotPassword_VZ_VerificationCode extends ProjectWrapp{
  
  @BeforeClass(groups={"common"})
  public void setDatag() {
	  testCaseName="Forgot Password";
	  testDescription="Forgot_Password_Mail_VerficationCode_Password";
	  browserName="Chrome";
	  category="Smoke";
	  authors="MuthuMuniyandi";
	  dataSheetName="MyHTestData.xlsx";
	  testKeyword="Forgot_Password_Mail_VZ_VerficationCode_Password";
	}	
  
  @Test(groups={"sanity"},dataProvider="fetch")
  public void loginPositivecase(String Keyword, String username, String key, String opt1, String opt2) throws InterruptedException, IOException, AWTException{
	  
	  driver.navigate().refresh();
	  Thread.sleep(4000);
	  new ForgotPassword(driver, test)
	  .clickForgotpassword()
	  .giveMailIDtoReset(username)
	  .PswdVerificationCodePage(key, opt1, opt2)
	  .passwordresetMailTemporaryCodePswd()
	  .passwordresetChangePassword()
	  .clickLogout();
	  }
}
