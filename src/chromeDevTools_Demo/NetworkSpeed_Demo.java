package chromeDevTools_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.devtools.v106.network.model.ConnectionType;

import com.google.common.base.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
	    DevTools devtools =	driver.getDevTools();
	    
	    devtools.createSession();
	    
	    devtools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
	    
	    devtools.send(Network.emulateNetworkConditions(false, 3000, 2000, 10000, java.util.Optional.of(ConnectionType.WIFI)));
	    
	    devtools.addListener(Network.loadingFailed(), loadingFailederror->
	    {
	    	System.out.println(loadingFailederror.getErrorText());
	    	System.out.println(loadingFailederror.getTimestamp());
	    });
	    
	   long startTime = System.currentTimeMillis();
	   driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	   driver.findElement(By.cssSelector("button[routerlink*='/library']")).click();
	   
	   long endTime = System.currentTimeMillis();
	   
	   System.out.println(endTime - startTime);

	}

}
