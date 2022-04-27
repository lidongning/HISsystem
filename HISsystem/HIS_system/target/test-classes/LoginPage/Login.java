package LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Login {
	
		   public static ThreadLocal<WebDriver> ThreadDriver=new ThreadLocal<WebDriver>();
			public static WebDriver ChromeLogin (WebDriver driver ){
			   try {
				  driver=ThreadDriver.get();
				  System.setProperty("webdriver.chrome.driver", "C:\\My-Files-Dn\\Google\\Chrome\\Application\\chromedriver.exe");
				  driver = new ChromeDriver();
				  driver.manage().window().maximize(); 
				  driver.get("https://hao.360.com/");
				  ThreadDriver.set(driver);
			   }catch(Exception e) {
				e.printStackTrace(); 
			   }
			   return driver;
	}
			
	public static WebDriver IELogin (WebDriver driver ){
		   try {
			  System.setProperty("webdriver.ie.driver", "C:\\My-Files-Dn\\Google\\Chrome\\Application\\chromedriver.exe");
			  driver = new ChromeDriver();
		      driver.manage().window().maximize(); 
		      driver.get("https://hao.360.com/");     
		      
		   }catch(Exception e) {
			e.printStackTrace(); 
		   }
		   return driver;
		}
}
