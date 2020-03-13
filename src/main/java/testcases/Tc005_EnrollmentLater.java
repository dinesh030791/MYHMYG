package testcases;
import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyH_Homepage;
import wrappers.ProjectWrapp;
public class Tc005_EnrollmentLater  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="Enroll Later in Vehicle Registration Page";
		testDescription="MyH Enrollment Later Scenario";
		browserName="Chrome";
		category="Smoke";
		dataSheetName="MyHTestData.xlsx";
		authors="Boopathi";		
		testKeyword="Enrollment Later";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void enrollmentLater(String Keyword,String username,String Password,String VIN,String odometer,String Fname,String Lname,String Address,String City,String Postal,String Mobilenumber,String MobileType,String PIN,String pckgstatus1) throws InterruptedException, IOException, AWTException{
new MyH_Homepage(driver, test)
.credentialwelcomepage(username,Password)
.ClickAddVehicleButtonAndEnterVIN(VIN)
.enterOdometer(odometer)
.PersonalInfoForm_VehicleRegForm(Fname,Lname,Address,City,Postal,Mobilenumber,MobileType)
.enrolLaterButton()
.blueLinkEnrolStatusVerify(pckgstatus1);
		}
}