package main.java;

import main.java.weapon.Rifle;
import main.java.weapon.Weapon;

class Solder {
    private Integer x;
    private Integer y;
    private Integer hp; //private
    private final Integer fullHp; //private
    private Up7 field;
    private Integer team;
    private Weapon gun;
    private double skill;
    private boolean dead;
    private boolean running;

    Solder(Up7 field, int x, int y, int team) {
        super();
        this.field = field;
        this.x = x;
        this.y = y;
        this.team = team;
        this.hp = 80 + (int)(Math.random()*40);
        this.fullHp = this.hp;
        this.dead = false;
        this.skill = 1.0;
        int i = 1; //(int)(Math.random());
        if (i == 1) {
            this.gun = new Rifle();
        }
        this.running = false;
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

    public void isDead(){
        if (hp < 0) {
            this.dead = true;
            Up7.deadSolders.add(this);
            Up7.solders.remove(this);
        }
    }

    public void hitting(Solder enemySolder){//у солдата с индексом b отнимается a хп
        enemySolder.hp = enemySolder.hp - this.gun.getDamage();
        enemySolder.isDead();
    }

    public void raiseSkill(){
        this.skill = this.skill + 1.0;
    }

    public Solder findtarget(){ //ищет цель
        int i;
        double k; //k - расстояние от выбранного солдата до солдатов в массиве
        for (i = 0; i < Up7.solders.size(); i++) {
            k = (Math.sqrt(Math.pow(Up7.solders.get(i).getX() - this.getX(), 2) + Math.pow(Up7.solders.get(i).getY() - this.getY(), 2)));
            if ((k < (double)this.gun.getDistance()) & !(Up7.solders.get(i).equals(this))){
                return Up7.solders.get(i); //возвращает ссылку первого солдата попавшего в дистанцию стрельбы
            }
        }
        return null; //ошибка если не нашлось цели
    }

    public void shoot(Solder enemySolder){//стреляет из а в b
        double v;
        v = Math.atan(skill/2) * 2 / 3.141592654;
        if (Math.random() < v) {
            this.hitting(enemySolder);
        }
        this.raiseSkill(); //после выстрела у стрелка поднялся скил.
        field.repaint();
    }

}



