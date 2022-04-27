package Baidu;

import org.testng.annotations.Test;
import LoginPage.Login;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import  BaseClass.*;

public class BaiduTest {
	
public static WebDriver driver;	

@BeforeClass
public void beforeClass() {
	//删除数据库的。。。。
	
}
  @Test(description="登录百度首页1")
  public void atest() {
	    boolean flag=false;
		driver=Login.ChromeLogin(driver); 
		WebElement button=FindElementMethod.ByxpathMethod(driver,"button01");
		button.click();
		WebElement location =FindElementMethod.ByidMethod(driver,"id");
		if(location.getText().equals("搜资讯")) {
			flag=true;
		}else {
			flag=false;
		}
		driver.close();
	   Assert.assertEquals(flag,true); 
  }
 
	
  @AfterClass
  public void afterClass() {
	     driver.quit();
		//删除数据库的。。。。
	  
  }

}
