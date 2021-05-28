package com.StepDefination;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myUse.BaseClass;

public class StepDefination extends BaseClass     {

	WebDriver driver;

	@Given("user is on adactin page")
	public void user_is_on_adactin_page() {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium works\\frames\\FirstDay\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("user should enter {string} and {string}")
	public void user_should_enter_and(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		Assert.assertEquals(username,"karthi007" );
		driver.findElement(By.id("password")).sendKeys(password);
		Assert.assertEquals(password, "Karthi@1989");

	}

	@Then("user should click the login button")
	public void user_should_click_the_login_button() {
		driver.findElement(By.id("login")).click();
	}

	@Then("serach select hotel{string},{string},{string},{string},{string},{string},{string},{string} and search the hotel")
	public void serach_select_hotel_and_search_the_hotel(String location, String hotel, String roomtype, String roomnum, String indate, String outdate, String adult, String child) {
		driver.findElement(By.id("location")).sendKeys(location);
		driver.findElement(By.id("hotels")).sendKeys(hotel);

		driver.findElement(By.id("room_type")).sendKeys(roomtype);
		driver.findElement(By.id("room_nos")).sendKeys(roomnum);
		driver.findElement(By.id("datepick_in")).sendKeys(indate);
		driver.findElement(By.id("datepick_out")).sendKeys(outdate);
		driver.findElement(By.id("adult_room")).sendKeys(adult);
		driver.findElement(By.id("child_room")).sendKeys(child);
		driver.findElement(By.id("Submit")).click();
	}

	@Then("select hotel select and click")
	public void select_hotel_select_and_click() {
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
	}

	@Then("book the hotel{string},{string},{string},{string},{string},{string},{string},{string} and click")
	public void book_the_hotel_and_click(String Fname, String lname, String address, String cardno, String cardtype, String expdate, String expyear, String cvvnum) {
		driver.findElement(By.id("first_name")).sendKeys(Fname);
		driver.findElement(By.id("last_name")).sendKeys(lname);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.id("cc_num")).sendKeys(cardno);
		driver.findElement(By.id("cc_type")).sendKeys(cardtype);
		driver.findElement(By.id("cc_exp_month")).sendKeys(expdate);
		driver.findElement(By.id("cc_exp_year")).sendKeys(expyear);
		driver.findElement(By.id("cc_cvv")).sendKeys(cvvnum);
		driver.findElement(By.id("book_now")).click();

	}

	@Then("get the order id")
	public void get_the_order_id() throws InterruptedException, IOException {
		WebElement a=driver.findElement(By.id("order_no"));
		String st=a.getAttribute("value");
		System.out.println(st);
		
		
		//excelWrite(a, 0, 1);
		
		
		
		//driver.findElement(By.id("order_no")).getAttribute("value");
		//System.out.println(driver.findElement(By.id("order_no")).getAttribute("value"));
File file=new File("C:\\selenium works\\frames\\FirstDay\\Excel\\sample.xlsx");
Workbook w=new XSSFWorkbook();
Sheet sheet=w.createSheet("Task");
for (int i = 0; i < 1; i++) {
	Row r=sheet.createRow(i);
for (int j = 0; j <=i; j++) {
org.apache.poi.ss.usermodel.Cell c=r.createCell(j);
c.setCellValue(st);
}}
FileOutputStream out=new FileOutputStream(file);
w.write(out);




	}





}