package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pages.MyH_Homepage;
import wrappers.ProjectWrapp;

public class Tc002_NegativeLogincase  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="MyH Login -Invalid Credential";
		testDescription="Login in MyH Using Invalid UserName/Password";
		browserName="Chrome";
		category="Smoke";
		authors="Boopathi";
		dataSheetName="MyHTestData.xlsx";
		testKeyword="Login Negative Case";

	}

	@Test(groups={"sanity"},dataProvider="fetch")
	public void loginNegativeCase(String Keyword,String username,String Password,String ValMsg) throws InterruptedException, IOException, AWTException{
Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.navigate().refresh();
new MyH_Homepage(driver, test)
.enterinvalidcredentials(username, Password, ValMsg);

}
}