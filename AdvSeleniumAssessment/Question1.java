package com.AdvSeleniumAssessment;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class Question1 {
public static void main(String[] args) throws InterruptedException, IOException {
	
System.setProperty("webdriver.edge.driver", "C:\\\\Users\\\\tejas\\\\edgedriver_win64\\\\msedgedriver.exe");
WebDriver driver= new EdgeDriver();

driver.get("https://demoqa.com/automation-practice-form");
Thread.sleep(1000);
driver.manage().window().maximize();
Thread.sleep(1000);
driver.findElement(By.id("firstName")).sendKeys("Tejas");
Thread.sleep(1000);
driver.findElement(By.id("lastName")).sendKeys("Gulhane");
Thread.sleep(1000);
driver.findElement(By.id("userEmail")).sendKeys("tejasgulhane2@gmal.com");
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
Thread.sleep(1000);
JavascriptExecutor up=(JavascriptExecutor)driver;
up.executeScript("window.scrollBy(0,1000)");
Thread.sleep(1000);
driver.findElement(By.id("userNumber")).sendKeys("7878787878");
Thread.sleep(1000);
driver.findElement(By.id("dateOfBirthInput")).click();
Thread.sleep(1000);

WebElement WE1= driver.findElement(By.cssSelector("select.react-datepicker__month-select"));
WebElement WE2= driver.findElement(By.cssSelector("select.react-datepicker__year-select"));
Select s1= new Select(WE1);
Select S2= new Select(WE2);
s1.selectByVisibleText("February");
S2.selectByValue("1996");
Thread.sleep(2000);

WebElement WE3= driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[3]"));
Actions A = new Actions(driver);
A.moveToElement(WE3).click().perform();

driver.findElement(By.id("subjectsInput")).sendKeys("Computer Science");
Thread.sleep(1000);

WebElement WE4=	driver.findElement(By.id("hobbies-checkbox-1"));
A.moveToElement(WE4).click().build().perform();
Thread.sleep(1000);
WebElement WE5=	driver.findElement(By.id("hobbies-checkbox-3"));
A.moveToElement(WE5).click().build().perform();
Thread.sleep(1000);


driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\tejas\\Downloads\\Image.jpg"); //for uploading file
//A.moveToElement(WE5).click().build().perform();
Thread.sleep(1000);
driver.findElement(By.id("currentAddress")).sendKeys("Surat, Gujrat");
Thread.sleep(1000);
File F1= ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
Files.copy(F1, new File("C:\\Users\\tejas\\Screenshot\\DemoQAForm.png"));

driver.quit();
	
}
}
