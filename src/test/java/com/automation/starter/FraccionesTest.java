package com.automation.starter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FraccionesTest {

	private WebDriver driver;
	private WebElement fraccion1Num;
	private WebElement fraccion1Den;
	private WebElement fraccion2Num;
	private WebElement fraccion2Den;
	private WebElement operacion;
	private Select dropdownOp;
	private WebElement checkSimplificar;
	private WebElement botonCalcular;
	private WebElement resultadoNum;
	private WebElement resultadoDen;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		this.driver = new ChromeDriver();

		this.driver.get("https://es.calcuworld.com/calculadoras-matematicas/calculadora-de-fracciones/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		this.fraccion1Num = this.driver.findElement(By.id("n1"));
		this.fraccion1Den = this.driver.findElement(By.id("d1"));
		this.fraccion2Num = this.driver.findElement(By.id("n2"));
		this.fraccion2Den = this.driver.findElement(By.id("d2"));
		this.operacion = this.driver.findElement(By.name("Op"));
		this.dropdownOp = new Select(this.operacion);
		this.checkSimplificar = this.driver.findElement(By.id("reduce"));
		this.botonCalcular = this.driver.findElement(By.xpath("//*[@id='post-897']/div/div[3]/div[2]/form/div[4]/a"));
		this.resultadoNum = this.driver.findElement(By.id("An"));
		this.resultadoDen = this.driver.findElement(By.id("Ad"));
	}

	@Test
	public void SumaSinReducir() {
		this.fraccion1Num.sendKeys("4");
		this.fraccion1Den.sendKeys("3");

		this.fraccion2Num.sendKeys("6");
		this.fraccion2Den.sendKeys("3");

		this.dropdownOp.selectByIndex(0);

		this.checkSimplificar.click();

		this.botonCalcular.click();
		
		assertEquals("30", this.resultadoNum.getAttribute("value"));
		assertEquals("9", this.resultadoDen.getAttribute("value"));
	}

	
	@Test
	public void SumaConReducir() {
		this.fraccion1Num.sendKeys("4");
		this.fraccion1Den.sendKeys("3");

		this.fraccion2Num.sendKeys("6");
		this.fraccion2Den.sendKeys("3");

		this.dropdownOp.selectByIndex(0);

		this.botonCalcular.click();
		
		assertEquals("10", this.resultadoNum.getAttribute("value"));
		assertEquals("3", this.resultadoDen.getAttribute("value"));
	}
	
	@Test
	public void RestarSinReducir() {
		this.fraccion1Num.sendKeys("4");
		this.fraccion1Den.sendKeys("3");

		this.fraccion2Num.sendKeys("6");
		this.fraccion2Den.sendKeys("3");

		this.dropdownOp.selectByIndex(1);

		this.checkSimplificar.click();

		this.botonCalcular.click();
		
		assertEquals("-6", this.resultadoNum.getAttribute("value"));
		assertEquals("9", this.resultadoDen.getAttribute("value"));
	}

	@Test
	public void RestarConReducir() {
		this.fraccion1Num.sendKeys("4");
		this.fraccion1Den.sendKeys("3");

		this.fraccion2Num.sendKeys("6");
		this.fraccion2Den.sendKeys("3");

		this.dropdownOp.selectByIndex(1);

		this.botonCalcular.click();
		
		assertEquals("-2", this.resultadoNum.getAttribute("value"));
		assertEquals("3", this.resultadoDen.getAttribute("value"));
	}
	
	@Test
	public void MultiplicarSinReducir() {
		this.fraccion1Num.sendKeys("4");
		this.fraccion1Den.sendKeys("3");

		this.fraccion2Num.sendKeys("6");
		this.fraccion2Den.sendKeys("3");

		this.dropdownOp.selectByIndex(2);

		this.checkSimplificar.click();

		this.botonCalcular.click();
		
		assertEquals("24", this.resultadoNum.getAttribute("value"));
		assertEquals("9", this.resultadoDen.getAttribute("value"));
	}

	@Test
	public void MultiplicarConReducir() {
		this.fraccion1Num.sendKeys("4");
		this.fraccion1Den.sendKeys("3");

		this.fraccion2Num.sendKeys("6");
		this.fraccion2Den.sendKeys("3");

		this.dropdownOp.selectByIndex(2);

		this.botonCalcular.click();
		
		assertEquals("8", this.resultadoNum.getAttribute("value"));
		assertEquals("3", this.resultadoDen.getAttribute("value"));
	}
	
	@Test
	public void DividirSinReducir() {
		this.fraccion1Num.sendKeys("4");
		this.fraccion1Den.sendKeys("3");

		this.fraccion2Num.sendKeys("6");
		this.fraccion2Den.sendKeys("3");

		this.dropdownOp.selectByIndex(3);

		this.checkSimplificar.click();

		this.botonCalcular.click();
		
		assertEquals("12", this.resultadoNum.getAttribute("value"));
		assertEquals("18", this.resultadoDen.getAttribute("value"));
	}

	@Test
	public void DividirConReducir() {
		this.fraccion1Num.sendKeys("4");
		this.fraccion1Den.sendKeys("3");

		this.fraccion2Num.sendKeys("6");
		this.fraccion2Den.sendKeys("3");

		this.dropdownOp.selectByIndex(3);

		this.botonCalcular.click();
		
		assertEquals("2", this.resultadoNum.getAttribute("value"));
		assertEquals("3", this.resultadoDen.getAttribute("value"));
	}

	@After
	public void tearDown() throws Exception {
		this.driver.quit();
	}

}
