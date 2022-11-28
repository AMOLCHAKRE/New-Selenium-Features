package chromeDevTools_Demo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCDP_Commands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		Map<String, Object> CDPexecutor = new HashMap<String, Object>();
		CDPexecutor.put("width", 600);
		CDPexecutor.put("height", 600);
		CDPexecutor.put("deviceScaleFactor", 75);
		CDPexecutor.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", CDPexecutor);
		
		 driver.get("https://www.guru99.com/");
		 driver.findElement(By.cssSelector(".menu-toggle-icon")).click();
		 Thread.sleep(3000);

	}

}
