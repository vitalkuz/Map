package main.java.weapon;

public class Rifle implements Weapon {
    private int damage = 100;
    private int distance = 300;


    @Override
    public int getDamage() {
        return (this.damage + (int)(Math.random()*50));
    }

    @Override
    public int getDistance() {
        return this.distance;
    }
}
