package Listener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//设置重跑的规则
public class Testngretry implements IRetryAnalyzer {
	
	private int retryCount=1;
    private int maxRetryCount=2;
   // @Override
    public boolean retry(ITestResult result) {
    	 if (retryCount < maxRetryCount) {
    		 System.out.println("重跑第【"+retryCount+"】次！");
             retryCount++;
             return true;
         }
         return false;
	}

}
