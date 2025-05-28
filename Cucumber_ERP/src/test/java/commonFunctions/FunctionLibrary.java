package commonFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FunctionLibrary {
public static WebDriver driver;
public static Properties conpro;
//method for launch browser
public static WebDriver startBrowser()throws Throwable
{
	conpro = new Properties();
	conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else
	{
		try {
			throw new IllegalArgumentException("Browser Value is Not Matching");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}
	return driver;
	
}
//method for launching url
public static void openUrl()
{
	driver.get(conpro.getProperty("Url"));
}
//method for wait for any webelement
public static void waitForElement(String LocatorType,String LocatorValue,String TestData)
{
	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(TestData)));
	if(LocatorType.equalsIgnoreCase("name"))
	{
		//wait until element is visible
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LocatorValue)));
	}
	if(LocatorType.equalsIgnoreCase("xpath"))
	{
		//wait until element is visible
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorValue)));
	}
	if(LocatorType.equalsIgnoreCase("id"))
	{
		//wait until element is visible
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
		
	}
	
}
//method for any textbox
public static void typeAction(String LocatorType,String LocatorValue,String TestData)
{
	if(LocatorType.equalsIgnoreCase("name"))
	{
		driver.findElement(By.name(LocatorValue)).clear();
		driver.findElement(By.name(LocatorValue)).sendKeys(TestData);
	}
	if(LocatorType.equalsIgnoreCase("xpath"))
	{
		driver.findElement(By.xpath(LocatorValue)).clear();
		driver.findElement(By.xpath(LocatorValue)).sendKeys(TestData);
	}
	if(LocatorType.equalsIgnoreCase("id"))
	{
		driver.findElement(By.id(LocatorValue)).clear();
		driver.findElement(By.id(LocatorValue)).sendKeys(TestData);
	}
}
//method for buttons,radibutton,checkbox,links and images
public static void clickAction(String LocatorType,String LocatorValue)
{
	if(LocatorType.equalsIgnoreCase("name"))
	{
		driver.findElement(By.name(LocatorValue)).click();
	}
	if(LocatorType.equalsIgnoreCase("xpath"))
	{
		driver.findElement(By.xpath(LocatorValue)).click();
	}
	if(LocatorType.equalsIgnoreCase("id"))
	{
		driver.findElement(By.id(LocatorValue)).sendKeys(Keys.ENTER);
	}
}
//method for validate page title
public static void validateTitle(String Expected_Title)
{
	String Actual_Title = driver.getTitle();
	try {
		Assert.assertEquals(Actual_Title, Expected_Title, "Title is Not Matching");
	} catch (AssertionError a) {
		System.out.println(a.getMessage());
	}
	
}
//method for closing browser
public static void closeBrowser()
{
	driver.quit();
}
//method for listbox
public static void dropDownAction(String Locatortype,String Locatorvalue,String TestData)
{
	if(Locatortype.equalsIgnoreCase("name"))
	{
		int value = Integer.parseInt(TestData);
		Select element = new Select(driver.findElement(By.name(Locatorvalue)));
		element.selectByIndex(value);
		
	}
	if(Locatortype.equalsIgnoreCase("xpath"))
	{
		int value = Integer.parseInt(TestData);
		Select element = new Select(driver.findElement(By.xpath(Locatorvalue)));
		element.selectByIndex(value);
	}
	if(Locatortype.equalsIgnoreCase("id"))
	{
		int value = Integer.parseInt(TestData);
		Select element = new Select(driver.findElement(By.id(Locatorvalue)));
		element.selectByIndex(value);
	}
}
//method to capture stock number into note pad
public static void captureStock(String LocatorType,String LocatorValue)throws Throwable
{
	String Stock_Number="";
	if(LocatorType.equalsIgnoreCase("xpath"))
	{
		Stock_Number = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
						
	}
	if(LocatorType.equalsIgnoreCase("name"))
	{
		Stock_Number = driver.findElement(By.name(LocatorValue)).getAttribute("value");
						
	}
	if(LocatorType.equalsIgnoreCase("id"))
	{
		Stock_Number = driver.findElement(By.id(LocatorValue)).getAttribute("value");
	}
	//create note into capturedata folder
	File f= new File("./CaptureData/StockNumber.txt");
	FileWriter fw = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write(Stock_Number);
	bw.flush();
	bw.close();
}
//method to validate stock table
public static void stockTable()throws Throwable
{
	//read stock number from above note pad
	FileReader fr = new FileReader("./CaptureData/StockNumber.txt");
	BufferedReader br = new BufferedReader(fr);
	String Exp_Number = br.readLine();
	if(!driver.findElement(By.xpath(conpro.getProperty("seach-textbox"))).isDisplayed())
		driver.findElement(By.xpath(conpro.getProperty("search-panel"))).click();
	driver.findElement(By.xpath(conpro.getProperty("seach-textbox"))).clear();
	driver.findElement(By.xpath(conpro.getProperty("seach-textbox"))).sendKeys(Exp_Number);
	driver.findElement(By.xpath(conpro.getProperty("search-button"))).click();
	Thread.sleep(2000);
	String Act_Number = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[8]/div/span/span")).getText();
	try {
		Assert.assertEquals(Act_Number, Exp_Number, "Stock number Not Found In table");
	} catch (AssertionError e) {
		System.out.println(e.getMessage());
	}
	
}
public static String generateDate()
{
Date date = new Date();
DateFormat df = new SimpleDateFormat("YYYY_MM_dd");
return df.format(date);
}
//method for capture suppler number into notepad
public static void captureSupplier(String LocatorType,String LocatorValue)throws Throwable
{
	String Supplier_Num="";
	if(LocatorType.equalsIgnoreCase("name"))
	{
		Supplier_Num = driver.findElement(By.name(LocatorValue)).getAttribute("value");
	}
	if(LocatorType.equalsIgnoreCase("xpath"))
	{
		Supplier_Num = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
	}
	if(LocatorType.equalsIgnoreCase("id"))
	{
		Supplier_Num = driver.findElement(By.id(LocatorValue)).getAttribute("value");
	}
	File f = new File("./CaptureData/suppliernum.txt");
	FileWriter fw = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write(Supplier_Num);
	bw.flush();
	bw.close();
}
//method for supplier table
public static void supplierTable()throws Throwable
{
	//read supplier number from above note pad
	FileReader fr = new FileReader("./CaptureData/suppliernum.txt");
	BufferedReader br = new BufferedReader(fr);
	String Exp_Num = br.readLine();
	if(!driver.findElement(By.xpath(conpro.getProperty("seach-textbox"))).isDisplayed())
		driver.findElement(By.xpath(conpro.getProperty("search-panel"))).click();
	driver.findElement(By.xpath(conpro.getProperty("seach-textbox"))).clear();
	driver.findElement(By.xpath(conpro.getProperty("seach-textbox"))).sendKeys(Exp_Num);
	driver.findElement(By.xpath(conpro.getProperty("search-button"))).click();
	Thread.sleep(3000);
	String Act_Num = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
	try {
		Assert.assertEquals(Act_Num, Exp_Num,"Supplier Number Not Found In Table");
	} catch (AssertionError e) {
		System.out.println(e.getMessage());
	}
	
}
//method for capture Customer number into notepad
public static void captureCustomer(String LocatorType,String LocatorValue)throws Throwable
{
	String Customer_Num="";
	if(LocatorType.equalsIgnoreCase("name"))
	{
		Customer_Num = driver.findElement(By.name(LocatorValue)).getAttribute("value");
	}
	if(LocatorType.equalsIgnoreCase("xpath"))
	{
		Customer_Num = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
	}
	if(LocatorType.equalsIgnoreCase("id"))
	{
		Customer_Num = driver.findElement(By.id(LocatorValue)).getAttribute("value");
	}
	File f = new File("./CaptureData/customernum.txt");
	FileWriter fw = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write(Customer_Num);
	bw.flush();
	bw.close();
}
//method for supplier table
public static void customerTable()throws Throwable
{
	//read supplier number from above note pad
	FileReader fr = new FileReader("./CaptureData/customernum.txt");
	BufferedReader br = new BufferedReader(fr);
	String Exp_Num = br.readLine();
	if(!driver.findElement(By.xpath(conpro.getProperty("seach-textbox"))).isDisplayed())
		driver.findElement(By.xpath(conpro.getProperty("search-panel"))).click();
	driver.findElement(By.xpath(conpro.getProperty("seach-textbox"))).clear();
	driver.findElement(By.xpath(conpro.getProperty("seach-textbox"))).sendKeys(Exp_Num);
	driver.findElement(By.xpath(conpro.getProperty("search-button"))).click();
	Thread.sleep(3000);
	String Act_Num = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")).getText();
	try {
		Assert.assertEquals(Act_Num, Exp_Num,"Customer Number Not Found In Table");
	} catch (AssertionError e) {
		System.out.println(e.getMessage());
	}
	
}
}


















