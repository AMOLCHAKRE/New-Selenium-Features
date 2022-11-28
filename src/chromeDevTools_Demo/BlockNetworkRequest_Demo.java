package chromeDevTools_Demo;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;

import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BlockNetworkRequest_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		DevTools devtools =driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devtools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		
		 long starttime = System.currentTimeMillis();
		  driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		  driver.findElement(By.cssSelector(".btn.btn-lg")).click();
		  driver.findElement(By.linkText("Selenium")).click();
		  driver.findElement(By.cssSelector(".add-to-cart")).click(); 
		  String carttext = driver.findElement(By.cssSelector(".sp")).getText();
		  
		  System.out.println(carttext);
		 
		  long endtime = System.currentTimeMillis();
		  
		  System.out.println(endtime - starttime);  //-3088 //4132
		
		//driver.get("https://www.amazon.in/");
		

	}

}
