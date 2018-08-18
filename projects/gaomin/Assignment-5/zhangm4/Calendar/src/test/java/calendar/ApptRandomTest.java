package calendar;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 100 * 100 * 1;
	private static final int NUM_TESTS=100;

    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"Title","Recurrence"};

    	int n = random.nextInt(methodArray.length);

        return methodArray[n] ;
        }

    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};

    	int n = random.nextInt(RecurArray.length);
        return RecurArray[n] ;
        }

    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};

    	int n = random.nextInt(RecurArray.length);
        return RecurArray[n] ;
        }


	 @Test
	  public void randomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random, -10, 30);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 70);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -10, 35);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -10, 18);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -10, 2019);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";


		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);

				appt.setValid();

				appt.isOn(startDay, startMonth, startYear);

				int someDay=ValuesGenerator.getRandomIntBetween(random, -10, 32);
				int someMonth=ValuesGenerator.getRandomIntBetween(random, -10, 17);
				int someYear=ValuesGenerator.getRandomIntBetween(random, -10, 2019);
				appt.isOn(someMonth, someDay, someYear);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 1, 10);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   if(ValuesGenerator.getBoolean(.40f, random)) {
						   		appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
							} else {
								appt.setRecurrence(null, recur, recurIncrement, recurNumber);
							}
						}
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");
	 }


	 @Test
	  public void randomtest1()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random, -10, 30);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 70);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -10, 35);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -10, 18);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -10, 2019);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";


		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);

				appt.setValid();

				appt.isOn(startDay, startMonth, startYear);

				int someDay=ValuesGenerator.getRandomIntBetween(random, -10, 32);
				int someMonth=ValuesGenerator.getRandomIntBetween(random, -10, 17);
				int someYear=ValuesGenerator.getRandomIntBetween(random, -10, 2019);
				appt.isOn(someMonth, someDay, someYear);

			 if(!appt.getValid())continue;
		   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 1, 10);
		   int[] recurDays=null;
		   int recur=ApptRandomTest.RandomSelectRecur(random);
		   int recurIncrement = ValuesGenerator.RandInt(random);
		   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
			 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
		        if((iteration%10000)==0 && iteration!=0 )
		              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");
	 }


	 @Test
	  public void randomtest2()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis();
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random, -10, 33);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 70);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -10, 32);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -10, 20);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -10, 2019);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";


				 Appt appt = new Appt(startHour,
						  startMinute ,
						  startDay ,
						  startMonth ,
						  startYear ,
						  title,
						 description,
						 emailAddress);

				appt.setValid();

				appt.isOn(startDay, startMonth, startYear);

				int someDay=ValuesGenerator.getRandomIntBetween(random, -10, 22);
				int someMonth=ValuesGenerator.getRandomIntBetween(random, -10, 19);
				int someYear=ValuesGenerator.getRandomIntBetween(random, -10, 2019);
				appt.isOn(someMonth, someDay, someYear);

				boolean checkValid;

				if (startMonth < 1 || startMonth > 12)
					checkValid = false;
				else if (startHour < 0 || startHour > 23)
					checkValid = false;
				else if (startMinute < 0 || startMinute > 59)
					checkValid = false;
				else if (startYear <= 0)
					checkValid = false;
				else {
					int NumDaysInMonth = CalendarUtil.NumDaysInMonth(startYear, startMonth - 1);
					if (startDay < 1 || startDay > NumDaysInMonth)
						checkValid = false;
					else
						checkValid = true;
				}


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			}
		}catch(NullPointerException e){

		}
	 }
}
