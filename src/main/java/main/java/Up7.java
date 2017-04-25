package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class Up7 extends JFrame {
    static ArrayList<Solder> solders = new ArrayList<>();
    static ArrayList<Solder> deadSolders = new ArrayList<>();
    private Integer width = 800;
    private Integer height = 800;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Up7() {
        super("Карта");
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponent(), BorderLayout.CENTER);
        jcp.setBackground(Color.gray);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) throws InterruptedException {
        boolean flagNotCaptured = true;
        Up7 field = new Up7();
        field.setVisible(true);
        solders.add(new Solder(field, 200, 200, 1));
        solders.add(new Solder(field, 700, 200, 0));
        int i = 0;
        int a;
//        while (i < 11) {
//            TimeUnit.SECONDS.sleep(1);
//            solders.get(1).move(200, 100 + i*10);
//            i++;
//        }
        for(i = 0; i < 40; i++) {

            Solder target = solders.get(0).findTarget();
            if (solders.get(0).findTarget() != null) {
                solders.get(0).shoot(target);
                i = i - 1;
            } else {
                solders.get(0).move(200+10*i, 200);
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }

//        solders.add(new Solder(field, 400, 400, 0));
//        solders.add(new Solder(field, 200, 100, 1));
//        solders.add(new Solder(field, 100, 100, 2));
//        solders.add(new Solder(field, 400, 500, 3));
//        int i = 0;
//        System.out.println(solders.get(0).capturedOfFlag());
//        System.out.println(solders.get(1).capturedOfFlag());
//
//
//        while (!solders.get(1).capturedOfFlag()) {
//            TimeUnit.MILLISECONDS.sleep(200);
//            while (i < 11) {
//                solders.get(1).move(200 + (i * 10), 200 + (i * 10));
//                i++;
//            }
//        }


    }
}

