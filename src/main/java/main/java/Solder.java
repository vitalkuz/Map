package main.java;

class Solder {
    private Integer x;
    private Integer y;
    public Integer hp; //private
    public final Integer fullHp; //private
    private Up7 field;
    private Integer team;

    Solder(Up7 field, int x, int y, int team) {
        super();
        this.field = field;
        this.x = x;
        this.y = y;
        this.team = team;
        this.hp = 80 + (int)(Math.random()*40);
        this.fullHp = this.hp;
        field.repaint();
    }

    void move(int x, int y) {
        this.x = x;
        this.y = y;
        field.repaint();
    }

    int getTeam() {
        return team;
    }

    int getHp() {
        return hp;
    }

    double percentOfHp() {
        return (double)this.hp/this.fullHp;
    }

    boolean capturedOfFlag() {
        if ((Math.pow((this.x - 400), 2) + Math.pow((this.y - 400), 2)) < 400) {
            return true;
        } else {
            return false;
        }
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}



