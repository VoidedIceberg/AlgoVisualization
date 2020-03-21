package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Updater {

    private Timer time;
    private JPanel panel;
    private JFrame frame;
    private Bar[] bars;

    public Updater(JFrame frame) {
        this.frame = frame;
        bars = generateBarArray(100,frame);
        quickSort(bars, 0, bars.length - 1);
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                bubleSort();
                update();
            }
        };
        time = new Timer(1000 / 10000 /* frame rat*/, al);
        time.start();
    }

    public void update() {
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g.drawString("Swaps Made: " + moves, 700, 100);
                for (int i = 0; i < bars.length; i++) {
                    g.fillRect(bars[i].locationX, bars[i].locationY, bars[i].height, bars[i].lengnth);
                }
            }
        };
        frame.add(panel);
        frame.validate();
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    int sort = 0;
    int moves = 0;

    public void bubleSort() {
        if (sort < 99) {

            if (bars[sort].height > bars[sort + 1].height) {
                swap(sort, sort + 1);
            } else {
                sort++;
            }
        } else {
            sort = 0;
        }
    }

    public void quickSort(Bar arr[], int low, int high) {
        if (low < high) {
            int pi = partition(bars, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Bar[] arr, int low, int high) {

        int pivot = arr[high].height;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].height < pivot) {
                i++;
                int temp = arr[i].height;
                arr[i].height = arr[j].height;
                arr[j].height = temp;
            }
            update();
        }
        int temp = arr[i + 1].height;
        arr[i + 1].height = arr[high].height;
        arr[high].height = temp;

        return i + 1;
    }


    public void swap(int loc1, int loc2) {
        int temp = bars[loc1].height;
        bars[loc1].height = bars[loc2].height;
        bars[loc2].height = temp;
        moves++;
    }
    public static Bar[] generateBarArray(int nuumber, JFrame frame)
    {
        Random random = new Random();
        Bar[] bars = new Bar[nuumber];
        int height = frame.getHeight();
        int width = frame.getWidth() / nuumber;
        for(int i = 0; i < nuumber; i++)
        {
            bars[i] = new Bar(width, random.nextInt(height), 0, width*i);
        }
        return bars;
    }
}

