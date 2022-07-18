package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuscarAlumno {
	private WebDriver driver;
	By buscarLocator = By.name("buscar");
	By buscarBtnLocator = By.name("btn_buscar");
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/buscar.php");
	}
	
	@Test
	public void testBuscar() {
		WebElement searchbox = driver.findElement(By.name("buscar"));
		searchbox.clear();
		searchbox.sendKeys("Rodrigo");
		driver.findElement(buscarBtnLocator).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Arturo - Inicio", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
}