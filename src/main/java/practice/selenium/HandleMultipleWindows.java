package practice.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleWindows {

	
	
	
	
	public void windowHandles() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		
		
		String ParentWindow = driver.getWindowHandle();
		//http://demo.automationtesting.in/Windows.html
		driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-d5cad06 elementor-widget elementor-widget-html']//button[@id='button1']")).click();

		Set<String> childwindows = driver.getWindowHandles();
		List<String> list =new ArrayList<String>(childwindows);
		
		for(String ele: list) {
			System.out.println(ele);
			if(!ParentWindow.equals(ele)) {
				driver.switchTo().window(ele);
				driver.manage().window().maximize();
				Thread.sleep(3000);
				String title = driver.getTitle();
				System.out.println(title);
				driver.findElement(By.xpath("//span[@class='elementor-button-text'][normalize-space()='Java For Automation']")).click();
				Thread.sleep(5000);
			}
			
			}
		driver.quit();
		
}
	
	public void frameHandles() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		Thread.sleep(3000);
		driver.close();
		
		
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		HandleMultipleWindows hmw = new HandleMultipleWindows();
		hmw.windowHandles();
		
		}
		

	}


