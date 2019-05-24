package com.votingsystem.easyelection.utils;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeUtils implements Serializable {

    public static Instant instantFromDateString(String timestamp) {
        if (StringUtils.isEmpty(timestamp)) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        TemporalAccessor temporalAccessor = formatter.parse(timestamp);
        return Instant.from(temporalAccessor);
    }

    public static String stringFromInstant(Instant instant) {
        if (instant == null) return null;
        return instant.toString();
    }
}
