package calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.util.Calendar;
import java.util.Random;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;

import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

    /**
     * Generate Random Tests that tests DataHandler Class.
     */

	 private static final long TestTimeout = 10 * 100 * 1;

     @Before
     public void setUp() {
         File testfile = new File("calendar_test.xml");
         testfile.delete();
     }

     @After
     public void tearDown() {
         File testfile = new File("calendar_test.xml");
         testfile.delete();
     }

	 @Test
	  public void randomtest()  throws Throwable  {
		  long startTime = Calendar.getInstance().getTimeInMillis();
		  long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		  System.out.println("Start testing...");

		  for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			  try{

				 long randomseed =System.currentTimeMillis();
 				 Random random = new Random(randomseed);
                  
				 boolean autosaveSet=ValuesGenerator.getBoolean(.10f, random);

 				 int startDay=ValuesGenerator.getRandomIntBetween(random, -10, 22);
 				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -10, 10);
 				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2017, 2018);
				
 				 int endDay=ValuesGenerator.getRandomIntBetween(random, -10, 12);
 				 int endMonth=ValuesGenerator.getRandomIntBetween(random, -10, 21);
 				 int endYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2019);
                  
				 int numAppts=ValuesGenerator.getRandomIntBetween(random, -10, 11);
                  
				 DataHandler data0 = new DataHandler("calendar_test.xml", autosaveSet);
				 GregorianCalendar firstday = new GregorianCalendar(startYear, startMonth, startDay);
				 GregorianCalendar lastday = new GregorianCalendar(endYear, endMonth, endDay);

				 if(ValuesGenerator.getBoolean(.10f, random)) {
				 	Field f1 = data0.getClass().getDeclaredField("valid");
		         	f1.setAccessible(true);
		         	f1.set(data0, false);
			 	 }
        
				 while(numAppts > 0){
					int apptHour=ValuesGenerator.getRandomIntBetween(random, -10, 12);
					int apptMinute=ValuesGenerator.getRandomIntBetween(random, -10, 30);
					int apptDay=ValuesGenerator.getRandomIntBetween(random, -10, 15);
					int apptMonth=ValuesGenerator.getRandomIntBetween(random, -10, 24);
					int apptYear=ValuesGenerator.getRandomIntBetween(random, 2017, 2019);

					Appt appt0 = new Appt(apptHour, apptMinute, apptDay, apptMonth, apptYear, "Event", "This event.", "home@google.com");

					int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
					int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
					int recur=ApptRandomTest.RandomSelectRecur(random);
					int recurIncrement = ValuesGenerator.RandInt(random);
					int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
					appt0.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

				 	appt0.setValid();
                     
					if(ValuesGenerator.getBoolean(.50f, random)) {
				 		data0.saveAppt(appt0);
					}

					if(ValuesGenerator.getBoolean(.10f, random)) {
						data0.deleteAppt(appt0);
					}

					numAppts--;
			 	 }

				 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				 calDays = (LinkedList<CalDay>) data0.getApptRange(firstday, lastday);
                  
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if(iteration!=0)
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

	 			}catch(DateOutOfRangeException e){
	 			}
			 }

			 System.out.println("Done testing...");
		 }
}
