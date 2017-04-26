package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class DrawingComponent extends JPanel {


    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D) gh;
        int i = 0;

        drp.drawOval(380, 380, 40, 40);

        while (i < Up7.deadSolders.size()) {
            drawDeadSolder(drp, Up7.deadSolders.get(i), i);
            i++;
        }

        i = 0;
        while (i < Up7.solders.size()) {
            drawSolder(drp, Up7.solders.get(i), i);
            i++;
        }
    }
    
    private void drawDeadSolder(Graphics2D drp, Solder solder, int i) {
        drp.setColor(Color.gray);
        drp.fillRect(Up7.deadSolders.get(i).getX()-10, Up7.deadSolders.get(i).getY()-10,20, 20);
        drp.fillOval(Up7.deadSolders.get(i).getX()-10, Up7.deadSolders.get(i).getY()-20, 20, 20);

        drp.setColor(Color.darkGray);
        drp.fillRect(Up7.deadSolders.get(i).getX()-15, Up7.deadSolders.get(i).getY()+5,30, 5);
        switch (solder.getTeam()) {
            case 0:
                drp.setColor(Color.red);
                break;
            case 1:
                drp.setColor(Color.blue);
                break;
            case 2:
                drp.setColor(Color.green);
                break;
            case 3:
                drp.setColor(Color.yellow);
                break;
            default:
                drp.setColor(Color.black);
        }
        drp.fillRect(Up7.deadSolders.get(i).getX()-5, Up7.deadSolders.get(i).getY()-8,10, 5);
    }

    private void drawSolder(Graphics2D drp, Solder solder, int i) {
        switch (solder.getTeam()) {
            case 0:
                drp.setColor(Color.red);
                break;
            case 1:
                drp.setColor(Color.blue);
                break;
            case 2:
                drp.setColor(Color.green);
                break;
            case 3:
                drp.setColor(Color.yellow);
                break;
            default:
                drp.setColor(Color.black);
        }

        drp.fillOval(Up7.solders.get(i).getX()-10, Up7.solders.get(i).getY()-10, 20, 20);
        if (solder.percentOfHp() > 0.75) {
            drp.setColor(Color.green);
        } else if (solder.percentOfHp() > 0.25) {
            drp.setColor(Color.yellow);
        } else {
            drp.setColor(Color.red);
        }
        drp.fillRect(Up7.solders.get(i).getX()-15, Up7.solders.get(i).getY()-20, (int)(30 * Up7.solders.get(i).percentOfHp()),5);
        drp.drawRect(Up7.solders.get(i).getX()-15, Up7.solders.get(i).getY()-20, 30,5);

        drp.setColor(Color.orange);
        if (Up7.solders.get(i).running == true) {
            drp.drawOval(Up7.solders.get(i).getX()-13, Up7.solders.get(i).getY()-13, 26, 26);
        }

        switch (Up7.solders.get(i).getTurn()) { // {RIGHT = 1, LEFT = 2, TOP = 3, DOWN = 4, RIGHT_TOP = 13, LEFT_TOP = 23, RIGHT_DOWN = 14, LEFT_DOWN = 24};
            case 1:
                drp.fillOval(Up7.solders.get(i).getX()+8, Up7.solders.get(i).getY()-2, 4, 4);
                if (Up7.solders.get(i).whatGun() == 0) {
                    //draw pistol
                    drp.setColor(Color.black);
                    drp.fillRect(Up7.solders.get(i).getX(), Up7.solders.get(i).getY()+6, 10,4);
                } else if (Up7.solders.get(i).whatGun() == 1) {
                    //draw shotgun
                    drp.setColor(Color.black);
                    drp.fillRect(Up7.solders.get(i).getX()-5, Up7.solders.get(i).getY()+6, 20,4);
                    drp.setColor(Color.pink);
                    drp.fillRect(Up7.solders.get(i).getX()+5, Up7.solders.get(i).getY()+5, 8,6);
                } else if (Up7.solders.get(i).whatGun() == 2) {
                    //draw assaultrifle
                    drp.setColor(Color.black);
                    drp.fillRect(Up7.solders.get(i).getX()-5, Up7.solders.get(i).getY()+6, 20,4);
                } else if (Up7.solders.get(i).whatGun() == 3) {
                    //draw rifle
                    drp.setColor(Color.darkGray);
                    drp.fillRect(Up7.solders.get(i).getX()-5, Up7.solders.get(i).getY()+7, 30,2);
                    drp.setColor(Color.black);
                    drp.fillRect(Up7.solders.get(i).getX()-5, Up7.solders.get(i).getY()+6, 20,4);
                }
                break;

            case 2:
                drp.fillOval(Up7.solders.get(i).getX()-12, Up7.solders.get(i).getY()-2, 4, 4);
                break;
            case 3:
                drp.fillOval(Up7.solders.get(i).getX()-2, Up7.solders.get(i).getY()-12, 4, 4);
                break;
            case 4:
                drp.fillOval(Up7.solders.get(i).getX()-2, Up7.solders.get(i).getY()+8, 4, 4);
                break;
            case 13:
                drp.fillOval(Up7.solders.get(i).getX()+8, Up7.solders.get(i).getY()-12, 4, 4);
                break;
            case 23:
                drp.fillOval(Up7.solders.get(i).getX()-12, Up7.solders.get(i).getY()-12, 4, 4);
                break;
            case 14:
                drp.fillOval(Up7.solders.get(i).getX()+8, Up7.solders.get(i).getY()+8, 4, 4);
                break;
            case 24:
                drp.fillOval(Up7.solders.get(i).getX()-12, Up7.solders.get(i).getY()+8, 4, 4);
                break;
        }

    }

}
