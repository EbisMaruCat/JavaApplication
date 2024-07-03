package lesson.four;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GetDaysTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDaysBetweenDates() throws ParseException {
        
        Date date1_1 = GetDays.validateAndParseDate("2023/03/04");
        Date date1_2 = GetDays.validateAndParseDate("2023/03/06");
        assertEquals(2,GetDays.getDaysBetweenDates(date1_1,date1_2));
        Date date2_1 = GetDays.validateAndParseDate("2023/03/30");
        Date date2_2 = GetDays.validateAndParseDate("2023/04/01");
        assertEquals(2,GetDays.getDaysBetweenDates(date2_1,date2_2));
        
    }
}