package gameplay;

import model.character.*;

public class Battle {
    Hero hero;

    public Battle(Hero hero){
        this.hero = hero;
    }

    public void battleEnemies(){
        fight(new Enemy("troglodyte"));
        bossFight(new Boss("Diablo"));
        waterFight(new WaterEnemy("Leviathan"));
        skyFight(new FlyingEnemy("Mothra"));
    }

    private void fight(Enemy enemy){
        hero.heroAttack();
        enemy.BasicAttack();
    }

    private void bossFight(Boss boss){
        hero.heroAttack();
        boss.bossAttack();
    }

    private void waterFight(WaterEnemy waterEnemy){
        hero.heroAttack();
        waterEnemy.splashAttack();
    }

    private void skyFight(FlyingEnemy flyingEnemy){
        hero.heroAttack();
        flyingEnemy.flyingAttack();
    }
}
