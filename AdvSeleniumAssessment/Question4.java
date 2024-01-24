package com.AdvSeleniumAssessment;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class Question4 {

	public String [][] read() throws InvalidFormatException, IOException {
		String[][] Data=null;
		
		String filepath="C:\\Users\\tejas\\Desktop\\Assessment_Demo_Guru_99.com.xlsx";
		File f= new File(filepath);
		XSSFWorkbook wrkbuk= new XSSFWorkbook(f);
		Sheet sht= wrkbuk.getSheet("Sheet1");
		int nrow=sht.getPhysicalNumberOfRows();
		Data=new String[nrow][];
		for (int i = 0; i < Data.length; i++) {
			Row rw=sht.getRow(i);
			
		int col= rw.getPhysicalNumberOfCells();
		Data[i]=new String[col];
		
		for (int j = 0; j < Data[i].length; j++) {
			Cell c=rw.getCell(j);
		
		c.setCellType(CellType.STRING);;
		
		Data[i][j]=c.getStringCellValue();
		
		}
		}
		return Data;
		}
	
	
	@Test	
	public void f ()throws InterruptedException, IOException, InvalidFormatException {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\tejas\\edgedriver_win64\\msedgedriver.exe");
		
		String Data[][]=read();
		for (int i = 0; i < Data.length; i++) {
		
		WebDriver driver= new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.demo.guru99.com/V4/");
		Thread.sleep(2000);	
		driver.findElement(By.name("uid")).sendKeys(Data[i][0]);
		Thread.sleep(2000);	
		driver.findElement(By.name("password")).sendKeys(Data[i][1]);
		Thread.sleep(2000);	
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			System.out.println("Test is Pass");
	} 	else {
			System.out.println("Test is Failed");
	}
		
	
		File f= ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\tejas\\Screenshot\\demoguru.99.png"));
			
		Thread.sleep(1000);
		driver.close();
		
	}
	}
}
