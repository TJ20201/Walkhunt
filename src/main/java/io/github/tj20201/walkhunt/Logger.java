package io.github.tj20201.walkhunt;

import java.util.Locale;

public class Logger {
    public static void log(String message, String level) {
        char escape = (char)27;
        String reset = escape+"[0m";
        String lvl = level.toUpperCase(Locale.ROOT);
        String logfile = ""; // TODO: Use appData/roaming/Walkhunt/logs to store logfile
        if (lvl.equals("INFO")) {
            System.out.println(escape+"[37m[INFO] "+escape+"[97m"+message+reset);
            logfile += "\n[INFO] "+message;
        } else if (lvl.equals("WARNING")) {
            System.out.println(escape+"[33m[WARNING] "+escape+"[93m"+message+reset);
            logfile += "\n[WARNING] "+message;
        }
        System.out.println(logfile);
    }
}
