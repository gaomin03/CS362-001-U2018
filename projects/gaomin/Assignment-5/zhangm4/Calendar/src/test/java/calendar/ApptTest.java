/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Arrays;
import java.io.*;

import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;




public class ApptTest  {
    
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
  @After
  public void resetStdErr() {
        System.setErr(System.err);
    }
    
    
    
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
  }
  
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Appt appt0 = new Appt(12, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals("\t14/12/2018 at -1:-1am ,Birthday Party, This is my birthday party\n", string0);
      }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Appt appt0 = new Appt(2, 2, 8, 8, 2018, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }
      
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Appt appt0 = new Appt(4, 4, 4, 4, 2020, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Appt appt0 = new Appt(-1, 3, 3, 3, 100, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Appt appt0 = new Appt(24, 3, 3, 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
    }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Appt appt0 = new Appt(3, 60, 3, 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Appt appt0 = new Appt(3, -1, 3, 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 0, 3, 1000, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, (CalendarUtil.NumDaysInMonth(3, 3-1)+1), 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
    }
  
  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 3, 0, 1000, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
    }
  
  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 3, 13, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
    }
      
  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 3, 3, 0, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
    }
    

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Appt appt0 = new Appt(12, 20, 9, 14, 2018, null, "This is a meeting", "work@gmail.com");
      String string0 = appt0.getTitle();
      assertEquals("", string0);
    }
  
  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Appt appt0 = new Appt(12, 20, 9, 14, 2018, "Meeting", null, "work@gmail.com");
      String string0 = appt0.getDescription();
      assertEquals("", string0);
    }
      
  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 3, 13, 3, "Meeting", "This is a meeting", null);
      String string0 = appt0.getEmailAddress();
      assertEquals("", string0);
    }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 3, 13, 3, "Meeting", "This is a meeting", "work@gmail.com");
      String string0 = appt0.getEmailAddress();
      assertEquals("work@gmail.com", string0);
    }
    
  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 3, 13, 3, "Meeting", "This is a meeting", "work@gmail.com");
      assertEquals(null, appt0.getXmlElement());
    }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Appt appt0 = new Appt(9, 15, 8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      assertFalse(appt0.isOn(4, 15, 2015));
    }
    
  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Appt appt0 = new Appt(9, 15, 8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      assertFalse(appt0.isOn(8, 5, 2015));
    }
   
  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Appt appt0 = new Appt(9, 15, 8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      assertFalse(appt0.isOn(8, 15, 2010));
    }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Appt appt0 = new Appt(9, 15, 8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      assertFalse(appt0.isOn(4, 5, 2015));
    }
  
  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Appt appt0 = new Appt(9, 15, 8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      assertTrue(appt0.isOn(8, 15, 2015));
    }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Appt appt0 = new Appt(10, 20, 10, 8, 2015, "Party", "Some party", "party@gmail.com");
      appt0.setValid();
      String string0 = appt0.toString();
      assertTrue(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Appt appt0 = new Appt(0, 0, 10, -100, 2015, "Party", "Some party", "party@gmail.com");
      appt0.setValid();
      String string0 = appt0.toString();
      assertFalse(appt0.getValid());
    }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Appt appt0 = new Appt(0, 3, 3, 3, 100, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }
  
  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Appt appt0 = new Appt(3, 0, 3, 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 1, 2, 1600, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 3, 1, 1600, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 3, 3, 1, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Appt appt0 = new Appt(9, 15, 8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      assertTrue(appt0.hasTimeSet());
    }
    
  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Appt appt0 = new Appt(8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      assertFalse(appt0.hasTimeSet());
    }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Appt appt0 = new Appt(8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      int[] recurDaysArr = {2, 3, 5};
      appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
      assertTrue(appt0.isRecurring());
    }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Appt appt0 = new Appt(8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      int[] recurDaysArr = null;
      appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
      assertTrue(appt0.isRecurring());
    }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Appt appt0 = new Appt(8, 15, 2015, "Meeting", "This is a meeting", "work@gmail.com");
      assertFalse(appt0.isRecurring());
    }
    
  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Appt appt0 = new Appt(23, 3, 3, 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Appt appt0 = new Appt(3, 59, 3, 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, CalendarUtil.NumDaysInMonth(3, 3-1), 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Appt appt0 = new Appt(3, 3, 3, 12, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
    }
    
  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      System.setErr(new PrintStream(errContent));
      Appt appt0 = new Appt(-40, 3, -500, 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      String string0 = appt0.toString();
      String string1 = errContent.toString();
      string1 = string1.replaceAll("\\s", "");
      assertEquals("Thisappointmentisnotvalid", string1);
    }
    
    
  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      System.setErr(new PrintStream(errContent));
      Appt appt0 = new Appt(3, 3, 3, 3, 3, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      String string0 = appt0.toString();
      assertEquals("", errContent.toString());
    }
      
      

}
