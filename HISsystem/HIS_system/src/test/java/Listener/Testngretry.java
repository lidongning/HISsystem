package Listener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//�������ܵĹ���
public class Testngretry implements IRetryAnalyzer {
	
	private int retryCount=1;
    private int maxRetryCount=2;
   // @Override
    public boolean retry(ITestResult result) {
    	 if (retryCount < maxRetryCount) {
    		 System.out.println("���ܵڡ�"+retryCount+"���Σ�");
             retryCount++;
             return true;
         }
         return false;
	}

}
