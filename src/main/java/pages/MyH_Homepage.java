package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import freemarker.template.utility.Execute;

import wrappers.ProjectWrapp;

public class MyH_Homepage extends ProjectWrapp{
	public  MyH_Homepage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		
		//if(!verifyTitlecontains("Dashboard | MyHyundai")){
	//		reportStep("This is not Dashboard | MyHyundai", "FAIL");
			//	}

	}

	public  MyH_Dashboardpage entercredentials(String uname,String pwd) throws IOException, InterruptedException {
		Thread.sleep(6000);
		pageRefresh();
		
		enterByXpathExplict(prop.getProperty("enterusername.xpath"),uname);
enterByXpathExplict(prop.getProperty("enterpwd.xpath"), pwd);
clickByXpathExplict(prop.getProperty("loginbutton.xpath"));
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Dashboard.customize.link.xpath"))));
Thread.sleep(8000);
		return new MyH_Dashboardpage(driver, test);
	}
	public  Welcomepage credentialwelcomepage(String uname,String pwd) throws IOException, InterruptedException {
		Thread.sleep(10000);
		pageRefresh();
		
		enterByXpathExplict(prop.getProperty("enterusername.xpath"),uname);
enterByXpathExplict(prop.getProperty("enterpwd.xpath"), pwd);
clickByXpathExplict(prop.getProperty("loginbutton.xpath"));
Thread.sleep(6000);


		return new Welcomepage(driver, test);
	}

	public  MyH_Homepage enterinvalidcredentials(String uname,String pwd,String Valmsg) throws IOException, InterruptedException {
		Thread.sleep(6000);
		pageRefresh();
		enterByXpathExplict(prop.getProperty("enterusername.xpath"),uname);
enterByXpathExplict(prop.getProperty("enterpwd.xpath"), pwd);
clickByXpathExplict(prop.getProperty("loginbutton.xpath"));
Thread.sleep(6000);
verifyTextContainsByXpath(prop.getProperty("invalidlogin.xpath"),"You have entered an incorrect username or password");
		return this;
	}
public MyH_Dashboardpage WelcomToMyH_Login(String uname,String pwd) throws IOException, InterruptedException {
		Thread.sleep(2000);
		pageRefresh();
		Thread.sleep(2000);
		clickById(prop.getProperty("Homepage.WelcmMySignin.Bttn.id"));
		Thread.sleep(2000);
		enterByXpathExplict(prop.getProperty("enterusername.xpath"),uname);
		enterByXpathExplict(prop.getProperty("enterpwd.xpath"), pwd);
		clickByXpathExplict(prop.getProperty("loginbutton.xpath"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Dashboard.customize.link.xpath"))));
		Thread.sleep(8000);
		return new MyH_Dashboardpage(driver, test);
	}
	
	public MyH_Dashboardpage HamburgrMenuMyH_Login(String uname,String pwd) throws IOException, InterruptedException {
		Thread.sleep(2000);
		pageRefresh();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("click.hamburgermenu.xpath"));
		Thread.sleep(2000);
		enterById(prop.getProperty("enterusername.hambrgrmenu.id"),uname);
		enterById(prop.getProperty("enterpwd.hambrgrmenu.id"), pwd);
		clickById(prop.getProperty("loginbutton.hambrgrmenu.id"));
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Dashboard.customize.link.xpath"))));
		Thread.sleep(8000);
		return new MyH_Dashboardpage(driver, test);
	}
	
	public MyH_Dashboardpage ResourcesPage_Login(String uname,String pwd) throws IOException, InterruptedException {
		Thread.sleep(6000);
		pageRefresh();
		ScrollclickByXpath(prop.getProperty("homepage.resourcepage.xpath"));
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("resourcepage.loginbutton.id"))));
		clickById(prop.getProperty("resourcepage.loginbutton.id"));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("loginbutton.xpath"))));
		Thread.sleep(3000);
		enterByXpathExplict(prop.getProperty("enterusername.xpath"),uname);
		enterByXpathExplict(prop.getProperty("enterpwd.xpath"), pwd);
		clickByXpathExplict(prop.getProperty("loginbutton.xpath"));
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("click.hamburgermenu.xpath"))));
		Thread.sleep(8000);
		return new MyH_Dashboardpage(driver, test);
	}

	
}
