/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt0.setValid();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals(0, appt0.getRecurIncrement());
      assertEquals("Birthday Party",appt0.getTitle());
      assertTrue(!appt0.getValid());
      
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
     
    
    Appt appt= new Appt(90, 80, 70, 20, 7, "Birthday Party", "This is my birthday party",
     appt.toString();
     
     assertTrue(appt.getValid());
     assertEquals(10, appt.getStartDay());
     assertEquals(01, appt.getStartMonth());
     assertEquals(2010, appt.getStartYear());
     assertEquals(20, appt.getStartHour());
     assertEquals(20, appt.getStartMinute());
     assertEquals("Birthday Party", appt.getTitle());
     assertEquals("This is my birthday party.", appt.getDescription());

}

}
