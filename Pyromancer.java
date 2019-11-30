package heroes;

import static constants.Constants.*;
import static constants.Constants.VOLCANIC_BOOST;
import static java.lang.Math.ceil;
import static java.lang.Math.round;


public class Pyromancer extends Hero {
    public Pyromancer() {
    }

    public Pyromancer(int l, int c) {
        super(l, c);
        super.setHP(PYRO_START_HP + PYRO_HP_PER_LEVEL * super.getLevel());
        super.setType('P');
        super.setLandModif('V');
    }

    @Override
    public int getMaxHP() {
        return PYRO_START_HP + PYRO_HP_PER_LEVEL * super.getLevel();
    }

    public float fireblastPyro(float damage) {
        float damageOnPyro = damage * (this.getBoost() + 1) * (FIREBLAST_ON_PYRO + 1);
        return damageOnPyro;
    }

    public float fireblastKnight(float damage) {
        float damageOnKnight = damage * (this.getBoost() + 1) * (FIREBLAST_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    public float fireblastRogue(float damage) {
        float damageOnRogue = damage * (this.getBoost() + 1) * (FIREBLAST_ON_ROGUE + 1);
        return damageOnRogue;
    }

    public float fireblastWizard(float damage) {
        float damageOnWizard = damage * (this.getBoost() + 1) * (FIREBLAST_ON_WIZARD + 1);
        return damageOnWizard;
    }


    public float fireblast(Hero hero) {
        float finalDamage = 0f;
        float baseDamage = FIREBLAST_DAMAGE + FIREBLAST_PER_LEVEL * hero.getLevel();
        switch (hero.getType()) {
            case 'P':
                finalDamage = fireblastPyro(baseDamage);
                break;
            case 'K':
                finalDamage = fireblastKnight(baseDamage);
                break;
            case 'R':
                finalDamage = fireblastRogue(baseDamage);
                break;
            case 'W':
                finalDamage = fireblastWizard(baseDamage);
                break;
            default:
                ;
        }
        return finalDamage;
    }


    public float ignitePyro(float damage) {
        float damageOnPyro = damage * (this.getBoost() + 1) * (IGNITE_ON_PYRO + 1);
        return damageOnPyro;
    }

    public float igniteKnight(float damage) {
        float damageOnKnight = damage * (this.getBoost() + 1) * (IGNITE_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    public float igniteRogue(float damage) {
        float damageOnRogue = damage * (this.getBoost() + 1) * (IGNITE_ON_ROGUE + 1);
        return damageOnRogue;
    }

    public float igniteWizard(float damage) {
        float damageOnWizard = damage * (this.getBoost() + 1) * (IGNITE_ON_WIZARD + 1);
        return damageOnWizard;
    }


    public float ignite(Hero hero) {
        float finalDamage = 0;
        float baseDamage = IGNITE_BASE_DAMAGE + IGNITE_BASE_PER_LEVEL * hero.getLevel();
        float roundDamage = 0;
        int overtime = hero.getRoundNR() + IGNITE_OVERTIME;
        int roundNr = hero.getRoundNR();
        for (int i = roundNr; i <= overtime; i++) {
            roundDamage += IGNITE_ROUND_DAMAGE + IGNITE_ROUND_DAMAGE * hero.getLevel();
        }
        float sumDamage = baseDamage + roundDamage;

        switch (hero.getType()) {
            case 'P':
                finalDamage = ignitePyro(sumDamage);
                break;
            case 'K':
                finalDamage = igniteKnight(sumDamage);
                break;
            case 'R':
                finalDamage = igniteRogue(sumDamage);
                break;
            case 'W':
                finalDamage = igniteWizard(sumDamage);
                break;
            default:
                ;
        }
        return finalDamage;
    }

    @Override
    public void isAttackedBy(Hero hero) {
        hero.attack(this);

    }

    @Override
    public void attack(Hero hero) {
        int damageFireblast = round(fireblast(hero));
        int damageIgnite = round(ignite(hero));
        int total = damageFireblast + damageIgnite;
        hero.decreaseHP(total);
        hero.setReceivedDamage(total);
    }


}