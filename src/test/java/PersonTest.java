import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.IDataProviderMethod;
import org.testng.annotations.DataProvider;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.testng.Assert.assertEquals;

public class PersonTest {

    void currentTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ssss");
        System.out.println(dateFormat.format(calendar.getTime()));
    }

    @BeforeClass
    void beforeClass() {
        System.out.print("BeforeClass");
        currentTime();
    }

    @AfterClass
    void afterTime() {
        System.out.print("AfterClass");
        currentTime();
    }

    @DataProvider(name = "testAge")
    Object[][] testAge() {
        return new Object[][] {

                {-1, false},
                {0, false},
                {12, false},
                {13,true},
                {15,true},
                {18,true},
                {19,false},
                {20,false}
        };
    }

    @Test(dataProvider = "testAge")
    void testTeenager(int age, boolean expected) {
        boolean result = Person.isTeenager(age);
        assertEquals(result, expected);
    }


}
