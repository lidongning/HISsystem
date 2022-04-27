package BaseClass;
import java.io.InputStream;
import java.util.Properties;
public class GetProperty{   
	  public static String getProperty(String key) {
		     	Properties properties = new Properties();
		     	String value=" ";
		     	try {
		    	 InputStream inputStream = GetProperty.class.getResourceAsStream("property.properties");
		    	 properties.load(inputStream);
		    	 value=(String) properties.get(key);
		     		}
		     	catch(Exception e) {
		     		e.printStackTrace(); 
		     		}
		     	 return value;
	  }
}
