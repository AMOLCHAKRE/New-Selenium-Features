package chromeDevTools_Demo;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.devtools.v106.network.model.Request;
import org.openqa.selenium.devtools.v106.network.model.Response;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkLog_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromiumdriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devtools.addListener(Network.requestWillBeSent(), request ->
		
		{
			Request req =request.getRequest();
			
			System.out.println(req.getUrl());
			
		});
		
		//Event will get fired
		
		devtools.addListener(Network.responseReceived(), response->  
				{
					Response res =response.getResponse();
					
					System.out.println(res.getUrl());
					//System.out.println(res.getStatus());
					
					if (res.getStatus().toString().startsWith("4"))
						
					{
						System.out.println(res.getUrl()+"Failing with status code"+res.getStatus());
					}
			
				});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
	}

}
