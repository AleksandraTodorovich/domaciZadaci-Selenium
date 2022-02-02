package d_31_01_2022;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
//		2.Zadatak
//		Napisati program koji ucitava stranicu https://geodata.solutions/
//		Bira proizvoljan Country, State i City
//		Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//		I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//		Izabrerit Country, State i City tako da imate podatke da selektujete!
		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://geodata.solutions/");
		driver.findElement(By.id("countryId"));
		Select select1 = new Select(driver.findElement(By.id("countryId")));
		select1.selectByVisibleText("France");
		Select select2 = new Select(driver.findElement(By.id("stateId")));
		select2.selectByVisibleText("Grand Est");
		Thread.sleep(3000);
		//morala sam da uvedem Thread.sleep ispred grada jer nije hteo da mi selektuje grad bez toga.
		Select select3 = new Select(driver.findElement(By.id("cityId")));
		select3.selectByVisibleText("Givet");

		

	}

}
