
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      
      public void test02()  throws Throwable  {
          DataHandler dataH = new DataHandler("Birth Day", false);
          GregorianCalendar cal1 = new GregorianCalendar();
          GregorianCalendar cal2 = new GregorianCalendar();
          cal1.set(2018, 9, 14);
          cal2.set(2018, 9, 17);
          List<CalDay> temp;
          Appt appt0 = new Appt(90, 80, 70, 20, 7, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
          appt0.setValid();
          temp = dataH.getApptRange(cal1, cal2, true);
          dataH.deleteAppt(appt0);
      
    
      

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      
      DataHandler dataH = new DataHandler();
      GregorianCalendar cal1 = new GregorianCalendar();
      GregorianCalendar cal2 = new GregorianCalendar();
      cal1.set(2018, 9, 14);
      cal2.set(2018, 9, 17);
      
      List<CalDay> temp;
      temp = dataH.getApptRange(cal1, cal2, false);
      Appt appt1 = new Appt(4, 1, 2, 2, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      Appt appt2 = new Appt(3, 3, 3, 7, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      dataH.saveAppt(appt1);
      dataH.saveAppt(appt2);
      temp = dataH.getApptRange(cal1, cal2, false);
      dataH.deleteAppt(appt1);
      
      
  }

}
