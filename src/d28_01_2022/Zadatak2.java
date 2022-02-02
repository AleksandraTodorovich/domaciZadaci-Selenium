package d28_01_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
//		2.Zadatak
//		Napisati program koji vrsi dodavanje 5 reda u tabelu. 
//		Maksimizirati prozor
//		Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//		Dodati red podataka - jedan red u jednoj iteraciji 
//		Kliknite na dugme Add New
//		Unesite name,departmant i phone (mogu da budu uvek iste vrednost)
//		Kliknite na zeleno Add dugme
//		Na kraju programa ugasite pretrazivac.
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	//	driver.manage().window().maximize();
		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		driver.findElement(By.xpath("//*[@class='col-sm-4']/button")).click();
		driver.findElement(By.id("name")).sendKeys("Alex Rose");
		driver.findElement(By.id("department")).sendKeys("PR");
		driver.findElement(By.id("phone")).sendKeys("(302) 302-9721");
		driver.findElement(By.xpath("//*[contains(@class, 'table-bordered')]/tbody/tr[4]/td[4]/a/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='col-sm-4']/button")).click();
		driver.findElement(By.id("name")).sendKeys("Melissa Cox");
		driver.findElement(By.id("department")).sendKeys("Education");
		driver.findElement(By.id("phone")).sendKeys("(402) 454-9733");
		driver.findElement(By.xpath("//*[contains(@class, 'table-bordered')]/tbody/tr[5]/td[4]/a/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='col-sm-4']/button")).click();
		driver.findElement(By.id("name")).sendKeys("James Car");
		driver.findElement(By.id("department")).sendKeys("Transport");
		driver.findElement(By.id("phone")).sendKeys("(707) 798-5467");
		driver.findElement(By.xpath("//*[contains(@class, 'table-bordered')]/tbody/tr[6]/td[4]/a/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='col-sm-4']/button")).click();
		driver.findElement(By.id("name")).sendKeys("Lee James");
		driver.findElement(By.id("department")).sendKeys("Marketing");
		driver.findElement(By.id("phone")).sendKeys("(313)328-5732");
		driver.findElement(By.xpath("//*[contains(@class, 'table-bordered')]/tbody/tr[7]/td[4]/a/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='col-sm-4']/button")).click();
		driver.findElement(By.id("name")).sendKeys("Sara MCnroe");
		driver.findElement(By.id("department")).sendKeys("Hospitality");
		driver.findElement(By.id("phone")).sendKeys("(202) 213-2892");
		driver.findElement(By.xpath("//*[contains(@class, 'table-bordered')]/tbody/tr[8]/td[4]/a/i")).click();
		
		
		}
	}


