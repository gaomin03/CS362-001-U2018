/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.Iterator;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      
      GregorianCalendar cal = new GregorianCalendar();
      
      CalDay calday = new CalDay(cal);
      
      Iterator<?> getit;
      
      getit = calday.iterator();
      

  }
 
    
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      
      int day=23;
      int month=9;
      int year=2018;
      GregorianCalendar cal = new GregorianCalendar();
      
      
      CalDay calday = new CalDay(cal);
      
      Appt appt = new Appt(, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      
      
      java.util.LinkedList <calendar.Appt> appts2;
      
      
      String convert;
      convert = calday.toString();
      
      assertTrue(appt.getValid());
      
      
      
  }

}
