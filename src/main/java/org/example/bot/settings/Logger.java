package org.example.bot.settings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public void log(String txt) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.print(dateFormat.format(date));
        System.out.println(", " + txt + "\n");
    }
}