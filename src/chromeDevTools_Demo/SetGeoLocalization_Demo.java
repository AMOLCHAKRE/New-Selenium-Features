package chromeDevTools_Demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v105.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetGeoLocalization_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		
		
		
		
		/*
		 * Map <String,Object>SetLocation = new HashMap <String,Object>();
		 * SetLocation.put("latitude", 3); SetLocation.put("longitude", 40);
		 * SetLocation.put("accuracy", 1);
		 * driver.executeCdpCommand("Emulation.setGeolocationOverride",SetLocation);
		 */
		 
		 
		 devtools.send(Emulation.setGeolocationOverride(Optional.of(40), Optional.of(3), Optional.of(1)));
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title =driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println(title);

	}

}
