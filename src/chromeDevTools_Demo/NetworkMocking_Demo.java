package chromeDevTools_Demo;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.fetch.Fetch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkMocking_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		devtools.addListener(Fetch.requestPaused(), request ->
		{
			if (request.getRequest().getUrl().contains("shetty"))
					{
				String mockurl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				
				System.out.println(mockurl);
				
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockurl), Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty(), Optional.empty()));
				
					}
			else {
				
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty(), Optional.empty()));
			}
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		String Testresult = driver.findElement(By.cssSelector("p")).getText();
		
		System.out.println(Testresult);

	}

}
