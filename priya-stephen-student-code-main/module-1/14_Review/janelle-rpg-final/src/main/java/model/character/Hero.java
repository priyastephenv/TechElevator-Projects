package model.character;

public class Hero extends Character implements Fightable{

    public Hero(String name) {
        super(name);
    }

    @Override
    public void attack(){
        System.out.println("Our dashing hero attacks, *hiiii-yaa!*");
    }
}
