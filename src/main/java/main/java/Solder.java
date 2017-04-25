package main.java;

class Solder {
    private Integer x;
    private Integer y;
    public Integer hp; //private
    public final Integer fullHp; //private
    private Up7 field;
    private Integer team;
    public Weapon gun;
    public  double skill;
    public boolean Dead;

    Solder(Up7 field, int x, int y, int team) {
        super();
        this.field = field;
        this.x = x;
        this.y = y;
        this.team = team;
        this.hp = 80 + (int)(Math.random()*40);
        this.fullHp = this.hp;
        this.Dead = false;
        this.skill = 1.0;
        this.gun = new Weapon();
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

    void shoot(Solder emenySolder) {

    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    public void isDead(){
        if (hp < 0) {
            Dead = true;
        }
    }

    public void Wound(int a, int b){//у солдата с индексом b отнимается a хп
        Up7.solders.get(b).hp = Up7.solders.get(b).hp - a;
    }

    public void RaiseSkill(int a){
        skill = skill + 1.0;
    }

    public int findtarget(int a){ //ищет цель у солдата с индексом а в массиве
        int i, k; //k - расстояние от выбранного солдата до солдатов в массиве
        for (i = 0; i < Up7.solders.size(); i++) {
            k = (int)(Math.sqrt(Math.pow(Up7.solders.get(i).getX() - Up7.solders.get(a).getX(), 2) + Math.pow(Up7.solders.get(i).getY() - Up7.solders.get(a).getY(), 2)));
            if((k < Up7.solders.get(a).gun.distance) & (Up7.solders.get(i).Dead == false)){
                return i; //возвращает номер первого солдата попавшего в дистанцию стрельбы
            }
        }
        return -1; //ошибка если не нашлось цели
    }

    public void shoot(int a, int b){//стреляет из а в b
        double v;
        v = Math.atan(skill/2) * 2 / 3.141592654;
        if (Math.random() < v) {
            Up7.solders.get(b).Wound(Up7.solders.get(a).gun.damage, b);
        }
        RaiseSkill(a); //после выстрела у стрелка поднялся скил.
        field.repaint();
    }

}



