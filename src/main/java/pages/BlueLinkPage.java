package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;
import wrappers.ProjectWrapp;

public class BlueLinkPage extends ProjectWrapp{
	
	public BlueLinkPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	static WebDriverWait wait;
	
	public BlueLinkPage clickBluelinkToAlert(String Zip, String place, String Radius, String GeoFenName, String alertURL1, String alertURL2)
	{
		try {
			Thread.sleep(3000);
			WebElement clickBlueLink = driver.findElement(By.xpath(".//*[@id='all_details']/div[1]/a[3]"));
			clickBlueLink.click();
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Refresh")));
			Thread.sleep(3000);
			
			String VIN_Valu = driver.findElement(By.id("vinno")).getText();
			String[] VIN_ValSplit = VIN_Valu.split("VIN: ");
			String VIN_Val = VIN_ValSplit[1].trim();
			
			System.out.println("VIN No: "+VIN_Val);
			
			driver.findElement(By.linkText("Safeguard alerts")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='safeguard-alerts']/div/div[1]/div[1]/div/a")).click();
			
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gf_pac_input")));
			Thread.sleep(2000);
			
			WebElement enterZipCode = driver.findElement(By.id("gf_pac_input"));
			enterZipCode.sendKeys(Zip);
			
			List<WebElement> listofplaces = driver.findElements(By.xpath(".//*[@id='searchlist_box']/div/div"));
			listofplaces.size();
			
			for(WebElement list : listofplaces)
			{
				System.out.println(list.getText());
				if(list.getText().equalsIgnoreCase(place))
				{
					driver.findElement(By.id("search-location")).click();
					Thread.sleep(2000);
					break;
				}
			}
			
			driver.findElement(By.id("gftxt_radius")).sendKeys(Radius);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='geoFenceForm']/div/div[3]/div[3]/label")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='geoFenceForm']/div/div[4]/div[2]/label")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("gftxt_geofence_name")).sendKeys(GeoFenName);
			Thread.sleep(2000);
			driver.findElement(By.id("submit_geofence")).click();
			Thread.sleep(2000);
			
			String GetTID_MDN = GenericWrappers.TIDQuery(VIN_Val);
			String[] splitTID_MDN = GetTID_MDN.split(",");
			String TID = splitTID_MDN[0].trim();
			String MDN = splitTID_MDN[1].trim();
			getMethod_Alerts(VIN_Val, TID, MDN, alertURL1);
			Thread.sleep(10000);
			getMethod1_Alerts(VIN_Val, TID, MDN, alertURL2);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return this;
	}
	
	public BlueLinkPage clickBluelinkToSpdAlert(String SpeedLimit, String alertURL1, String alertURL2)
	{
		try {
			Thread.sleep(3000);
			WebElement clickBlueLink = driver.findElement(By.xpath(".//*[@id='all_details']/div[1]/a[3]"));
			clickBlueLink.click();
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Refresh")));
			Thread.sleep(3000);
			
			String VIN_Valu = driver.findElement(By.id("vinno")).getText();
			String[] VIN_ValSplit = VIN_Valu.split("VIN: ");
			String VIN_Val = VIN_ValSplit[1].trim();
			
			System.out.println("VIN No: "+VIN_Val);
			
			driver.findElement(By.linkText("Safeguard alerts")).click();
			Thread.sleep(2000);
			WebElement elemAlert;
			String AlertOn_Off = null;
			
			for(int i=1;i<=2;i++)
			{
				elemAlert =  driver.findElement(By.xpath(".//*[@id='safeguard-alerts']/div/div/div[3]/div["+i+"]/a"));//Set alert
				AlertOn_Off = elemAlert.getText();
				if(AlertOn_Off!=null)
				{
					elemAlert.click();
					break;
				}
				
			}
			
			if(AlertOn_Off.equalsIgnoreCase("Manage Alert"))
			{
				wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit alert")));
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(".//*[@id='set-speed-alert']/div/div/div[3]/div[1]/div[2]/div/label")).click();
				Thread.sleep(8000);
				
				String GetTID_MDN = GenericWrappers.TIDQuery(VIN_Val);
				String[] splitTID_MDN = GetTID_MDN.split(",");
				String TID = splitTID_MDN[0].trim();
				String MDN = splitTID_MDN[1].trim();
				getMethod_Alerts(VIN_Val, TID, MDN, "/dla/aos");
				Thread.sleep(7000);
				getMethod1_Alerts(VIN_Val, TID, MDN, "/dla/asr");				
			}
			else 
			{
				wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='speed-alert']/div/div/div[3]/div[1]/div[3]/button")));
				Thread.sleep(2000);
				
				driver.findElement(By.id("speed-arrow")).click();
				Thread.sleep(2000);
				
				List<WebElement> spdLimitList = driver.findElements(By.xpath(".//*[@id='speed-alert']/div/div/div[3]/div[1]/div[2]/div/div[2]/div/ul/li/a"));
				spdLimitList.size();
				
				for(WebElement list: spdLimitList)
				{
					if(list.getText().equalsIgnoreCase(SpeedLimit))
					{
						list.click();
						Thread.sleep(2000);
						break;
					}
				}
				
				driver.findElement(By.xpath(".//*[@id='speed-alert']/div/div/div[3]/div[1]/div[3]/button")).click();
				Thread.sleep(7000);
				
				String GetTID_MDN = GenericWrappers.TIDQuery(VIN_Val);
				String[] splitTID_MDN = GetTID_MDN.split(",");
				String TID = splitTID_MDN[0].trim();
				String MDN = splitTID_MDN[1].trim();
				getMethod_Alerts(VIN_Val, TID, MDN, alertURL1);
				Thread.sleep(10000);
				getMethod1_Alerts(VIN_Val, TID, MDN, alertURL2);
				
			}
					
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}

}
