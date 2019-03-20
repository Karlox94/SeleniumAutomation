package com.automation.starter;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationStarterTest {

	private WebDriver driver;
	private WebElement inputEmail;
	private WebElement inputPassword;
	private WebElement inputPassword2;
	private WebElement inputName;
	private WebElement inputLastname;
	private List<WebElement> radioButtonList;
	private WebElement inputCountry;
	private Select inputCountrySelect;
	private WebElement inputSubmit;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///Users/carlos.salcedo/Downloads/responsive-registration-form/index.html");
		
		inputEmail = driver.findElement(By.id("email"));
		inputPassword = driver.findElement(By.id("password"));
		inputPassword2 = driver.findElement(By.id("password2"));
		inputName = driver.findElement(By.id("name"));
		inputLastname = driver.findElement(By.id("lastname"));
		inputCountry = driver.findElement(By.id("countrySelect"));
		inputCountrySelect = new Select(inputCountry);
		inputSubmit = driver.findElement(By.id("registerButton"));
	}
	
	
	@Test
	public void test() throws InterruptedException {
		inputEmail.sendKeys("ikarloxi@gmail.com");
		inputPassword.sendKeys("123456");
		inputPassword2.sendKeys("123456");
		inputName.sendKeys("Carlos");
		inputLastname.sendKeys("Salcedo");
		// Thread.sleep(2000);
		radioButtonList = driver.findElements((By.tagName("label")));
		List<WebElement> radioList = radioButtonList;
		radioList.get(0).click();
		inputCountry.click();
		inputCountrySelect.selectByIndex(2);
		radioList.get(2).click();
		
		assertEquals(inputPassword.getText(), inputPassword2.getText());
		// inputSubmit.submit();
	}
	
	@After
	public void end() {
		// driver.quit();
	}

}
