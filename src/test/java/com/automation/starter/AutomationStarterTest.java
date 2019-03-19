package com.automation.starter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationStarterTest {

	private WebDriver driver;
	private WebElement input;
	private WebElement inputSubmit;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///Users/carlos.salcedo/Downloads/responsive-registration-form/index.html");
	}
	
	
	@Test
	public void test() {
		String keyword = "youtube";
		
		input = driver.findElement(By.name("q"));
		inputSubmit = driver.findElement(By.name("btnK"));
		input.sendKeys(keyword);
		inputSubmit.submit();
		
		assertEquals(keyword + " - Buscar con Google", driver.getTitle());
	}
	
	@After
	public void end() {
		driver.quit();
	}

}
