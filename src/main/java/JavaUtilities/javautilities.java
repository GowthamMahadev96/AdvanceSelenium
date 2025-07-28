package JavaUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautilities 
{
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomcount = random.nextInt(10000);
		return randomcount;
		
	}

	public String getCurrentDate()
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("MM-dd-yyyy");
		String currentdate = sim.format(date);
		return currentdate;
	}

	public String togetRequired(int days)
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("MM-dd-yyyy");
		sim.format(date);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String daterequired = sim.format(cal.getTime());
		return daterequired;
	}



}
