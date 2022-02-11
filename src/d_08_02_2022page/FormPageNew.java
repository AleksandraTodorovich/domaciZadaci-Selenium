package d_08_02_2022page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPageNew {
	private WebDriver driver;
	private WebDriverWait wait;

	public FormPageNew(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getFullName() {
		return driver.findElement(By.id("first-name"));
	}
	public WebElement getGender(String radioValue) {
		return driver.findElement(By.xpath("//*[@name='gender'][@value='"+ radioValue + "']"));
		//return driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/label/input[@value='"+ radioValue +"']"));
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
		return driver.findElement(By.xpath("//*[@type='checkbox'][@value='" + checkBoxValue +"']"));
	}
	public WebElement getComment() {
		return driver.findElement(By.id("comment")); 
	}
	public WebElement getWaitForElementToBeClickabile() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		return this.driver.findElement(By.id("submit"));
	}
	public boolean dataSavedSucessfuly() { 
		boolean savedInfo = false;
		String ms = driver.findElement(By.className("poruka")).getAttribute("style");
		if (ms.equals("visibility: visible;")) {
			savedInfo = true;
		}
		return savedInfo;
	}
	
	public void insertAllData(String name, String gender, String birthDate, String email, String profession, String interests, String comment) throws InterruptedException {
		Select select = new Select(this.getRole());
		this.getFullName().sendKeys(name);
		this.getGender(gender).click();
		this.getDateOfBirth().sendKeys(birthDate);
		this.getEmail().sendKeys(email);
		select.selectByVisibleText(profession);
		this.getWaysOfDevelopment(interests).click();
		this.getComment().sendKeys(comment);
		Thread.sleep(2000);
}

}
