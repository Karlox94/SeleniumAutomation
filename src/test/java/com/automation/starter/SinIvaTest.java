package com.automation.starter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.This;

public class SinIvaTest {

	

	private ChromeDriver driver;
	private WebElement buttonSinIva;
	private WebElement camponum1;
	private WebElement selectTipo;
	private WebElement buttonCalcular;
	private Select dropdown;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		this.driver = new ChromeDriver();
		this.driver.get("https://es.calcuworld.com/calculadoras-financieras/calculadora-iva/");

		this.buttonSinIva = this.driver.findElement(By.id("btn-one"));
		this.camponum1 = this.driver.findElement(By.name("numero"));
		this.selectTipo = this.driver.findElement(By.name("porcentaje"));
		this.buttonCalcular = this.driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div[3]/form/input[2]"));
        this.dropdown =new Select(this.selectTipo);	
        
        dropdown.selectByVisibleText("IVA General (21%)");
        //dropdown.selectByIndex(2);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
