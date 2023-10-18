package model.character;

public class Boss extends Enemy {

    public Boss(String name) {
        super(name);
    }

    public void bossAttack(){
        System.out.println("Big Bad Boss attack, *POW* *POW*");
    }
}
