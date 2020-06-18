package DDTest.DDTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	static WebDriver driver;
	
	public static  WebDriver launch(String browser) {
		if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			driver= new ChromeDriver();
		}
		else if(browser=="firefox") {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
			driver= new ChromeDriver();
		}
		else {
			System.out.println("Please specify the desired browser");
		}
		
		return driver;
	}

}
