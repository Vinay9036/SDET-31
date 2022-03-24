package com.crm.vtiger.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginUsingParameterTest {
	@Test
	public void login() {
		WebDriver driver = null;
		if(System.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(System.getProperty("browser").contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("Enter valid browser");
		}
		
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(System.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(System.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a= new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

		}
	}


