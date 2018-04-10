package vn.com.hn.management.wife.huy_dq.managementofwife;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class TimeStampConverter {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
