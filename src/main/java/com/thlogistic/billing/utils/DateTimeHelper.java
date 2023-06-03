package com.thlogistic.billing.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
    public static Long getCurrentTimeInEpoch() {
        return System.currentTimeMillis();
    }
}
