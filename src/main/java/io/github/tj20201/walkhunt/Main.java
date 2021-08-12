package io.github.tj20201.walkhunt;

import java.lang.reflect.Array;
import java.util.Arrays;

import static io.github.tj20201.walkhunt.Logger.log;

public class Main {
    public static String version = "0.0.1";
    public static void main(String[] args) {
        String type = getArg(args, 0);
        log("You are using the "+type+" version of Walkhunt v"+version, "info");
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
