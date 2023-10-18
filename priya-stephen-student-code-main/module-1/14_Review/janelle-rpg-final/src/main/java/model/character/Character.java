package model.character;

public class Character {
    private String name;

    public Character(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
