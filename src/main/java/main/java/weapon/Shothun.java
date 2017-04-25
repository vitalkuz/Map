package main.java.weapon;

/**
 * Created by Seva_ on 25.04.2017.
 */
public class Shothun implements Weapon {
    private int damage = 70;
    private int distance = 100;

    @Override
    public int getDamage() {
        return (this.damage + (int)(Math.random()*50));
    }

    @Override
    public int getDistance() {
        return this.distance;
    }
}
