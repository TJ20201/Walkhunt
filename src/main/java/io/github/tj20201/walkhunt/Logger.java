package io.github.tj20201.walkhunt;

import java.util.Locale;

public class Logger {
    public static void log(String message, String... info) {
        String level = info.length > 1 ? info[0] : "info";
        String causer = info.length > 1 ? info[1] : "Walkhunt";
        char escape = (char)27;
        String reset = escape+"[0m";
        String lvl = level.toUpperCase(Locale.ROOT);
        String logfile = ""; // TODO: Use appData/roaming/Walkhunt/logs to store logfile
        if (lvl.equals("INFO")) {
            System.out.println(escape+"[37m["+causer+"][INFO] "+escape+"[97m"+message+reset);
            logfile += "\n"+causer+"[INFO] "+message;
        } else if (lvl.equals("WARNING")) {
            System.out.println(escape+"[33m["+causer+"][WARNING] "+escape+"[93m"+message+reset);
            logfile += "\n"+causer+"[WARNING] "+message;
        } else if (lvl.equals("ERROR")) {
            System.out.println(escape+"[31m["+causer+"][ERROR] "+escape+"[91m"+message+reset);
            logfile += "\n"+causer+"[ERROR] "+message;
        } else if (lvl.equals("FATAL")) {
            System.out.println(escape+"[35m["+causer+"][FATAL] "+escape+"[95m"+message+reset);
            logfile += "\n"+causer+"[FATAL] "+message;
        }
    }
}
