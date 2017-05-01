package main.java;

import main.java.weapon.*;

//import java.util.concurrent.TimeUnit;

class Solder {
    private Integer x;
    private Integer y;
    private Integer hp; //private
    private final Integer fullHp; //private
    private Up7 field;
    private Integer team;
    private Weapon gun;
    private int WhatGun;
    private double skill;
    private boolean dead;
    public boolean running;
    private int turn; // {RIGHT = 1, LEFT = 2, TOP = 3, DOWN = 4, RIGHT_TOP = 13, LEFT_TOP = 23, RIGHT_DOWN = 14, LEFT_DOWN = 24};

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
        this.WhatGun = (int)(Math.random()*4);
        switch (WhatGun) {
            case 0:
                this.gun = new Pistol();
                break;
            case 1:
                this.gun = new Shothun();
                break;
            case 2:
                this.gun = new AssaultRifle();
                break;
            case 3:
                this.gun = new Rifle();
        }
        this.running = false;

        setTurn();

        field.repaint();
    }


//    void move(int x, int y) throws InterruptedException {
    void move(int x, int y) {
        this.running = true;
        this.x = x;
        this.y = y;

        setTurn();

        field.repaint();
//        TimeUnit.MILLISECONDS.sleep(300);
        this.running = false;
    }

    private void setTurn(){
        if (this.x - 400 > 0) {
            double yx = (double)(this.y-400) / (double)(this.x-400);
            if (yx > 1.5) {
                this.turn = 4; // DOWN
            } else if (yx > 0.5) {
                this.turn = 23; // LEFT_DOWN
            } else if (yx > -0.5) {
                this.turn = 2;  //LEFT
            } else if (yx > -1.5) {
                this.turn = 24; //LEFT_TOP
            } else {
                this.turn = 3; //TOP
            }
        } else {
            double yx = (double)(this.y-400) / (double)(this.x-400);
            yx = -yx;
            if (yx > 1.5) {
                this.turn = 4; // DOWN
            } else if (yx > 0.5) {
                this.turn = 13; // RIGHT_DOWN
            } else if (yx > -0.5) {
                this.turn = 1;  //RIGHT
            } else if (yx > -1.5) {
                this.turn = 14; //RIGHT_TOP
            } else {
                this.turn = 3; //TOP
            }
        }
    }

    private void setTurn(Solder enemySolder){
        if (this.x - enemySolder.getX() > 0) {
            double yx = (double)(this.y - enemySolder.getY()) / (double)(this.x - enemySolder.getY());
            if (yx > 1.5) {
                this.turn = 4; // DOWN
            } else if (yx > 0.5) {
                this.turn = 23; // LEFT_DOWN
            } else if (yx > -0.5) {
                this.turn = 2;  //LEFT
            } else if (yx > -1.5) {
                this.turn = 24; //LEFT_TOP
            } else {
                this.turn = 3; //TOP
            }
        } else {
            double yx = (double)(this.y - enemySolder.getY()) / (double)(this.x - enemySolder.getY());
            yx = -yx;
            if (yx > 1.5) {
                this.turn = 4; // DOWN
            } else if (yx > 0.5) {
                this.turn = 13; // RIGHT_DOWN
            } else if (yx > -0.5) {
                this.turn = 1;  //RIGHT
            } else if (yx > -1.5) {
                this.turn = 14; //RIGHT_TOP
            } else {
                this.turn = 3; //TOP
            }
        }
    }

    int getTeam() {
        return team;
    }

    int getHp() {
        return hp;
    }

    int getTurn() {
        return this.turn;
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

    public Solder findTarget(){ //ищет цель
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

//    public void shoot(Solder enemySolder) throws InterruptedException {//стреляет из а в b
    public void shoot(Solder enemySolder){
        this.running = true;
        setTurn(enemySolder);
        double v;
        v = Math.atan(skill/4) * 2 / 3.141592654;
        if (Math.random() < v) {
            this.hitting(enemySolder);
        }
        this.raiseSkill(); //после выстрела у стрелка поднялся скил.

        field.repaint();
//        TimeUnit.MILLISECONDS.sleep(1000);
        setTurn();
        this.running = false;
        field.repaint();
    }

    public int whatGun() { //return 0 - pistol, 1 - shotgun; 2 - assault rifle; 3 - rifle;
        return WhatGun;
    }

}



