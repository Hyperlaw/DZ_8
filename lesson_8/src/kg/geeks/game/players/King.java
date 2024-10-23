package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class King extends Hero {
    public King(String name, int health) {
        super(name, health, 0, SuperAbility.ONE_PUNCH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        this.setDamage(0);
        int rand = RPG_Game.random.nextInt(11);
        if(rand == 10){
            boss.setHealth(0);
            System.out.println("Saitama killed the boss with one punch");
        }
    }
}
