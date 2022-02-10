package d_07_02_2022_tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d_07_02_2022_pages.FormPage;
import d_07_02_2022_pages.KatalonPage;

public class KatalonTest {

	private WebDriver driver;
	private KatalonPage katalonPage;
	private WebDriverWait wait;


	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		katalonPage = new KatalonPage(driver, wait);
		driver.get("http://cms.demo.katalon.com/");
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void KatalonTest() throws InterruptedException {
		Thread.sleep(500);
		katalonPage.getShopButton().click();
		Thread.sleep(500);
		katalonPage.getProduct().click();
		katalonPage.getAddToCardButton().clear();
		katalonPage.getAddToCardButton().sendKeys("2");
		katalonPage.getClickOnAddButton().click();
		Assert.assertTrue(katalonPage.doesMessageExist(), "Message doesn't exist.");
		katalonPage.getViewCard().click();
		Assert.assertTrue(katalonPage.numberOfItems(), "Bad number of quantity");
		katalonPage.getDeleteButton().click();
		Assert.assertEquals(katalonPage.cardEmpty(), "Your cart is currently empty.",
				"No valid message");
		Thread.sleep(1000);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}