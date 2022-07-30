package com.opencart.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public void getDriver() throws Exception {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Deals')]")).click();
		
		Thread.sleep(3000);
		driver.quit();

	}
    
	

public static void main(String[] args) throws Exception {
	DriverFactory df = new DriverFactory();
	df.getDriver();
	
}
}