package chromeDevTools_Demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v106.fetch.Fetch;
import org.openqa.selenium.devtools.v106.fetch.model.RequestPattern;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkFailed_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		
		Optional <List<RequestPattern>> patterns = (Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(), Optional.empty()))));
		
		devtools.send(Fetch.enable(patterns, Optional.empty()));
		
		devtools.addListener(Fetch.requestPaused(), request ->
		{
			devtools.send(Fetch.failRequest(request.getRequestId(), org.openqa.selenium.devtools.v106.network.model.ErrorReason.FAILED));
			
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

	}

}
