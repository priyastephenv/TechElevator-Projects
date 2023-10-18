package model.character;

public class WaterEnemy extends Enemy implements Fightable {

    public WaterEnemy(String name) {
        super(name);
    }

    @Override
    public void attack(){
        System.out.println("Water enemy attacking with water!!");
    }
}
