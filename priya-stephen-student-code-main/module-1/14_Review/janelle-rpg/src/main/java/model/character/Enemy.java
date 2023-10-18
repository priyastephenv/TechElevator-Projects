package model.character;

public class Enemy extends Character {

    public Enemy(String name) {
        super(name);
    }

    public void BasicAttack(){
        System.out.println("Generic enemy attacking!!");
    }
}
