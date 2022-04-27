package Listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;


//º‡Ã˝÷ÿ≈‹µƒ”√¿˝
public class RetryListener implements IAnnotationTransformer {
	@SuppressWarnings("rawtypes")
	//@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		IRetryAnalyzer iRetryAnalyzer = annotation.getRetryAnalyzer();
        if(iRetryAnalyzer==null){
        	annotation.setRetryAnalyzer(Testngretry.class);
        }
	}

}
