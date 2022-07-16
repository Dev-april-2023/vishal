package practice.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TakeScreenshot {

	
	WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	  public void takeScreenShot() throws IOException {
		  
		  TakesScreenshot ts = (TakesScreenshot)driver;
		  
		  File scr = ts.getScreenshotAs(OutputType.FILE);
		  File trg = new File(".//datafiles//screenshots.png");
		  FileUtils.copyFile(scr, trg);
		  
		  
	  }
	  
	  public void javaScript() {
		  
		  WebElement element;
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  //js.executeAsyncScript("arguments[0].click();", element);
		  
		  js.executeScript("return document.title;").toString();
		  
		  js.executeScript("alert(js ALert)");
		  js.executeScript("history.go(0)");
		  
		  js.executeScript("window.ScrollTo(0,document.body.ScrollHeight)");
		  js.executeScript("window.ScrollTo(0,-document.body.ScrollHeight)");
				  
		 }
	  
	  public void copyfileToClipBoard() {
		  
		//  StringSelection ss = new StringSelection("filepath");
		  
		  
		  
	  }
}
