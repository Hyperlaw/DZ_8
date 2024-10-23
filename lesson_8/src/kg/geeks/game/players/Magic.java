package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Magic extends Hero {
    private int boostPoint;
    public Magic(String name, int health, int damage, int boostPoint) {
        super(name, health, damage, SuperAbility.BOOST);
        this.boostPoint = boostPoint;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        for (Hero hero : heroes) {
            if (RPG_Game.getRoundNumber() < 4) {
                hero.setDamage(hero.getDamage() + this.boostPoint);
            }
        }
    }
}
