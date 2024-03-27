import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DateUtilsTestTest {

    DateUtils dateUtils;

    @BeforeAll
    public void initClass() {
        dateUtils = new DateUtils();
    }

    @AfterAll
    public void cleanClass() {
        dateUtils = null;
    }

    @Test
    public void testIsLeapYearTrue(){
        boolean resultTrue = dateUtils.isLeapYear(2020);
        assertTrue(resultTrue);
    }

    @Test void  testIsLeapYearFalse(){
        boolean resultFalse = dateUtils.isLeapYear(2021);
        assertFalse(resultFalse);
    }

    @Test
    void  testGetDaysInMonthNormalMonth(){
        assertEquals(31, dateUtils.getDaysInMonth(2024, 1)); // January
        assertEquals(29, dateUtils.getDaysInMonth(2024, 2)); // February
        assertEquals(31, dateUtils.getDaysInMonth(2024, 3)); // March
        assertEquals(30, dateUtils.getDaysInMonth(2024, 4)); // April
        assertEquals(31, dateUtils.getDaysInMonth(2024, 5)); // May
        assertEquals(30, dateUtils.getDaysInMonth(2024, 6)); // June
        assertEquals(31, dateUtils.getDaysInMonth(2024, 7)); // July
        assertEquals(31, dateUtils.getDaysInMonth(2024, 8)); // August
        assertEquals(30, dateUtils.getDaysInMonth(2024, 9)); // September
        assertEquals(31, dateUtils.getDaysInMonth(2024, 10)); // October
        assertEquals(30, dateUtils.getDaysInMonth(2024, 11)); // November
        assertEquals(31, dateUtils.getDaysInMonth(2024, 12)); // December
    }

    @Test
    public void testGetDaysInMonthFebruaryLeap(){

        int resultFebruaryLeap = dateUtils.getDaysInMonth(2020, 2);
        Assertions.assertEquals(29, resultFebruaryLeap);

    }

    @Test
    public void testGetDaysInMonthFebruaryNonLeap(){

        int resultFebruaryNonLeap = dateUtils.getDaysInMonth(2021, 2);
        Assertions.assertEquals(28, resultFebruaryNonLeap);
    }

    @Test void testGetDaysInMonthValidMonth(){
        DateUtils dateUtils = new DateUtils();
        assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getDaysInMonth(2021, 13);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getDaysInMonth(2021, 0);
        });
    }



}
