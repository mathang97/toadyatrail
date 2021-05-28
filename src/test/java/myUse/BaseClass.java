package myUse;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	private static final String TakesScreenshot = null;
	public static WebDriver driver;

	public  void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void launchUrl(String data) {
		driver.get(data);
	}

	public void getText(WebElement element, String data) {
		element.getText();
	}

	public void getAttribute(WebElement element, String data) {
		element.getAttribute(data);
	}

	public void getSiZe(WebElement element) {
		element.getSize();
	}

	public void enterText(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void btnClick(WebElement element) {
		element.click();
	}

	public void moveToElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	public void dragAndDrop(WebElement element, WebElement element2) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(element, element2);
	}

	public void rightClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element).perform();
	}

	public void doubleClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.doubleClick(element).perform();
	}

	public void keyUpAndKeyDown(WebElement element, String data) {
		Actions ac = new Actions(driver);
		ac.keyDown(element, Keys.SHIFT).sendKeys(element, data).keyUp(element, Keys.SHIFT).perform();
	}

	public void simpleAlerts() {
		Alert as = driver.switchTo().alert();
		as.accept();
	}

	public void promptAlerts() {
		Alert as = driver.switchTo().alert();
		as.accept();
		as.dismiss();
	}

	public void confirmAlerts(String data) {
		Alert as = driver.switchTo().alert();
		as.accept();
		as.dismiss();
		as.sendKeys(data);
	}

	public void enterTextByJs(String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAtribute('value','" + data + "')", element);
	}

	public void getTextByJs(String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].getAtribute('value','" + data + "')", element);
	}

	public void ClickByJs(String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].Click()", element);
	}

	public void scrollDownByJs(String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", element);
	}

	public void scrollUpByJs(String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(false)", element);
	}

	public void selectByIndex(WebElement element, int number) {
		Select se = new Select(element);
		se.selectByIndex(number);
	}

	public void selectByValue(WebElement element, String value) {
		Select se = new Select(element);
		se.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String value) {
		Select se = new Select(element);
		se.selectByVisibleText(value);
	}

	public void deselectByIndex(WebElement element, int number) {
		Select se = new Select(element);
		se.deselectByIndex(number);
	}

	public void deselectByValue(WebElement element, String value) {
		Select se = new Select(element);
		se.deselectByValue(value);
	}

	public void deselectByVisibleText(WebElement element, String value) {
		Select se = new Select(element);
		se.deselectByVisibleText(value);
	}

	public void getOptionsBySelect(WebElement element) {
		Select se = new Select(element);
		se.getOptions();
	}

	public void getAllOptionsBySelect(WebElement element) {
		Select se = new Select(element);
		se.getAllSelectedOptions();
	}

	public void getFirstSelectedBySelect(WebElement element) {
		Select se = new Select(element);
		se.getFirstSelectedOption();
	}

	public void isMultipleBySelect(WebElement element) {
		Select se = new Select(element);
		se.isMultiple();
	}

	public void deSelectBySelect(WebElement element) {
		Select se = new Select(element);
		se.deselectAll();
	}

	public void frameMethodnumber(int number) {
		driver.switchTo().frame(number);
	}

	public void frameMethoddata(String Data) {
		driver.switchTo().frame(Data);
	}

	public void frameMethoddata(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void defaultContent() {
		driver.switchTo().defaultContent();
	}

	public void frameParentFrame() {
		driver.switchTo().parentFrame();
	}

	public WebElement findElementByid(String data) {
		WebElement findElement = driver.findElement(By.id(data));
		return findElement;
	}

	public WebElement findElementByName(String data) {
	WebElement findElement = driver.findElement(By.name(data));
	return findElement;
}

public static String Excelread(int rowno,int Cellno) throws IOException {
	File file=new File("C:\\selenium works\\frames\\testngTask\\Excel\\Task.xlsx");
	FileInputStream stream=new FileInputStream(file);
	Workbook w=new XSSFWorkbook(stream);
	Sheet sheet =w.getSheet("Task");
	Row r=sheet.getRow(rowno);
	Cell c=r.getCell(Cellno);
	int cellType=c.getCellType();
String value="";
if(cellType==1) {
	value=c.getStringCellValue();
}
else if(DateUtil.isCellDateFormatted(c)) {
java.util.Date datecallvalue = c.getDateCellValue();
SimpleDateFormat formet=new SimpleDateFormat("dd-mm-yyyy");
value =formet.format(datecallvalue);
}else {
	double numericcellvalue = c.getNumericCellValue();
	long l=(long) numericcellvalue;
	value = String.valueOf(l);

}
return value;	

}
public void excelWrite(WebElement element,int rowNo,int cellNo) throws IOException {
	File file = new File("C:\\selenium works\\frames\\FirstDay\\Excel\\sample.xlsx");
	FileInputStream inputstream = new FileInputStream(file);
	Workbook w = new XSSFWorkbook(inputstream);
	Sheet sheet = w.getSheet("Sheet1");
	Row row = sheet.getRow(rowNo);
	Cell createCell = row.createCell(cellNo);
	String text = element.getAttribute("value");
	createCell.setCellValue(text);
	FileOutputStream out = new FileOutputStream(file);
	w.write(out);

}

//robort class
public void Robot(int prs,int rel) throws AWTException {  //public void Robot(int prs)  {
Robot r=new Robot();   //Robot r=new Robot();
r.keyPress(prs);       //r.keyPress(prs);   
r.keyRelease(rel);     //r.keyRelease(prs);
}
//screenshot
public void screenshot(String a) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
File takesc=ts.getScreenshotAs(OutputType.FILE);
System.out.println(a);
}



}
	

