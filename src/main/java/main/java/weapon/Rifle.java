package main.java.weapon;

public class Rifle implements Weapon {
    private int damage = 20;
    private int distance = 200;


    @Override
    public int getDamage() {
        return (this.damage + (int)(Math.random()*20));
    }

    @Override
    public int getDistance() {
        return this.distance;
    }
}
