package d_07_02_2022_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d_07_02_2022_pages.FormPage;

public class FormTest {
//	Ucitava stranicu
//	Popunite formu proizvoljnim podacima
//	Submitujte formu 
//	Proverite da li su podaci uspesno sacuvani. (imate metodu iz page-a koja vam vraca da li je
//	uspesno sacuvano, iskorisite je)
//	U AfterClass metodi zatvaramo stranicu
	private WebDriver driver;
	private WebDriverWait wait;
	private FormPage formPage;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/SaM%20family/Downloads/form.html");
		wait = new WebDriverWait(driver, 10);
		formPage = new FormPage(driver, wait);
	}
	@Test
	public void fillInTheForm() throws InterruptedException {
		formPage.insertAllData("Milos Markovic", "male", "12.02.1995", "milos@gmail.com", "QA", "read_books");
		//formPage.insertAllData("Milos Markovic", "Milos Markovic", "12.02.1995", "milos@gmail.com", "QA", "read_books");
		Thread.sleep(500);
		formPage.getComment().sendKeys("Hello World");
		formPage.getWaitForElementToBeClickabile().click();
		Assert.assertTrue(formPage.dataSavedSucessfuly(), "Data has not been saved.");
		Thread.sleep(500);
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	}

