package model.character;

public class Enemy extends Character implements Fightable {

    public Enemy(String name) {
        super(name);
    }

    @Override
    public void attack(){
        System.out.println("Generic enemy attacking!!");
    }
}
