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

    }

}
