package d_07_02_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {
	// Zadatak
	// Skinite form.html stranicu (iz ovog foldera za domaci) na svom racunaru i
	// otvorite je u pretrazivacu,
	// iskopirajte url stranice
	// Od klasa je potrebno:
	// FormPage koja ima:
	// getere za sve inpute
	// geter za radio - //*[@name='gender'][@value='"+ radioValue +"'] - kao
	// parametar prima value
	// (male/female/middle) tog radio dugmeta
	// geter za checkbox inpute - //*[@type='checkbox'][@value='"+ checkboxValue
	// +"'] -
	// kao parametar prima value (read_books, online_courses, opensource, tech_cons,
	// tech_blogs,
	// via_delivery - jednu od ovde navedenih) tog checkbox inputa
	// getter koji hvata dugme treba da ceka da element postane klikabilan pre nego
	// sto vrati element.
	// Koristite waiter za ovaj slucaj.
	// metodu koja vraca da li su podaci uspesno sacuvani, tako sto proverava da li
	// element koji nosi
	// poruku za atribut style ima vrednost "visibility: visible"

	private WebDriver driver;
	private WebDriverWait wait;

	public FormPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getFullName() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getGender(String radioValue) {
		return driver.findElement(By.xpath("//*[@name='gender'][@value='" + radioValue + "']"));
	}

	public WebElement getDateOfBirth() {
		return driver.findElement(By.id("dob"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getRole() {
		return driver.findElement(By.id("role"));
	}

	public WebElement getWaysOfDevelopment(String checkBoxValue) throws InterruptedException {
		return driver.findElement(By.xpath("//*[@type='checkbox'][@value='" + checkBoxValue + "']"));
	}

	public WebElement getComment() {
		return driver.findElement(By.id("comment"));
	}

	public WebElement getWaitForElementToBeClickabile() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		return this.driver.findElement(By.id("submit"));
	}

	public boolean dataSavedSucessfuly() {
//				wait.until(ExpectedConditions.attributeToBe(By.xpath("/html/body/div/div/div[1]"), "style", "visibility: visible"));
//				try {
//					wait.until(ExpectedConditions.attributeToBe(By.xpath("/html/body/div/div/div[1]/div"), "style", "visibility: visible"));
//					return true;
//				} catch (Exception e) {
//					return false;
//				}  
		boolean savedInfo = false;
		String ms = driver.findElement(By.className("poruka")).getAttribute("style");
		if (ms.equals("visibility: visible;")) {
			savedInfo = true;
		}
		return savedInfo;
	}

	public void insertAllData(String name, String gender, String birthDate, String email, String profession,
		String interests) throws InterruptedException {
		Select select = new Select(this.getRole());
		Thread.sleep(2000);
		this.getFullName().sendKeys(name);
		this.getGender(gender).click();
		this.getDateOfBirth().sendKeys(birthDate);
		this.getEmail().sendKeys(email);
		select.selectByVisibleText(profession);
		this.getWaysOfDevelopment(interests).click();
		Thread.sleep(2000);
	}

}
