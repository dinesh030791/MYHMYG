package testcases;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyH_Homepage;
import wrappers.ProjectWrapp;
public class Tc004_Enrollment  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="Enrollment  and  Cancel Subscription";
		testDescription="Perform Enrollment in Prospect Account and cancelled subscripiton";
		browserName="Chrome";
		category="Smoke";
		dataSheetName="MyHTestData.xlsx";
		authors="Boopathi";		
		testKeyword="Enrollement and Cancel Subscriptions";
	}

	@Test(groups={"sanity"},dataProvider="fetch")
	public void enrollmentCancel(String Keyword,String username,String Password,String VIN,String odometer,String Fname,String Lname,String Address,String City,String Postal,String Mobilenumber,String MobileType,String PIN,String pckgstatus1,String Pckgstatus2) throws InterruptedException, IOException, AWTException{
new MyH_Homepage(driver, test)
.credentialwelcomepage(username,Password)
.ClickAddVehicleButtonAndEnterVIN(VIN)
.enterOdometer(odometer)
.PersonalInfoForm_VehicleRegForm(Fname,Lname,Address,City,Postal,Mobilenumber,MobileType)
.clickActivateButton()
.createPIN(PIN)
.selectPackages()
.verifyorder()
.blueLinkEnrolStatusVerify(pckgstatus1)
.clicksubscriptionLink()
.performCancelssubscription()
.blueLinkEnrolStatusVerify(Pckgstatus2);
		}
}