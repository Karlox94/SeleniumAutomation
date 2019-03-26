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
import org.openqa.selenium.support.ui.Select;

public class CaloriaTest {

	private WebDriver driver;
	private File src;
	private WebElement selectRitmo;
	private Select dropdownSelectRitmo;
	private WebElement peso;
	private WebElement medidaPeso;
	private Select dropdownMedidaPeso;
	private WebElement tiempo;
	private WebElement medidaTiempo;
	private Select dropdownMedidaTiempo;
	private WebElement botonCalcular;
	private WebElement resultado;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://es.calcuworld.com/deporte-y-ejercicio/calculadora-de-calorias-quemadas-en-bicicleta/");

		this.selectRitmo = this.driver.findElement(By.id("selPaceWFM"));
		this.dropdownSelectRitmo = new Select(this.selectRitmo);
		this.peso = this.driver.findElement(By.id("txtWeightWFM"));
		this.medidaPeso = this.driver.findElement(By.id("selWeightWFM"));
		this.dropdownMedidaPeso = new Select(this.medidaPeso);
		this.tiempo = this.driver.findElement(By.id("txtTimeWFM"));
		this.medidaTiempo = this.driver.findElement(By.id("selTimeWFM"));
		this.dropdownMedidaTiempo = new Select(this.medidaTiempo);
		this.botonCalcular = this.driver.findElement(By.id("btnCalculateWFM"));
		this.resultado = this.driver.findElement(By.id("divResultWFM"));

	}

	@Test
	public void caso1() {
		this.peso.clear();
		this.tiempo.clear();

		this.dropdownSelectRitmo.selectByIndex(0);

		this.peso.sendKeys("75");
		this.dropdownMedidaPeso.selectByIndex(0);
		
		this.tiempo.sendKeys("60");
		this.dropdownMedidaTiempo.selectByIndex(0);

		this.botonCalcular.click();

		assertEquals(this.resultado.getText(), "Has quemado 300 calorías");
		this.capturarPantalla("caso-1");
	}
	
	@Test
	public void caso2() {
		this.peso.clear();
		this.tiempo.clear();

		this.dropdownSelectRitmo.selectByIndex(2);

		this.peso.sendKeys("95");
		this.dropdownMedidaPeso.selectByIndex(0);
		
		this.tiempo.sendKeys("2");
		this.dropdownMedidaTiempo.selectByIndex(1);

		this.botonCalcular.click();

		assertEquals(this.resultado.getText(), "Has quemado 1520 calorías");
		this.capturarPantalla("caso-2");
	}
	
	@Test
	public void caso3() {
		this.peso.clear();
		this.tiempo.clear();

		this.dropdownSelectRitmo.selectByIndex(5);

		this.peso.sendKeys("140");
		this.dropdownMedidaPeso.selectByIndex(1);
		
		this.tiempo.sendKeys("90");
		this.dropdownMedidaTiempo.selectByIndex(0);

		this.botonCalcular.click();

		assertEquals(this.resultado.getText(), "Has quemado 1524 calorías");
		this.capturarPantalla("caso-3");
	}

	@Test
	public void caso4() {
		this.peso.clear();
		this.tiempo.clear();

		this.dropdownSelectRitmo.selectByIndex(3);

		this.peso.sendKeys("160");
		this.dropdownMedidaPeso.selectByIndex(1);
		
		this.tiempo.sendKeys("1.75");
		this.dropdownMedidaTiempo.selectByIndex(1);

		this.botonCalcular.click();

		assertEquals(this.resultado.getText(), "Has quemado 1270 calorías");
		this.capturarPantalla("caso-4");
	}

	@After
	public void tearDown() throws Exception {
		this.driver.quit();
	}

	private void capturarPantalla(String caso) {
		this.src = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("/Users/carlos.salcedo/Desktop/captura-" + caso + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
