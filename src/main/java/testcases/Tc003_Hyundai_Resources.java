package testcases;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyH_Homepage;
import wrappers.ProjectWrapp;
public class Tc003_Hyundai_Resources  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="MyH Hyundai Resources";
		testDescription="HighLevel - Hyundai resources page & article section has been validated";
		browserName="Chrome";
		category="Smoke";
		authors="Boopathi";	
		dataSheetName="MyHTestData.xlsx";
		testKeyword="Hyundai resources only HighLevel";

	}

	@Test(groups={"sanity"},dataProvider="fetch")
	public void hyundaiResources(String Keyword,String username,String Password,String Model,String trim) throws InterruptedException, IOException, AWTException{
new MyH_Homepage(driver, test)
.entercredentials(username,Password)
.clickhamburgermenu()
.clickhyundairesourcesSelectCategory()
.clickLeftMenu_technologyNvaigationCat()
.clickresultTabandSelectYear(Model,trim);
			}
}