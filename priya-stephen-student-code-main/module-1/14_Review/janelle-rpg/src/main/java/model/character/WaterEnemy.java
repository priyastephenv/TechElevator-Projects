package model.character;

public class WaterEnemy extends Enemy {

    public WaterEnemy(String name) {
        super(name);
    }

    public void splashAttack(){
        System.out.println("Water enemy attacking with water!!");
    }
}
