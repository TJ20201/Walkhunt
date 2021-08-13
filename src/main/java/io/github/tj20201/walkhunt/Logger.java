package io.github.tj20201.walkhunt;

import javax.swing.*;
import java.util.Locale;

public class Logger {
    private static String logfile;

    public static void log(String message, Object... info) {
        String level = info.length > 0 ? (String) info[0] : "info";
        String causer = "Walkhunt";
        if (info.length > 1) {
            if (info[1] == null) {
                causer = "Walkhunt";
            } else {
                causer = (String) info[1];
            }
        }
        
        char escape = (char)27;
        String reset = escape+"[0m";
        String lvl = level.toUpperCase(Locale.ROOT);
        logfile = "";
        String logline = ""; // TODO: Use appData/roaming/Walkhunt/logs to store logfile
        if (lvl.equals("INFO")) {
            System.out.println(escape+"[37m["+causer+"][INFO] "+escape+"[97m"+message+reset);
            logline += "\n["+causer+"][INFO] "+message;
        } else if (lvl.equals("WARNING")) {
            System.out.println(escape+"[33m["+causer+"][WARNING] "+escape+"[93m"+message+reset);
            logline += "\n["+causer+"][WARNING] "+message;
        } else if (lvl.equals("ERROR")) {
            System.out.println(escape+"[31m["+causer+"][ERROR] "+escape+"[91m"+message+reset);
            logline += "\n["+causer+"][ERROR] "+message;
        } else if (lvl.equals("FATAL")) {
            System.out.println(escape+"[35m["+causer+"][FATAL] "+escape+"[95m"+message+reset);
            logline += "\n["+causer+"][FATAL] "+message;
        }

        logfile = logfile + logline;
        if (Main.consoleArea.getText() == "") {
            Main.consoleArea.setText(logline);
        } else {
            Main.consoleArea.setText("<html>" + Main.consoleArea.getText().replace("<html>", "</html>").replace("</html>", "") + "<br/>" + logline + "</html>");
        }
    }

    public static String getLog() {
        return logfile;
    }
}
