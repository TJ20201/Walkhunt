package io.github.tj20201.walkhunt;

// Editions
import io.github.tj20201.walkhunt.editions.Client;
import io.github.tj20201.walkhunt.editions.Launcher;
import io.github.tj20201.walkhunt.editions.Server;

// UI Stuff
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

import org.apache.commons.lang3.StringUtils;

// Logger
import static io.github.tj20201.walkhunt.Logger.getLog;
import static io.github.tj20201.walkhunt.Logger.log;



public class Main {
    public static String version = "0.0.1";
    public static JLabel consoleArea = new JLabel();

    public static void main(String[] args) {
        String type = getArg(args, 0);
        log("You are using the "+type+" version of Walkhunt v"+version, "info");
        JFrame console = new JFrame();

        try {
            console.setTitle("Console - Walkhunt " + StringUtils.capitalize(type) + " v" + version);
            console.setMinimumSize(new Dimension(500, 425));
            consoleArea.setBackground(new Color(12, 12, 31));
            consoleArea.setOpaque(true);
            consoleArea.setBounds(4, 4, (int) console.getMaximumSize().getWidth(), (int) console.getMaximumSize().getHeight());
            consoleArea.setVerticalAlignment(JLabel.TOP);
            consoleArea.setForeground(new Color(213, 213, 213));

            JScrollPane consoleScroll = new JScrollPane();
            consoleScroll.setViewportView(consoleArea);
            Border cSBorder = new LineBorder(new Color(3, 3, 21), 4, false);
            consoleScroll.setBorder(cSBorder);

            console.add(consoleScroll);
            console.setDefaultCloseOperation(console.EXIT_ON_CLOSE);
            console.setVisible(true);
        } catch(Exception e) {
            // Don't specify the console area in this log: it wont be in the console window
            log("An error occured while creating the console window: "+e.getMessage(), "error");
        }

        if (type.equals("client")) {
            Client whost = new Client();
        } else if (type.equals("server")) {
            try {
                Server whost = new Server();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if (type.equals("launcher")) {
            Launcher whost = new Launcher(console);
        }
    }

    public static String getArg(String[] args, int targInd) {
        return args[targInd];
    }
    public static void setArg(String[] args, int targInd, String replace) {
        String[] newArgs = args;
        newArgs[targInd] = replace;
        args = newArgs;
    }
}
