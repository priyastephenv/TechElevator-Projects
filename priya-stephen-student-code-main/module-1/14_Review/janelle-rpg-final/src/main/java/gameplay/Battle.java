package gameplay;

import model.character.*;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    Hero hero;
    List<Enemy> enemies;

    public Battle(Hero hero){
        this.hero = hero;
        enemies = new ArrayList<>();
    }

    /*
     * TODO: Find way to refactor this...
     */
//    private void fight(Enemy enemy){
//        hero.heroAttack();
//        enemy.attack();
//    }
//
//    private void bossFight(Boss boss){
//        hero.heroAttack();
//        boss.attack();
//    }
//
//    private void waterFight(WaterEnemy waterEnemy){
//        hero.heroAttack();
//        waterEnemy.attack();
//    }
//
//    private void skyFight(FlyingEnemy flyingEnemy){
//        hero.heroAttack();
//        flyingEnemy.attack();
//    }

    /*
     * Refactored!
     */
    public void battleEnemies(){
        enemies.add(new Enemy("troglodyte"));
        enemies.add(new Boss("Diablo"));
        enemies.add(new WaterEnemy("Leviathan"));
        enemies.add(new FlyingEnemy("Mothra"));

        for(Enemy eachEnemy : enemies){
            hero.attack();
            eachEnemy.attack();
        }
    }
}
