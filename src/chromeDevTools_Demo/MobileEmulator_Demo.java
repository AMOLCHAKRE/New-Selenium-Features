package chromeDevTools_Demo;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v105.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileEmulator_Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		
		//Send command to CDP methods--> CDP methods will invoke and get access to chrome DevTools
		
		devtools.send(Emulation.setDeviceMetricsOverride(400, 153, 75,true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		 driver.get("https://www.guru99.com/");
		 driver.findElement(By.cssSelector(".menu-toggle-icon")).click();
		 Thread.sleep(3000);
		 //driver.findElement(By.xpath("//*[@id=\"mobile-menu\"]/li[2]/div/a")).click();
	}

}
