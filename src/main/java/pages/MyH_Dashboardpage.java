package pages;

import java.io.IOException;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;
import wrappers.ProjectWrapp;

public class MyH_Dashboardpage extends ProjectWrapp{
	public  MyH_Dashboardpage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	
}
	
	
	public MyH_Dashboardpage verifyPageTitle(String pagetitle,String error) throws InterruptedException {
		pagetitle(pagetitle,error);
	
//	if(!verifyTitlecontains("Dashboard | MyHyundai")){
//		reportStep("This is not Dashboard | MyHyundai", "FAIL");
//	
//	}
	return this;
	}


public MyH_Dashboardpage clickhamburgermenu() throws InterruptedException {
	Thread.sleep(6000);
	pageRefresh();
	Thread.sleep(10000);

	clickByXpathExplict(prop.getProperty("click.hamburgermenu.xpath"));
return this;
}





		public ManagesubscriptionPage clicksubscriptionLink() throws InterruptedException {
	
			Thread.sleep(10000);
			pageRefresh();
	pageScroll400();
	Thread.sleep(2000);
	
	clickByXpathExplict(prop.getProperty("Managesubscription.xpath"));
	Thread.sleep(20000);
	pageScroll400();
return new ManagesubscriptionPage(driver, test);

}	
		

public MyH_Dashboardpage blueLinkEnrolStatusVerify(String status) throws InterruptedException {
	Thread.sleep(20000);
	//pageRefresh();
	verifyTextContainsByXpath(prop.getProperty("BlueLink.Active.Status.xpath"),status);
//	verifyTextContainsByXpath(prop.getProperty("status.dashboard.xpath"),packageActiveStatus);
	//Thread.sleep(20000);

return this;

}




	

public Hyundairesourcespage clickhyundairesourcesSelectCategory() throws InterruptedException {
	Thread.sleep(4000);
	clickByXpathExplict(prop.getProperty("clickHyundaiResourcesMnenu.xpath"));
	Thread.sleep(4000);

	clickByXpathExplict(prop.getProperty("clickgetstartedcategory.xpath"));

return new Hyundairesourcespage(driver, test);
}
	


public VehicleHealthPage clickVehicleHealthMenu() {
	clickByXpathExplict(prop.getProperty("vehiclehealth.xpath"));
return new VehicleHealthPage(driver, test);

}


