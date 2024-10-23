package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;


public class Hacker extends Hero {
    private int hackPoint;
    public Hacker(String name, int health, int damage, int hackPoint) {
        super(name, health, damage, SuperAbility.HACK);
        this.hackPoint = hackPoint;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if(RPG_Game.getRoundNumber() % 2 != 0){
            boss.setHealth(boss.getHealth() - hackPoint);
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0 && this != hero) {
                    hero.setHealth(hero.getHealth() + this.hackPoint);
                    System.out.println("Hacker "+ this.getName() + " sent " + this.hackPoint + " health points of boss to " + hero.getName());
                    break;
                }
            }


        }
    }
}
