package main.java.weapon;

/**
 * Created by Seva_ on 25.04.2017.
 */
public class Pistol implements Weapon{
    private int damage = 30;
    private int distance = 50;

    @Override
    public int getDamage() {
        return (this.damage + (int)(Math.random()*10));
    }

    @Override
    public int getDistance() {
        return this.distance;
    }
}