public BlueLinkPage clickonHamburger()
	{
		try {
			/*WebElement clickHamburgerMenu = driver.findElement(By.xpath(prop.getProperty("click.hamburgermenu.xpath")));
			clickHamburgerMenu.click();*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new BlueLinkPage(driver, test);
		
	}

	public MyH_Dashboardpage selectCarModel(String carModelName)
	{
		try {
			String test = prop.getProperty("click.hamburgermenu.xpath");
			WebElement clickHamburgerMenu = driver.findElement(By.xpath(test));
			clickHamburgerMenu.click();
						
			Thread.sleep(2000);
			WebElement CurrntCarModel = driver.findElement(By.xpath(prop.getProperty("HamburgerMenu.CurrentVehicleName.xpath")));//opt_veh
			String ModelName = CurrntCarModel.getText();
						
			try {
				System.out.println("Current Car Model: "+ModelName);
				CurrntCarModel.click();
			} catch (Exception e) {
				driver.findElement(By.xpath("//*[@class='select-box-arrow arrow_align']")).click();
			}
			
			Thread.sleep(2000);
			try {
				List<WebElement> VehiclList = driver.findElements(By.xpath(".//*[@id='owned_vehicles']/div/div/div/div/span"));
				int no_of_Vehicles = VehiclList.size();
				if(no_of_Vehicles<=1)
				{
					System.out.println("Only "+no_of_Vehicles+" Vehicle Available. So Default Vehicle selected!...");
					driver.findElement(By.xpath("//*[@class='select-box-arrow arrow_align rotate_arrow']")).click();
				}else {
					System.out.println("Listed Vehicles below: ");
					for(int k=0;k<=no_of_Vehicles-1;k++)
					{
						System.out.println(k+1+". "+VehiclList.get(k).getText().trim());
						if(VehiclList.get(k).getText().trim().equalsIgnoreCase(carModelName.trim()))
						{
							int f = k+1;
							driver.findElement(By.xpath(".//*[@id='owned_vehicles']/div/div["+f+"]/div/input")).click();
							Thread.sleep(8000);
							WebDriverWait wait = new WebDriverWait(driver,30);
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Dashboard.customize.link.xpath"))));
							break;
						}
					}
				}				
		  } catch (Exception e) {
			  System.out.println("Vehicles NOT available!..");
		  }
			  
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		  
		return this;
	
	}
	
	static String VIN_Val;
	public MyH_Dashboardpage selectRemoteActions()
	{
		try {
			String VIN = driver.findElement(By.xpath(".//*[@class='vinsp']")).getText();
			  String [] VIN_Splt = VIN.split("VIN #: ");
			  VIN_Val = VIN_Splt[1].trim();
			  System.out.println("VIN No: "+VIN_Val);
			  
			  driver.findElement(By.xpath(prop.getProperty("Dashboard.customize.link.xpath"))).click();
			  Thread.sleep(5000);
			  
			  List<WebElement> customzQckLinks_list = driver.findElements(By.xpath(prop.getProperty("CustomizeLink.RemoteActionsList.xpath")));
			  int cusQckLnkCount = customzQckLinks_list.size();
			  System.out.println("Total Customize Link Count: "+cusQckLnkCount);
			  
			  for(int i=1;i<=cusQckLnkCount;i++)
			  {
				  try {
					  WebElement elemList = driver.findElement(By.xpath(".//*[@id='quick_links_customization']/div/div/div[2]/div["+i+"]"));
					  if(elemList.getAttribute("class").contains("row"))
					  {
						  String clsNamid = elemList.getAttribute("class");
						  List<WebElement> srvcList = driver.findElements(By.xpath(".//*[@class='"+clsNamid+"']/div/p"));
						  
						  for(int j=1;j<=srvcList.size();j++)
						  {
							  //String remoteActions = driver.findElement(By.xpath(".//*[@class='"+clsNamid+"']/div["+j+"]/p")).getText();
							  //System.out.println(j+". "+remoteActions);
							  if(driver.findElement(By.xpath(".//*[@class='"+clsNamid+"']/div["+j+"]/label")).getAttribute("class").equalsIgnoreCase("checkbox-custom checked"))
							  {
								  driver.findElement(By.xpath(".//*[@class='"+clsNamid+"']/div["+j+"]/label/input")).click();							  
							  }
							  
						  }
					  }
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}
			  }
			  
			  for(int i=1;i<=cusQckLnkCount;i++)
			  {
				  try {
					  WebElement elemList = driver.findElement(By.xpath(".//*[@id='quick_links_customization']/div/div/div[2]/div["+i+"]"));
					  if(elemList.getAttribute("class").contains("row"))
					  {
						  String clsNamid = elemList.getAttribute("class");
						  List<WebElement> srvcList = driver.findElements(By.xpath(".//*[@class='"+clsNamid+"']/div/p"));
						  
						  for(int j=1;j<=srvcList.size();j++)
						  {
							  String remoteActions = driver.findElement(By.xpath(".//*[@class='"+clsNamid+"']/div["+j+"]/p")).getText();
							  //System.out.println(j+". "+remoteActions);
							  if(remoteActions.equalsIgnoreCase("Climate Start")||remoteActions.equalsIgnoreCase("Climate Stop")||
									  remoteActions.equalsIgnoreCase("Lock Doors")||remoteActions.equalsIgnoreCase("Unlock Doors")||
									  	remoteActions.equalsIgnoreCase("Remote Start")||remoteActions.equalsIgnoreCase("Remote Stop") ||
									  		remoteActions.equalsIgnoreCase("Horn & Lights")||remoteActions.equalsIgnoreCase("Flash Lights"))
							  {
								  driver.findElement(By.xpath(".//*[@class='"+clsNamid+"']/div["+j+"]/label/input")).click();							  
							  }
							  
						  }
					  }
				  	} catch (Exception e) {
				  		System.out.println(e.getMessage());
				  		break;
				  	}
			  }
			  
			  Thread.sleep(2000);
			  WebElement QckLink_Finsh_btn = driver.findElement(By.xpath(prop.getProperty("CustomizeLink.Finish.Button.xpath")));
			  QckLink_Finsh_btn.click();
			  WebDriverWait wait = new WebDriverWait(driver, 120);
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='container-fluid']/div/div[7]/div[2]/div/div[1]/div[2]/a")));
			  Thread.sleep(8000);
			  
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	static String ackMsg = null;
	public MyH_Dashboardpage performRemoteActions()
	{
		try {
			for(int z=1;z<=4;z++)
			{
			  //key = "CLIMATE START"; 
			  
			  switch (z) {//(key.toUpperCase()) {
			  case 1://"REMOTE START":
			  //case "CLIMATE START":
				  driver.findElement(By.xpath(".//*[@class='remote-climate-control-start qLink_show']")).click();
				  Thread.sleep(4000);		  		  
				  driver.findElement(By.xpath("//*[@id='modal1_ev_car']/div/div/div[4]/div/input")).click();		  
				  driver.findElement(By.xpath("//*[@id='modal1_ev_car']/div/div/div[4]/div/input")).sendKeys("1234");
				  Thread.sleep(3000);		 
				  WebElement elemActnEnter = driver.findElement(By.xpath("//*[@id='modal1_ev_car']/div/div/div[4]/div/button"));		  
				  System.out.println("CLASS VALUE: "+elemActnEnter.getAttribute("class"));		  
				  elemActnEnter.click();
				  /* try 
				  {
					  JavascriptExecutor jse = (JavascriptExecutor)driver;
					  jse.executeScript("arguments[0].click();", elemActnEnter);
				  }
				  catch (Exception e) {
					System.out.println(e.getMessage());
				  }		  
				  new Actions(driver).moveToElement(elemActnEnter).click().perform();*/
				  Thread.sleep(8000);
				  ackMsg = driver.findElement(By.xpath("//*[@id='csmodal1']/div/div/div[3]/div/div/div[2]")).getText();
				  break;
				
			  case 2://"REMOTE STOP":
			  //case "CLIMATE STOP":
				  driver.findElement(By.xpath(".//*[@class='remote-climate-control-stop qLink_show']")).click();
				  Thread.sleep(4000);		  		  
				  driver.findElement(By.xpath("//*[@id='modal2_stop_ev_car']/div/div/div[3]/div/div[2]/input")).click();		  
				  driver.findElement(By.xpath("//*[@id='modal2_stop_ev_car']/div/div/div[3]/div/div[2]/input")).sendKeys("1234");
				  Thread.sleep(3000);		 
				  WebElement elemActnRmtStop = driver.findElement(By.xpath("//*[@id='modal2_stop_ev_car']/div/div/div[3]/div/div[3]/button"));
				  elemActnRmtStop.click();
				  Thread.sleep(8000);
				  ackMsg = driver.findElement(By.xpath("//*[@id='csmodal2']/div/div/div[3]/div/div/div[2]")).getText();
				  break;
					
			  case 3://"LOCK DOORS":
				  driver.findElement(By.xpath(".//*[@class='door-lock qLink_show']")).click();
				  Thread.sleep(4000);		  		  
				  driver.findElement(By.xpath("/html/body/div[63]/div[2]/div/div/div[3]/div[1]/div[2]/input")).click();		  
				  driver.findElement(By.xpath("/html/body/div[63]/div[2]/div/div/div[3]/div[1]/div[2]/input")).sendKeys("1234");
				  Thread.sleep(3000);		 
				  WebElement elemActnEn = driver.findElement(By.xpath("//*[@id='modal3']/div/div/div[3]/div/div[3]/button"));		  
				  //System.out.println("CLASS VALUE: "+elemActnEn.getAttribute("class"));  
				  elemActnEn.click();
				  Thread.sleep(8000);
				  ackMsg = driver.findElement(By.xpath("//*[@id='rsmodal3']/div/div/div[3]/div/div/div[2]")).getText();
				  break;
					
			  case 4://"UNLOCK DOORS":
				  driver.findElement(By.xpath(".//*[@class='door-unlock qLink_show']")).click();
				  Thread.sleep(4000);		  		  
				  driver.findElement(By.xpath("/html/body/div[90]/div[2]/div/div/div[3]/div[1]/div[2]/input")).click();		  
				  driver.findElement(By.xpath("/html/body/div[90]/div[2]/div/div/div[3]/div[1]/div[2]/input")).sendKeys("1234");
				  Thread.sleep(3000);		 
				  WebElement elemActnE = driver.findElement(By.xpath("//*[@id='modal3_gen1_car']/div/div/div[3]/div/div[3]/button"));		  
				  //System.out.println("CLASS VALUE: "+elemActnEn.getAttribute("class"));  
				  elemActnE.click();
				  Thread.sleep(8000);
				  ackMsg = driver.findElement(By.xpath("//*[@id='rsmodal4']/div/div/div[3]/div/div/div[2]")).getText();
				  break;

			  default:
				  System.out.println("Mention Any Remote Actions...");
				  
				break;
			  }
			  
			  
			  //String ackMsg = driver.findElement(By.xpath("//*[@id='csmodal1']/div/div/div[3]/div/div/div[2]")).getText();
			  String ErroRackMsg = "Test Some Unable to retrieve some account information. Please try again later.";
			  String PayloadFileName = null;
			  
			  if(ackMsg.equalsIgnoreCase(ErroRackMsg))
			  {
				  System.out.println("Kindly Check your VBR information. "+ErroRackMsg);
			  }
			  else
			  {
				  String GetTID_MDN = GenericWrappers.TIDQuery(VIN_Val);
				  String[] splitTID_MDN = GetTID_MDN.split(",");
				  String TID = splitTID_MDN[0].trim();
				  String MDN = splitTID_MDN[1].trim();
				  GenericWrappers.getMethod(VIN_Val, TID, MDN);
				  if(z==1)
				  {
					  PayloadFileName = "RSC_RemoteStartClimate";
					  GenericWrappers.postMethodwithPayload(VIN_Val, TID, MDN, PayloadFileName);
				  }
				  else if(z==2)
				  {
					  PayloadFileName = "RSC_RemoteStopClimate";
					  GenericWrappers.postMethodwithPayload(VIN_Val, TID, MDN, PayloadFileName);
				  }
				  else if(z==3)
				  {
					  PayloadFileName = "RDO_LockDoors";
					  GenericWrappers.postMethodwithPayload(VIN_Val, TID, MDN, PayloadFileName);
				  }
				  else if(z==4)
				  {
					  PayloadFileName = "RDO_UnLockDoors";
					  GenericWrappers.postMethodwithPayload(VIN_Val, TID, MDN, PayloadFileName);
				  }
				  else
				  {
					  System.out.println("Option NOT available !...");
				  }
			}
			  Thread.sleep(45000);
			  }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	public MyH_Homepage clickLogout()
	{
		try {
			Thread.sleep(3000);
			 driver.findElement(By.xpath(prop.getProperty("click.hamburgermenu.xpath"))).click();
			  Thread.sleep(1000);
			  driver.findElement(By.linkText("Log out")).click();
			  WebDriverWait wait = new WebDriverWait(driver, 60);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			  Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new MyH_Homepage(driver, test);
	}

}