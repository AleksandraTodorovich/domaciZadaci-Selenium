package d_04_02_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KupujemProdajem {
	
//	Kupujem prodajem [https://www.kupujemprodajem.com/]
//	Ucitajte stranicu (ako treba gasite onaj dijalog sto iskace)
//	Ukucajte za pretragu iphone
//	postavice za valutu eure
//	Sortirajte prema ceni da bude najjefinije prvo
//	Onda izvrsite proveru sortiranja kao sto je bilo za udem
	
	WebDriver driver;

	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kupujemprodajem.com/");
	}

	@Test
	public void findPhone() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.className("kpBoxCloseButton")).click();
		driver.findElement(By.id("searchKeywordsInput")).sendKeys("iPhone");
		Thread.sleep(2000);
		driver.findElement(By.id("searchKeywordsInput")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='priceSecondSelection']/div/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"priceSelection\"]/input[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"priceSelection\"]/input[5]")).click();
		//// *[@id="priceSecondSelection"]/div/div[1]/div[1]
		// "//*[@id='priceSecondSelection']/div/div[1]/div[1]/span[1]"
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='orderSecondSelection']/div/div[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='menuGroup0']/div[1]")).click();

		// Vlado uspela sam dovde da se dovučem, dalje ne ide. Mislim da sam u ovom delu
		// za "Jeftinije" izmenjala
		// bar 10 xpath-a, id-a, class name-a sa contains i bez, i ja vise nemam pojma
		// šta da radim.
		// Ako uspem da ga rešim u međuvremenu, rado ga postavljam na git.
		// Drugi zadatak nisam ni počela da radim.

	}
}
