package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        JFrame frame = createFrame();
        Updater updater = new Updater(frame);
    }

    public static JFrame createFrame() {
        // inishilaizes the frame window
        JFrame f = new JFrame("windowed applet");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100, 100, 1000, 1000);

        // creates the content pain
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // sets the frame to be visible
        f.setVisible(true);
        return f;
    }
}
