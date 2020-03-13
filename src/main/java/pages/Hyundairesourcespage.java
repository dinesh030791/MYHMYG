package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.ProjectWrapp;
public class Hyundairesourcespage extends ProjectWrapp{
	public  Hyundairesourcespage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
}

public Hyundairesourcespage clickLeftMenu_technologyNvaigationCat() {
	clickByXpathExplict(prop.getProperty("clickTechNavigationCat.xpath"));

return this;
}
public Hyundairesourcespage clickresultTabandSelectYear(String Model,String trim) throws InterruptedException {
	Thread.sleep(4000);
	clickByXpathExplict(prop.getProperty("click.allvehicleresultTab.xpath"));
selectVisibileTextByXPath(prop.getProperty("Resources.year.dropdown"),"2017");
selectVisibileTextByXPath(prop.getProperty("Resources.model.dropdown"),Model);
//selectVisibileTextByXPath(prop.getProperty("Resources.model.dropdown"),"elantra");
selectVisibileTextByXPath(prop.getProperty("Resources.trim.xpath"),trim);
Thread.sleep(6000);
List<WebElement> catnamelist= listele(prop.getProperty("category.result.xpath"));
for (WebElement webElement : catnamelist) {
	System.out.println(webElement.getText());
}
int CatSize=catnamelist.size();
String headertext=ReturnXpathtext(prop.getProperty("HyundaiResourcesHeaderName.xpath"));
System.out.println(CatSize+"headercategory+ has been displaying");

if(catnamelist!=null) {
		//validationMessage(true,headertext+ "category articles has been displaying" ,headertext+ "category articles has not been displaying");
validationMessage(true,headertext+ "category articles has been displaying" );
}
else {
	validationMessage(false,headertext+ "category articles has not been displaying" );
}
Thread.sleep(6000);
List<WebElement>catArticlelist=listele(prop.getProperty("click.hyundairesources.result.xpath"));
for (int i = 1; i <catArticlelist.size(); i++) {
	String categoryname=catArticlelist.get(i).getText();
	String hrefattribute=catArticlelist.get(i).getAttribute("href");
	if(!hrefattribute.contains("#")) {
		clickByXpathExplict(".//div[@class='click-list']//li//a["+i+"]");
			break;
	}
	Thread.sleep(4000);
}
VerifyElementPresent(prop.getProperty("article.title.xpath"),"Articles page has been displaying", "Articles page has not been displaying");

VerifyElementcheck(prop.getProperty("Articles.banner.image.xpath"),"Articles page Banner has been displaying", "Articles page Banner has not been displaying");
Thread.sleep(10000);
return this;
}



}