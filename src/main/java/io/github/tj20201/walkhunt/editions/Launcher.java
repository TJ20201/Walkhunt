package io.github.tj20201.walkhunt.editions;

import io.github.tj20201.walkhunt.Main;

import javax.swing.*;

import static io.github.tj20201.walkhunt.Logger.log;

public class Launcher {
    private Object Launcher;
    String[] args = new String[10];

    public Launcher(JFrame console) {
        log("Launcher not made yet, requesting \"Client\" run", "warning", "Walkhunt Launcher");
        args[0] = "client";
        log("Client run requested!", "info", "Walkhunt Launcher");
        console.dispose();
        Main.main(args);
    }
}
