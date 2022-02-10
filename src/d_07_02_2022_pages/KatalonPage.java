package d_07_02_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KatalonPage {
//	Napisati test koji:
//		Ucitava stranicu http://cms.demo.katalon.com/
//		Vrsi klik na Shop link iz navigacije
//		Otvara stranicu prvog proizvoda klikom na karticu prvog proizvoda
//		Dodaje proizvod u korpu sa kolicinom 2
//		Verifikuje poruku nakon dodavanja “has been added to your cart.”
//		Odlazi u korpu klikom na dugme VIew Cart
//		Verifikuje stanje u korpi, tj. da postoji proizvod sa kolicinom 2.
//		Brise stavku iz korpe klikom na dugme x.
//		Verifikuje poruku za praznu korpu.
//		Osmislite pageve za ovaj zadatak!
	private WebDriver driver;
	private WebDriverWait wait;

	public KatalonPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getShopButton() {
		return this.driver.findElement(By.linkText("SHOP"));
		
	}

	public WebElement getProduct() {
		return this.driver.findElement(By.xpath("//*[@id='main']/div[2]/ul/li[1]/div/a[1]"));
	}

	public WebElement getAddToCardButton() {
		return this.driver.findElement(By.name("quantity"));
		
	}

	public WebElement getClickOnAddButton() {
		return this.driver.findElement(By.name("add-to-cart"));
	}

	public WebElement getViewCard() {
		return this.driver.findElement(By.linkText("VIEW CART"));
	}

	public WebElement getTxtMessage() {
		return this.driver.findElement(By.xpath("//*[@id='main']/div[1]/div"));
	}

	public boolean numberOfItems() {
		String value = driver.findElement(By.className("input-text")).getAttribute("value");
		return value.equals("2");
	}

	public WebElement getDeleteButton() {
		return this.driver.findElement(By.className("remove"));
	}

	public String getMessageText() {
		return getTxtMessage().getText();
	}
	public String cardEmpty() {
		return this.driver.findElement(By.xpath("//*[@id='post-8']/div/div/div/p")).getText();
	}

	public boolean doesMessageExist() {
		try {
			getTxtMessage();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
