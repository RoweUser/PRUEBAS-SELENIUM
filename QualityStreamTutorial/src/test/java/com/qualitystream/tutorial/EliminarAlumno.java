package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EliminarAlumno {
	private WebDriver driver;
	By eliminarBtnLocator = By.name("eliminar");
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/listado.php");
	}
	
	@Test
	public void testEliminar() {
		driver.findElement(eliminarBtnLocator).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Inicio", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}

}