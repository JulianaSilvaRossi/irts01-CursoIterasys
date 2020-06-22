package siteIterasys;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cursos {
	String url;
	WebDriver driver;

	@Before
	public void start() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chrome/83/chromedriver.exe");
		driver = new ChromeDriver();         
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		url = "https://iterasys.com.br/";
	}

	@After
	public void finish() {
		driver.quit();
	}

	@Test
	public void seachCourse() {
		
		//Home Page
		driver.get(url);
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis"));
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
		
		// Courses List
		driver.findElement(By.cssSelector(".comprar")).click();
		
		// Carrinho Page
		String title = "Mantis";
		String price = "R$ 49,99";
		
		assertEquals(title, driver.findElement(By.cssSelector(".item-title")).getText());
		assertEquals(price, driver.findElement(By.cssSelector(".new-price")).getText());
	}

}
