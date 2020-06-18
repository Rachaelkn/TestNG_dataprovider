package DDTest.DDTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Openlink {
	static WebDriver driver;
	 
	
	public static void site() {
		driver= DriverFactory.launch("firefox");
		driver.get("https://afyabora.co.ke/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

}
