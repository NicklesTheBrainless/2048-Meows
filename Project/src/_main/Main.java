package _main;

import _main.panel.GamePanel;

import javax.swing.*;

import static _main.resource._Resources.ICON;
import static _main.setting._Settings.TITLE;

public class Main {

    public static void main(String[] args) {

        // create window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set title and if it is resizable
        window.setTitle(TITLE);
        window.setResizable(false);

        // create the GamePanel and add it to the window
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        // set icon image
        window.setIconImage(ICON);

        // position the window in the center of the screen and make it visible
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // start game
        gp.startProgramThread();
    }
}