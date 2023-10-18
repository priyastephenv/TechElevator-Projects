package model.character;

public class Boss extends Enemy implements Fightable {

    public Boss(String name) {
        super(name);
    }

    @Override
    public void attack(){
        System.out.println("Big Bad Boss attack, *POW* *POW*");
    }
}
