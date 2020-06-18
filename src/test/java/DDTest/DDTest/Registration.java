package DDTest.DDTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Registration{
	static WebDriver driver;
	
	public static void data(String[] data) throws InterruptedException {
		navigate();
		Register(data);
		tear();
	}
	
	public static void navigate() throws InterruptedException {
		driver= DriverFactory.launch("chrome");
		driver.get("https://afyabora.co.ke/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		WebElement body = driver.findElement(By.tagName("body"));
		WebElement cookies = body.findElement(By.xpath("//*[@id=\"modal-cookies\"]/div/div"));
		cookies.findElement(By.tagName("button")).click();
		WebElement nav =body.findElement(By.tagName("nav"));
		List<WebElement> options = nav.findElements(By.tagName("li"));
		for(WebElement option : options) {	
			if(option.getText().contains("Register Now")) {
				option.click();
			}
		}
		WebElement choice= driver.findElement(By.className("card"));
		List<WebElement> categories= choice.findElements(By.tagName("a"));
		Thread.sleep(3000);
		for(WebElement category: categories) {
			if(category.getText().contains("Register as a Patient")) {
				category.click();
				break;
			}
		}	
		
	}
	
	public static void Register(String[]data) throws InterruptedException {
		Thread.sleep(2000);
		// identifying the web elements on the registration form
		WebElement card=driver.findElement(By.className("card-body"));
		WebElement form = card.findElement(By.tagName("form"));
		WebElement name= form.findElement(By.id("name"));
		WebElement phone = form.findElement(By.id("phone"));
		WebElement email= form.findElement(By.id("email"));
		Select county= new Select(form.findElement(By.id("county")));
		Select day= new Select(form.findElement(By.id("DOBDay")));
		Select month = new Select(form.findElement(By.id("DOBMonth")));
		Select year = new Select(form.findElement(By.id("DOBYear")));
		WebElement radio = form.findElement(By.className("col-md-6"));
		WebElement pass = form.findElement(By.id("password"));
		WebElement confirmpass = form.findElement(By.id("password-confirm"));
		WebElement submit = form.findElement(By.xpath("//*[@id=\"js-heightControl\"]/div/div/div/div/div[2]/form/div[9]/div/button"));
		
		// Filling the data in the fields
		//name.clear();
		name.sendKeys(data[0]);
		phone.sendKeys(data[1]);
		email.sendKeys(data[2]);
		county.selectByValue(data[3]);
		day.selectByValue(data[4]);
		month.selectByValue(data[5]);
		year.selectByValue(data[6]);
		form.findElement(By.xpath("//*[@id=\"js-heightControl\"]/div/div/div/div/div[2]/form/div[6]")).click();
		pass.sendKeys(data[7]);
		confirmpass.sendKeys(data[8]);
		submit.click();

	}
	public static void tear() {
		driver.quit();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	
}
