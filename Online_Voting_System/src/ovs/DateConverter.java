package ovs;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class DateConverter {
    public static LocalDate sqlDateToLocalDate(java.util.Date date) {
        if (date != null) {
            Instant instant = Instant.ofEpochMilli(date.getTime());
            return instant.atZone(ZoneId.systemDefault()).toLocalDate();
        }
        return null;
    }
    public static Date localDateToSqlDate(LocalDate localDate) {
        if (localDate != null) {
            Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            return new Date(instant.toEpochMilli());
        }
        return null;
    }
}

