package PropertiesFileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility
{
	public String getdatafrompropertiesfile(String key) throws IOException
	{
		FileInputStream fis =new FileInputStream("./ConfigData/NinjaCredetails.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}
}
