package HelperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsonMethod 
{
	@Test(enabled=true)
	public void createAcc()
	{
		Reporter.log("created",true);
	}
	
	@Test(dependsOnMethods="createAcc")
	public void EditAcc()
	{
		Reporter.log("edited",true);
	}
	
	@Test(dependsOnMethods="EditAcc")
	public void DelAcc()
	{
		Reporter.log("deleted",true);
	}
}
