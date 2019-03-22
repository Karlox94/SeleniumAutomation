package com.automation.starter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SinIvaTest {

	private WebDriver driver;
	private WebElement buttonSinIva;
	private WebElement buttonConIva;
	private WebElement camponum;
	private WebElement selectTipo;
	private WebElement buttonCalcular;
	private Select dropdown;
	private WebElement result;

	// String path_to_extension =
	// "C:\\Users\\Angie\\AppData\\Local\\Google\\Chrome\\User
	// Data\\Default\\Extensions\\cfhdojbkjhnklbpkdaibdccddilifddb\\3.5_0";
	// ChromeOptions chrome_options;

	@Before
	public void setUp() throws Exception {

		// this.chrome_options = new ChromeOptions();
		// this.chrome_options.addArguments("load-extension=" + path_to_extension);
		// DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability(ChromeOptions.CAPABILITY, this.chrome_options);

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		// this.driver = new ChromeDriver(capabilities);
		this.driver = new ChromeDriver();

		this.driver.get("https://es.calcuworld.com/calculadoras-financieras/calculadora-iva/");
		driver.manage().window().maximize();

		this.buttonSinIva = this.driver.findElement(By.xpath("//ul[@class='nav nav-tabs']/li[2]"));
		this.camponum = this.driver.findElement(By.xpath("//*[@id=\"profile\"]/form/div/div/input"));
		this.selectTipo = this.driver.findElement(By.xpath("//*[@id=\"profile\"]/form/select"));
		this.dropdown = new Select(this.selectTipo);
		this.buttonCalcular = this.driver.findElement(By.xpath("//*[@id=\"profile\"]/form/button"));

	}

	@Test
	public void testSinIva() throws InterruptedException {
		String cantidadSinIvaEsperada = "61,98 €";
		
		this.buttonSinIva.click();
		this.camponum.sendKeys("75");
		this.dropdown.selectByIndex(0);
		// dropdown.selectByVisibleText("IVA General (21%)");
		this.buttonCalcular.click();
		Thread.sleep(2000);
		this.result = this.driver.findElement(By.className("text-success"));
		System.out.println(this.result.getText());
		
		assertEquals(cantidadSinIvaEsperada, this.result.getText());

	}

	@After
	public void tearDown() throws Exception {
		this.driver.quit();

	}

}
