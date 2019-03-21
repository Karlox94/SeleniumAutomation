package com.automation.starter;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OperationsTest {

	private WebDriver driver;
	private WebElement inputNum;
	private WebElement inputDen;
	private WebElement result1;
	private WebElement result2;
	private WebElement opertaionButton;
	private File src;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

		this.driver = new ChromeDriver();
		this.driver.get("https://es.calcuworld.com/calculadoras-matematicas/fracciones-a-decimales");

		this.inputNum = this.driver.findElement(By.id("num"));
		this.inputDen = this.driver.findElement(By.id("den"));
		this.result1 = this.driver.findElement(By.id("result1"));
		this.result2 = this.driver.findElement(By.id("result2"));
		this.opertaionButton = this.driver.findElement(By.id("button"));

		this.inputNum.clear();
		this.inputDen.clear();
	}

	@Test
	public void test() throws InterruptedException  {
		String num = "2";
		String den = "4";
		String frac = String.valueOf(Float.parseFloat(num) / Float.parseFloat(den));
		String dec = num + "/" + den;
		this.inputNum.sendKeys(num);
		this.inputDen.sendKeys(den);
		this.opertaionButton.click();

		assertEquals(dec, this.result1.getAttribute("value"));
		assertEquals(frac, this.result2.getAttribute("value"));
		
		this.takeScreenshot();
	}

	@After
	public void end() {
		this.driver.quit();
	}

	private void takeScreenshot() {
		this.src = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("/Users/carlos.salcedo/Desktop/capture-"+System.currentTimeMillis()+".jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
