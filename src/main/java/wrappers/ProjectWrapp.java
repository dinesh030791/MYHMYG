package wrappers;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.Dataproviders;

public class ProjectWrapp extends GenericWrappers{
	
	public String browserName;
	public String dataSheetName;

	@BeforeSuite(groups={"common"})
	public void beforeSuite() throws IOException{
		//del();

	startResult();
	}

	@BeforeTest(groups={"common"})
	public void beforeTest(){
		loadObjects();
	}
	//@Parameters("BrowserName")
	@BeforeMethod(groups={"common"})
	//public void beforeMethods(String BrowserName) throws IOException{
		public void beforeMethods() throws IOException{

//System.out.println(browserName);
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authors);
//		invokeApp(BrowserName);
		invokeApp("chrome");

	}
	@DataProvider(name="fetch")
	public Object[][] getDataExcel() throws IOException{
		return Dataproviders.geta("./data/"+dataSheetName,testKeyword);		
	}	
	
	
	
	@AfterSuite(groups={"common"})
	public void afterSuite() throws Exception{

		endResult();
	
	
	}

	@AfterTest(groups={"common"})
	public void afterTest(){
		unloadObjects();
	}
	
	@AfterMethod(groups={"common"})
	public void afterMethod(){
		endTestcase();
	closeAllBrowsers();		
	}
	
	

	
	}