package org.itstep;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UkrNetTest {

	private static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		driver = new ChromeDriver();//создаем объект класса
		System.setProperty("webdriver.chrome.driver","chromedriver");//опред путь хромдрайвера
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//вызываем методы
		driver.manage().window().maximize();
		driver.get("https://www.ukr.net");	
	}

	@Test
	public void test() {
		WebElement form = driver.findElement(By.id("user-login-form"));//
		WebElement login = form.findElement(By.name("Login"));
		login.sendKeys("alex06687");
		WebElement password = form.findElement(By.name("Password"));
		password.sendKeys("qwertyqwerty6565");
		WebElement button = form.findElement(By.tagName("button"));
		button.submit();
		
		WebElement register = driver.findElement(By.id("login-block"));
		WebElement span = register.findElement(By.tagName("span"));
		String text = span.getText();
		assertEquals("alex06687@ukr.net", text);
	} 
	
	
	
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	

}
