package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementMethod {
	
	public static WebElement ByxpathMethod(WebDriver driver,String xpath) {
		WebElement location = driver.findElement(By.xpath(GetProperty.getProperty(xpath))); 
		try {
		if(location==null) {
			System.out.print("元素未找到！");
		}
	}catch(Exception e) {
		e.printStackTrace(); 
	   }
		return  location;
	}
	public static WebElement ByidMethod(WebDriver driver,String id) {
		WebElement location = driver.findElement(By.id(GetProperty.getProperty(id))); 
		try {
		if(location==null) {
			System.out.print("元素未找到！");
		}
	}catch(Exception e) {
		e.printStackTrace(); 
	   }
		return  location;
	}
	
	
	
	
	
	
}
