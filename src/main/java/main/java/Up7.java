package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class Up7 extends JFrame {
    static ArrayList<Solder> solders = new ArrayList<>();
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
        solders.add(new Solder(field, 300, 100, 0));
        solders.add(new Solder(field, 200, 200, 1));
        int i = 0;
//        while (i < 11) {
//            TimeUnit.SECONDS.sleep(1);
//            solders.get(1).move(200, 100 + i*10);
//            i++;
//        }
        solders.get(0).hp = solders.get(0).hp - 70;
        System.out.println(solders.get(0).getHp());
        System.out.println(solders.get(0).fullHp);
        System.out.println(solders.get(0).percentOfHp());


        System.out.println(solders.get(1).getHp());


    }
}
