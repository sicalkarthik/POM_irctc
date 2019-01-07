package wrappers;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import pom.irctc.utils.Reporting;

public class GenericWrappers extends Reporting implements Wrappers 
{
		public String surl;	
		public GenericWrappers(){	
		Properties configprop = new Properties();
		try {
			//File fil=new File("./src/test/java/config.properties");
			//FileInputStream fis=new FileInputStream("./src/test/java/config.properties");
			//configprop.load(fis);
			configprop.load(new FileInputStream("./src/test/java/config.properties"));
			surl =  configprop.getProperty("URL");	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static Properties prop;//should not become null thruout the execution so making as static
	public void loadObjects(){
		prop=new Properties();
		try {
			prop.load(new FileInputStream("./src/test/java/object.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public RemoteWebDriver driver;
	public void invokeApp(String browser, String url) 
	{
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_64bit.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Internetexplorer"))	{
				System.setProperty("webdriver.internetexplorer.driver", "");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			reportStep("The "+browser+" browser got launched and loaded the given URL "+url, "Pass");	
		} 
		catch (WebDriverException e) { reportStep("Sorry, The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}
	
	public void webTable(String tag,String XPath)
	{
		try {
			WebElement we=driver.findElementByTagName(tag);
			we.findElement(By.xpath(XPath)).click();
			reportStep("The Element got clicked with xpath "+XPath,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void mouseHover(String...XPath)
	{
		try {
			Actions a=new Actions(driver);
			for(String each:XPath)
			{
				a=a.moveToElement(driver.findElementByXPath(each));			
			}
			a.click().perform();
			reportStep("The mouse pointer is focused over the webelement with the XPATH: '" + XPath + "' successfully.","Pass");
		} 
		catch (NoSuchElementException e) {
			reportStep("The webelement with the XPATH: '" + XPath + "' is not found.","Fail");
		} catch (ElementNotVisibleException e) {
			reportStep("The webelement with the XPATH: '" + XPath + "' is not visible.","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The webelement with the XPATH '" + XPath + "' is not enabled.","Fail");
		} catch (WebDriverException e) {
			reportStep("The application got crashed for unknown error.","Fail");
		} 
		//finally {takeSnap();	}
	}
	
	public void fileUploadbyID(String id,String filePath)
	{
		try {
			Clipboard clp=Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection ss=new StringSelection(filePath);
			clp.setContents(ss, null);
			clickById(id);
			Thread.sleep(5000);
			
			Robot rbt=new Robot();
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			rbt.keyRelease(KeyEvent.VK_V);
			Thread.sleep(5000);
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			reportStep("The specified file in the path '"+filePath+"' is uploaded successfully.","Pass");
		} catch (AWTException e) {
			reportStep("The specified file in the path '"+filePath+"' is not uploaded successfully.","Fail");
		} catch (Exception e) {
			reportStep("The specified file in the path '"+filePath+"' is not uploaded successfully.","Fail");
		} 
		//finally {takeSnap();}	
	}
	
	public void fileUploadbyXPath(String XPath,String filePath)
	{
		try {
			Clipboard clp=Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection ss=new StringSelection(filePath);
			clp.setContents(ss, null);
			clickByXPath(XPath);
			Thread.sleep(5000);
			
			Robot rbt=new Robot();
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			rbt.keyRelease(KeyEvent.VK_V);
			Thread.sleep(5000);
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			reportStep("The specified file in the path '"+filePath+"' is uploaded successfully.","Pass");
		} catch (AWTException e) {
			reportStep("The specified file in the path '"+filePath+"' is not uploaded successfully.","Fail");
		} catch (Exception e) {
			reportStep("The specified file in the path '"+filePath+"' is not uploaded successfully.","Fail");
		} 
		//finally {takeSnap();}	
	}
	
	public void enterById(String idValue, String data) 
	{
		try {
			driver.findElementById(idValue).sendKeys(data);
			reportStep("The Element got Inspected with locator as id "+idValue+" and loaded the Specified data "+data,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void enterByName(String nameValue, String data) 
	{
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			reportStep("The Element got Inspected with locator as name "+nameValue+" and loaded the Specified data "+data,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }		
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void enterByXPath(String XPathValue, String data) 
	{
		try {
			driver.findElementByXPath(XPathValue).sendKeys(data);
			reportStep("The Element got Inspected with locator as XPath "+XPathValue+" and loaded the Specified data "+data,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void verifyTitle(String title) 
	{
		try {
			String actualtitle = driver.getTitle();
			if(title.equalsIgnoreCase(actualtitle)) {
				reportStep("Ttitle matches","Pass");
			}
			else
				reportStep("Title mismatch","Pass");
		} 
		catch(NoSuchWindowException e) { reportStep("No such window","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void verifyTextById(String id, String text) 
	{
		try {
			String actualtext = driver.findElementById(id).getText();
			if(text.equals(actualtext))
						reportStep("Text matches","Pass");
			else
				reportStep("Text mismatch","Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void verifyTextByXPath(String XPath, String text) 
	{
		try {
			String actualtext = driver.findElementByXPath(XPath).getText();
			if(text.equals(actualtext))
				reportStep("Text matches","Pass");
			else
				reportStep("Text mismatch","Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void verifyTextContainsByXPath(String XPath, String text) 
	{
		try {
			String actualtext = driver.findElementByXPath(XPath).getText();
			if(text.contains(actualtext))
				reportStep(actualtext+" contains "+text,"Pass");
			else
				reportStep(actualtext+" does not contain "+text,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }	
	}

	public void clickById(String id) 
	{
		try {
			driver.findElementById(id).click();
			reportStep("The Element got clicked with locator as id "+id,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void clickByClassName(String classVal) 
	{
		try {
			driver.findElementByClassName(classVal).click();
			reportStep("The Element got clicked with locator as class name "+classVal,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	
	}

	public void clickByName(String name) 
	{
		try {
			driver.findElementByName(name).click();
			reportStep("The Element got clicked with locator as name "+name,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void clickByLink(String name) 
	{
		try {
			driver.findElementByLinkText(name).click();
			reportStep("The Element got Inspected with locator as Linktext "+name,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void clickByLinkNoSnap(String name) 
	{
		try {
			driver.findElementByLinkText(name).click();
			reportStep("The Element got Inspected with locator as Linktext "+name,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
	}

	public void clickByXPath(String XPathVal) 
	{
		try {
			driver.findElementByXPath(XPathVal).click();
			reportStep("The Element got Inspected with locator as XPath "+XPathVal,"Pass");
		} 
		catch (NotFoundException e) { reportStep("sorry Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void clickByXPathNoSnap(String XPathVal) 
	{
		try {
			driver.findElementByXPath(XPathVal).click();
			reportStep("The Element got Inspected with locator as XPath "+XPathVal,"Pass");
		} 
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
	}

	public String getTextById(String idVal) 
	{
		String actualtext=null;
		try {
		actualtext=driver.findElementById(idVal).getText();
		reportStep("The Element got Inspected with locator as id : "+idVal+" and text : "+actualtext,"Pass");
		}
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
		return actualtext;
	}

	public String getTextByXPath(String XPathVal) 
	{
		String actualtext=null;
		try {
		actualtext=driver.findElementByXPath(XPathVal).getText();
		reportStep("The Element got Inspected with locator as XPath "+XPathVal+" and text : "+actualtext,"Pass");
		}
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
		return actualtext;
	}

	public String getAttributeByXPath(String XPathVal, String Text)
	{
		String actualtext=null;
		try {
		actualtext=driver.findElementByXPath(XPathVal).getAttribute(Text);
		reportStep("The Element got Inspected with locator as XPath "+XPathVal+" and attribute : "+actualtext,"Pass");
		}
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
		return actualtext;
	}
	
	public void selectVisibileTextById(String id, String value) //id-value
	{
		try {
			WebElement drop=driver.findElementById(id);
			Select obj=new Select(drop);
			obj.selectByVisibleText(value);
			reportStep("The dropdown with id "+id+" got inspected and the visible text "+value+" is selected","Pass");			
		}
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }		
	}
	
	public void selectVisibileTextByXPath(String XPath, String value)
	{
		try {
			WebElement drop=driver.findElementByXPath(XPath);
			Select obj=new Select(drop);
			obj.selectByVisibleText(value);
			reportStep("The dropdown with id "+XPath+" got inspected and the visible text "+value+" is selected","Pass");			
		}
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }
	}

	public void selectVisibileTextByName(String name, String value) //name-value
	{
		try {
			WebElement drop=driver.findElementByName(name);
			Select obj=new Select(drop);
			obj.selectByVisibleText(value);
			reportStep("The dropdown with id "+name+" got inspected and the visible text "+value+" is selected","Pass");			
		}
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }		
	}
	
	public void selectVisibileTextByClassName(String Class,String value)
	{
		try {
			WebElement drop=driver.findElementByClassName(Class);
			Select obj=new Select(drop);
			obj.selectByVisibleText(value);
			reportStep("The dropdown with id "+Class+" got inspected and the visible text "+value+" is selected","Pass");			
		}
		catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }	
	}
	
	public void selectIndexById(String id, int index)  //id-index
	{
		try {
			WebElement drop=driver.findElementById(id);
			Select obj=new Select(drop);
			obj.selectByIndex(index);
			reportStep("The dropdown with id "+id+" got inspected and the index value "+index+" is selected","Pass");
		} catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }	
	}
	
	public void selectIndexByXPath(String XPath, int index)
	{
		try {
			WebElement drop=driver.findElementByXPath(XPath);
			Select obj=new Select(drop);
			obj.selectByIndex(index);
			reportStep("The dropdown with xpath "+XPath+" got inspected and the index value "+index+" is selected","Pass");
		} catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }	
	}
	
	public void selectValueByName(String name, String value) //name-value
	{
		try {
			WebElement drop=driver.findElementByName(name);
			Select obj=new Select(drop);
			obj.selectByValue(value);
			reportStep("The dropdown with name "+name+" got inspected and the index value "+value+" is selected","Pass");
		} catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }	
	}

	public void selectValueByClassName(String ClassName, String value)
	{
		try {
			WebElement drop=driver.findElementByClassName(ClassName);
			Select obj=new Select(drop);
			obj.selectByValue(value);
			reportStep("The dropdown with ClassName "+ClassName+" got inspected and the index value "+value+" is selected","Pass");
		} catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }	
	}
	
	public void selectValueByXPath(String XPath, String value)
	{
		try {
			WebElement drop=driver.findElementByXPath(XPath);
			Select obj=new Select(drop);
			obj.selectByValue(value);
			reportStep("The dropdown with XPath "+XPath+" got inspected and the index value "+value+" is selected","Pass");
		} catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }	
	}
	
	public void selectIndexByName(String name, int index) //name-index
	{
		try {
			WebElement drop=driver.findElementByName(name);
			Select obj=new Select(drop);
			obj.selectByIndex(index);
			reportStep("The dropdown with name "+name+" got inspected and the index value "+index+" is selected","Pass");
		} catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }	
	}
	
	public void selectValueById(String id, String value) //id-value
	{
		try {
			WebElement drop=driver.findElementById(id);
			Select obj=new Select(drop);
			obj.selectByValue(value);
			reportStep("The dropdown with id "+id+" got inspected and the value "+value+" is selected","Pass");
		} catch (NotFoundException e) { reportStep("Element not found","Fail"); }
		catch(ElementNotVisibleException e) { reportStep("Element not visible","Fail"); }
		catch(ElementNotInteractableException e) { reportStep("Element not interactable","Fail"); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		//finally { takeSnap(); }	
	}
	
	public void switchToParentWindow() {
			try {
				Set<String> string= driver.getWindowHandles();
				for(String estring:string){
					driver.switchTo().window(estring); 
					reportStep("The driver got switched to parent window with window id "+estring,"Pass");
					break; }
			}
				catch(NoSuchWindowException e) { reportStep("No such window","Fail"); }
				catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
	}

	public void switchToLastWindow() {
		try {
			Set<String> string= driver.getWindowHandles();
			String finalwindow = null;
			for(String estring:string){
				driver.switchTo().window(estring); 
				finalwindow=estring;
				 }
			reportStep("The driver got switched to last window with window id "+finalwindow,"Pass");
		}
			catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
	}

	public void acceptAlert() {
		try {
			takeSnap();
			String s=driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			reportStep("Alert with text "+s+" is accepted","Pass");
		}
		catch(NoAlertPresentException e) {reportStep("No such alert","Fail");}
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); } 
		}

	public void dismissAlert() {
		try {
			takeSnap();
			String s=driver.switchTo().alert().getText();
			driver.switchTo().alert().dismiss();
			reportStep("Alert with text "+s+" is dismissed","Pass");
		}
		catch(NoAlertPresentException e) {reportStep("No such alert","Fail");}
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
	}

	public String getAlertText() {
		String s = null;
		try {
			takeSnap();
			s=driver.switchTo().alert().getText();
		}
		catch(NoAlertPresentException e) {reportStep("No such alert","Fail");}
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
		return s;
	}

	public long takeSnap() {
		//long number=100000l;
		long number=(long) Math.floor(Math.random()*10000000+100000l);
		try {
			//number=(long) Math.floor(Math.random()*10000000+100000l);
			File src = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/"+number+".jpeg");
			FileUtils.copyFile(src, dest);
		} 
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); } 
		catch (IOException e) { e.printStackTrace(); }
		return number;
	}
	
	public void closeBrowser() {
		try { driver.close(); } 
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); } 
	}

	public void closeAllBrowsers() {
		try { 
			reportStep("All browsers got closed", "close");
			driver.quit(); }
		catch (WebDriverException e) { reportStep("The Browser got closed due to unknown error","Fail"); }
	}
	
		public void threadSleep(long miliSecs) {
			try {
				Thread.sleep(miliSecs);
			} catch (Exception e) {
				reportStep("The browser got closed","Fail");
			} 
		}

	}
