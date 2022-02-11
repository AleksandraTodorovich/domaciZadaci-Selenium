package d_08_02_2022_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import d_08_02_2022page.FormPageNew;

public class FormTest {
//	1. Zadatak
//	Za potrebe zadatka kreirati FormPage koji ima sve potrebne metode.
//	Zatim kreirati FormTest koji 
//	Ucitava form.html stranicu (form.html je u folderu za domaci skinite je i otvorite u chrome i 
//	iskopirajte url)
//	I popunjava formu koristeci FormData.xlsx fajl (u folderu je za domaci)
//	Postavite odgovarajuce waitere tako da se saceka sledeci unos podataka u formu nakon submitovanja
	private WebDriver driver;
	private WebDriverWait wait;
	private FormPageNew formPageNew;
	private SoftAssert sa;

	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		formPageNew = new FormPageNew(driver, wait);
		sa = new SoftAssert();
		driver.get("file:///C:/Users/SaM%20family/Desktop/New%20folder/form%20(1).html");
	}

	@Test
	public void testing() throws IOException, InterruptedException {

		File file = new File("data/FormData.xlsx");
		System.out.println(file.getAbsolutePath());
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetKorisnici = wb.getSheet("form");

		for (int i = 1; i < 7; i++) {
			String fullname = sheetKorisnici.getRow(i).getCell(0).getStringCellValue();
			String gender = sheetKorisnici.getRow(i).getCell(1).getStringCellValue();
			String dateOfBirth = ""+sheetKorisnici.getRow(i).getCell(2).getDateCellValue();
//			 Double d = sc.nextDouble();
//		      String result = ""+d;
			String email = sheetKorisnici.getRow(i).getCell(3).getStringCellValue();
			String role = sheetKorisnici.getRow(i).getCell(4).getStringCellValue();
			String waysOfDevelopment = sheetKorisnici.getRow(i).getCell(5).getStringCellValue();
			String comment = sheetKorisnici.getRow(i).getCell(6).getStringCellValue();
			driver.navigate().refresh();
			formPageNew.insertAllData(fullname, gender, dateOfBirth, email, role, waysOfDevelopment, comment);
			Thread.sleep(3000);
			formPageNew.getWaitForElementToBeClickabile().click();
			sa.assertTrue(formPageNew.dataSavedSucessfuly(), "Data is not saved");
			
		}
		sa.assertAll();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
}
