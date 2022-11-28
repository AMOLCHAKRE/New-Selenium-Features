package chromeDevTools_Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaConsoleLog_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.linkText("Browse Products")).click();
		
		driver.findElement(By.partialLinkText("Selenium")).click();
		
		driver.findElement(By.cssSelector(".add-to-cart")).click();
				
		driver.findElement(By.linkText("Cart")).click();
		
		driver.findElement(By.id("exampleInputEmail1")).clear();
		
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER); // Get log entries object
		
		List<LogEntry> logs = entry.getAll(); // logentries object get all method return all logs in list
		
		for (LogEntry e : logs)  // Iterating through list and print each log message
		{
			System.out.println(e.getMessage());
		}

	}

}
