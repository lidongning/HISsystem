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
	//ɾ�����ݿ�ġ�������
	
}
  @Test(description="��¼�ٶ���ҳ1")
  public void atest() {
	    boolean flag=false;
		driver=Login.ChromeLogin(driver); 
		WebElement button=FindElementMethod.ByxpathMethod(driver,"button01");
		button.click();
		WebElement location =FindElementMethod.ByidMethod(driver,"id");
		if(location.getText().equals("����Ѷ")) {
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
		//ɾ�����ݿ�ġ�������
	  
  }

}
