package io.github.tj20201.walkhunt;

import io.github.tj20201.walkhunt.editions.Client;
import io.github.tj20201.walkhunt.editions.Server;

import static io.github.tj20201.walkhunt.Logger.log;


public class Main {
    public static String version = "0.0.1";
    public static void main(String[] args) {
        String type = getArg(args, 0);
        log("You are using the "+type+" version of Walkhunt v"+version, "info");
        if (type.equals("client")) {
            Client whost = new Client();
        } else if (type.equals("server")) {
            try {
                Server whost = new Server();
            } catch(Exception e) {
                e.printStackTrace();
            }
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
