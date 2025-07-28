package HelperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled 
{
	@Test(enabled=true)
	public void a1()
	{
		Reporter.log("a1 executed",true);
	}
	
	@Test(enabled=false)
	public void a2()
	{
		Reporter.log("a2 done",true);
	}
	
	@Test
	public void a3()
	{
		Reporter.log("a3 executed",true);
	}
}
