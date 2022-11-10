package com.online.mobile;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mobilerealme {
	
	static WebDriver driver;
	@Test
	public static void mob1()
	{
		WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	@Test
	public void mob2() throws Throwable
	{
		//Searching mobile name in search button
		WebElement mobilesearch = driver.findElement(By.xpath("//input[@type='text']"));
		mobilesearch.sendKeys("realme");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
