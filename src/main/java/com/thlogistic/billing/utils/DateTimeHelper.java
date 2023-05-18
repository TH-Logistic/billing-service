package com.thlogistic.billing.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
    public static String getCurrentTimeFormatted() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Const.dateTimeFormat);
        return now.format(formatter);
    }
}
