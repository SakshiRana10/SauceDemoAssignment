package TestDataReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class TestDataReader {

	    public HashMap<String,String> configFileReader(){
	    	HashMap<String, String>  configData = new HashMap<String, String>();
	        try {
	            Properties prop = new Properties();
	            InputStream inputStream = new FileInputStream("/Users/Sakshi.Rana/eclipse-workspace/mavenproject/Config/configrations.properties");
	            prop.load(inputStream);
	            configData.put("url", prop.getProperty("url"));
	            configData.put("lockedUsername", prop.getProperty("lockedUsername"));
	            configData.put("StandardUsername", prop.getProperty("StandardUsername"));
	            configData.put("password", prop.getProperty("password"));
	            return configData;
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
}
