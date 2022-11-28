package chromeDevTools_Demo;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthentication_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Predicate - Java-8 used for filtering the data
		
	Predicate<URI> prdicateuri =	uri -> uri.getHost().contains("httpbin.org");
	
	((HasAuthentication)driver).register(prdicateuri, UsernameAndPassword.of("user", "passwd"));
		
		driver.get("http://httpbin.org/basic-auth/user/passwd");
		
		
	}

}
