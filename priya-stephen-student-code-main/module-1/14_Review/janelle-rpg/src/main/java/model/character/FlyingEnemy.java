package model.character;

public class FlyingEnemy extends Enemy {

    public FlyingEnemy(String name) {
        super(name);
    }

    public void flyingAttack(){
        System.out.println("Flying enemy attacking from the sky!!");
    }
}
