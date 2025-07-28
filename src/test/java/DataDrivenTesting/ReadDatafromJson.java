package DataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDatafromJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		//parser the JSON physical file into java object using Json

		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\Admin\\Desktop\\Advance selenium\\commondata.json"));
		
		
		//Convert java object into JSON Object
		JSONObject obj1=(JSONObject)obj;
		
		//read the data using get() by passing key
		System.out.println(obj1.get("Browser"));
		System.out.println(obj1.get("Url"));
		System.out.println(obj1.get("Username"));
		System.out.println(obj1.get("password"));
		
		
		
	}

}
