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
    
    public void control(final int a) {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                makeKeyAction(e);
            }

            public void makeKeyAction(KeyEvent e) {

                int code = e.getKeyCode();
                int x = solders.get(a).getX();
                int y = solders.get(a).getY();

                switch (code) {
                    case KeyEvent.VK_UP: // вверх
                        solders.get(a).move(x, y - 5);
                        break;
                    case KeyEvent.VK_LEFT: // влево
                        solders.get(a).move(x - 5, y);
                        break;
                    case KeyEvent.VK_RIGHT: // вправо
                        solders.get(a).move(x + 5, y);
                        break;
                    case KeyEvent.VK_DOWN: // вниз
                        solders.get(a).move(x, y + 5);
                        break;
                    case KeyEvent.VK_ENTER:
                        Solder enemy = solders.get(a).findTarget();
                        if (enemy != null) {
                            solders.get(a).shoot(enemy);
                        }

                    default:

                }
            }
        });
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
        solders.add(new Solder(field, 400, 200, 1));
        solders.add(new Solder(field, 200, 400, 0));
        System.out.println(solders.get(1).getTurn());
        TimeUnit.MILLISECONDS.sleep(500);
//        Solder target = solders.get(0).findTarget();
//            if (target != null) {
//                solders.get(0).shoot(solders.get(0).findTarget());
//            }
        while (i < 11) {
            TimeUnit.SECONDS.sleep(1);
            field.control(0);
            i++;
        }        
        int i = 0;
        int a;

    }
}

