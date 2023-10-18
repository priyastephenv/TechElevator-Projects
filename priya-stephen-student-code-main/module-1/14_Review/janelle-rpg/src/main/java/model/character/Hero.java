package model.character;

public class Hero extends Character {

    public Hero(String name) {
        super(name);
    }

    public void heroAttack(){
        System.out.println("Our dashing hero attacks, *hiiii-yaa!*");
    }
}
