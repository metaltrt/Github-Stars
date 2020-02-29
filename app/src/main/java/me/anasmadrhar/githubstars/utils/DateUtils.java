package me.anasmadrhar.githubstars.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
public class DateUtils {

    @SuppressLint("SimpleDateFormat")
    public static String getDateThreeMonthsAgo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -3);
        return simpleDateFormat.format(calendar.getTime());
    }
}
