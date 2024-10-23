package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;
/*
 Детонатор имеет способность взрываться в определённом раунде один раз за всю игру с шансом 50 на 50:
 взорваться в команде героев или у босса и наносить N-ое кол-во урона.
 При этом он сам не наносит урон, только через способность.
 */

public class Bomb extends Hero {
    private int explosionDamage;
    private int timerToExplosion;

    public Bomb(String name, int health, int explosionDamage, int timerToExplosion) {
        super(name, health, 0, SuperAbility.EXPLOSION);
        this.explosionDamage = explosionDamage;
        this.timerToExplosion = timerToExplosion;

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean chance = RPG_Game.random.nextBoolean();
        if(this.timerToExplosion == RPG_Game.getRoundNumber() && chance){
            boss.setHealth(boss.getHealth() - this.explosionDamage);
            this.setHealth(0);
            System.out.println("BOSS took " + this.explosionDamage + " damage from the explosion.");

        }else if(this.timerToExplosion == RPG_Game.getRoundNumber()){
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0 && this != hero) {
                    hero.setHealth(hero.getHealth() - this.explosionDamage);
                    this.setHealth(0);
                }
            }System.out.println("Heroes took " + this.explosionDamage + " damage from the explosion.");
        }

    }
}
