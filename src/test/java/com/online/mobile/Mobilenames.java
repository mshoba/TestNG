package com.online.mobile;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Mobilenames {
	static WebDriver driver;
	String firstmobname;
	String allname;
	char[] a=new char[90];
	
	//@DataProvider(name = "run")
	//public Object[][] url()
	//{
	//	return new Object[][] {{"samsung mobile"}};
	//	}
	
	@BeforeClass()
	public static void mob1()
	{
		WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	public void mob2() throws Throwable
	{
		//Searching mobile name in search button
		WebElement mobilesearch = driver.findElement(By.xpath("//input[@type='text']"));
		mobilesearch.sendKeys("samsung mobile");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	public void mob3() throws Throwable
	{
		//Gettext of all the samsung mobile name
		
		List<WebElement> Allmobilename = driver.findElements(By.partialLinkText("Samsung Galaxy"));
		Thread.sleep(2000);
		
		for(int i=0; i<Allmobilename.size(); i++)
		{
			WebElement name = Allmobilename.get(i);
			allname = name.getText();
		//	System.out.println(allname);
						
		//Excel file creation
		File names = new File("/Users/dineshvenkatraman/eclipse-workspace/Testngmobile/src/test/resources/test.xlsx");
		FileInputStream f1 = new FileInputStream(names);
		
		XSSFWorkbook workbook = new XSSFWorkbook(f1);
		Sheet s = workbook.getSheet("Sheet1");
		Row r = s.createRow(i);
		Cell c = r.createCell(1);
		c.setCellValue(allname);
		FileOutputStream f2=new FileOutputStream(names);
	    workbook.write(f2);
		}
	}
	public void mob4() throws InterruptedException, IOException
	{
		
		//Clicking first mobile
		FileWriter file=new FileWriter("/Users/dineshvenkatraman/eclipse-workspace/Testngmobile/src/test/resources/tes.txt");
		
		WebElement firstclickmob = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
		Thread.sleep(1000);
		firstclickmob.click();
		String child = driver.getWindowHandle();
		firstmobname = firstclickmob.getText();
		
		file.write(firstmobname);
		file.close();
		System.out.println("The text file vale: "+firstmobname);
			
	}
	
	public void mob5() throws InterruptedException, Throwable
	{
		
		List<WebElement> Allmobilename = driver.findElements(By.partialLinkText("Samsung Galaxy"));
		Thread.sleep(2000);
		
		for(int i=0; i<Allmobilename.size(); i++)
		{
			long startTime = Calendar.getInstance().getTimeInMillis();
		      
			WebElement name = Allmobilename.get(i);
			String allname1 = name.getText();
			//System.out.println(allname1);
						
		//Excel file creation
		File names = new File("/Users/dineshvenkatraman/eclipse-workspace/Testngmobile/src/test/resources/Book2.xlsx");
		FileInputStream f1 = new FileInputStream(names);
		
		XSSFWorkbook workbook = new XSSFWorkbook(f1);
		Sheet s = workbook.getSheet("Sheet1");
		Row r = s.createRow(i);
		Cell c = r.createCell(1);
		c.setCellValue(allname1);
		FileOutputStream f2=new FileOutputStream(names);
	    workbook.write(f2);
        FileWriter file=new FileWriter("/Users/dineshvenkatraman/eclipse-workspace/Testngmobile/src/test/resources.txt");
		
		WebElement firstclickmob = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
		Thread.sleep(1000);
		firstclickmob.click();
		String child = driver.getWindowHandle();
		String firstmobname1 = firstclickmob.getText();
		
		file.write(firstmobname1);
		file.close();
		System.out.println("The text file vale: "+firstmobname1);
		
	    
		System.out.println("The Assert Result");
		
		SoftAssert st =new SoftAssert();
		
		st.assertEquals(allname1, firstmobname1);
		
		long endTime = Calendar.getInstance().getTimeInMillis();
	      System.out.println("Time taken: " + (endTime - startTime) + " ms");
		
	}
		
}
	@AfterMethod()
	public void mob6()
	{
		long startTime1 = Calendar.getInstance().getTimeInMillis();
		long endTime1 = Calendar.getInstance().getTimeInMillis();
	      System.out.println("Time taken: " + (endTime1 - startTime1) + " ms");
	}
	
}
