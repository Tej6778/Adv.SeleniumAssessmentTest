package com.AdvSeleniumAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Question3 {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\tejas\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/webtables");

	String name = "Alden";
	//For Delete
//	driver.findElement(By.xpath("//*[text()='"+name+"']/following-sibling::div[6]/div/span[2]")).click();
//	Thread.sleep(2000);

	// For Edit
	WebElement usernamee = driver.findElement(By.xpath("//div[text()='" + name + "']"));
		if (usernamee.isDisplayed()) {
			driver.findElement(By.xpath("//*[text()='" + name + "']/following-sibling::div[6]/div/span[1]")).click();
			Thread.sleep(2000);
			
//			driver.findElement(By.id("firstName")).sendKeys("test");
		}
	}
}

