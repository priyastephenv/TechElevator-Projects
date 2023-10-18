package model.character;

public class FlyingEnemy extends Enemy implements Fightable {

    public FlyingEnemy(String name) {
        super(name);
    }

    @Override
    public void attack(){
        System.out.println("Flying enemy attacking from the sky!!");
    }
}
