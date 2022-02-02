package d28_01_2022;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Zadatak 
//		Maksimizirati prozor
//		Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
//		Od korisnika ucitati broj na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
//		I izvrsite akciju klik na odgovarajuci element
//		Na kraju programa ugasite pretrazivac.

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/WaXlr");
		Scanner s  = new Scanner (System.in);
		System.out.println("Oceni upotrebu interneta i PC-a od 1 do 5: ");
		int ocena = s.nextInt();
		driver.findElement(By.id("rating-star-" + ocena)).click();
		driver.close();
		
	}

}
