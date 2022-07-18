package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrarAlumno {
	private WebDriver driver;
	By nombreLocator = By.name("nombre");
	By apellidosLocator = By.name("apellidos");
	By telefonoLocator = By.name("telefono");
	By fechaNacLocator = By.name("fecha_nac");
	By correoLocator = By.name("correo");
	By guardarBtnLocator = By.name("guardar");
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/insertar.php");
	}
	
	@Test
	public void testRegistrar() {
		driver.findElement(nombreLocator).sendKeys("Alex");
		driver.findElement(apellidosLocator).sendKeys("Arapa");
		driver.findElement(telefonoLocator).sendKeys("998877445");
		driver.findElement(fechaNacLocator).sendKeys("15/05/1995");
		driver.findElement(correoLocator).sendKeys("AlAr@hotmail.com");
		driver.findElement(guardarBtnLocator).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Listado", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
}
