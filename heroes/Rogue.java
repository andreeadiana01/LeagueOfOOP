package heroes;

import static constants.Constants.ROGUE_START_HP;
import static constants.Constants.ROGUE_HP_PER_LEVEL;
import static constants.Constants.BACKSTAB_ON_PYRO;
import static constants.Constants.BACKSTAB_ON_KNIGHT;
import static constants.Constants.BACKSTAB_ON_ROGUE;
import static constants.Constants.BACKSTAB_ON_WIZARD;
import static constants.Constants.BACKSTAB_DAMAGE;
import static constants.Constants.BACKSTAB_PER_LEVEL;
import static constants.Constants.PARALYSIS_ON_KNIGHT;
import static constants.Constants.PARALYSIS_ON_PYRO;
import static constants.Constants.PARALYSIS_ON_WIZARD;
import static constants.Constants.PARALYSIS_ON_ROGUE;
import static constants.Constants.PARALYSIS_OVERTIME;
import static constants.Constants.PARALYSIS_DAMAGE;
import static constants.Constants.PARALYSIS_PER_LEVEL;


import static java.lang.Math.round;

public class Rogue extends Hero {
    public Rogue() {
    }

    public Rogue(final int l, final int c) {
        super(l, c);
        super.setHp(ROGUE_START_HP + ROGUE_HP_PER_LEVEL * super.getLevel());
        super.setType('R');
        super.setLandModif('W');
    }

    /**
     *
     * @return
     */

    @Override
    public int getMaxHp() {
        return ROGUE_START_HP + ROGUE_HP_PER_LEVEL * super.getLevel();
    }

    /**
     *
     * @param damage
     * @return
     */

    public float backstabPyro(final float damage) {
        float damageOnPyro = damage * (this.getCritical() + 1)
                * (this.getBoost() + 1) * (BACKSTAB_ON_PYRO + 1);
        return damageOnPyro;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float backstabKnight(final float damage) {
        float damageOnKnight = damage * (this.getCritical() + 1)
                * (this.getBoost() + 1) * (BACKSTAB_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float backstabRogue(final float damage) {
        float damageOnRogue = damage * (this.getCritical() + 1)
                * (this.getBoost() + 1) * (BACKSTAB_ON_ROGUE + 1);
        return damageOnRogue;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float backstabWizard(final float damage) {
        float damageOnWizard = damage * (this.getCritical() + 1)
                * (this.getBoost() + 1) * (BACKSTAB_ON_WIZARD + 1);
        return damageOnWizard;
    }

    /**
     * The method applies back stab on each hero based on its type
     * @param hero
     * @return
     */

    public float backstab(final Hero hero) {
        float finalDamage = 0;
        float baseDamage = BACKSTAB_DAMAGE + BACKSTAB_PER_LEVEL * hero.getLevel();
        switch (hero.getType()) {
            case 'P' :
                finalDamage = backstabPyro(baseDamage);
                break;
            case 'K' :
                finalDamage = backstabKnight(baseDamage);
                break;
            case 'R' :
                finalDamage = backstabRogue(baseDamage);
                break;
            case 'W' :
                finalDamage = backstabWizard(baseDamage);
                break;
            default:
                throw new IllegalStateException("Value not expected");
        }
        return finalDamage;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float paralysisPyro(final float damage) {
        float damageOnPyro = damage * (this.getBoost() + 1) * (PARALYSIS_ON_PYRO + 1);
        return damageOnPyro;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float paralysisKnight(final float damage) {
        float damageOnKnight = damage * (this.getBoost() + 1) * (PARALYSIS_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float paralysisRogue(final float damage) {
        float damageOnRogue = damage * (this.getBoost() + 1) * (PARALYSIS_ON_ROGUE + 1);
        return damageOnRogue;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float paralysisWizard(final float damage) {
        float damageOnWizard = damage * (this.getBoost() + 1) * (PARALYSIS_ON_WIZARD + 1);
        return damageOnWizard;
    }

    /**
     * The method applies paralysis based on the hero type.
     * @param hero
     * @return
     */

    public float paralysis(final Hero hero) {
        float finalDamage = 0;
        float damageRound = 0;
        float baseDamage = PARALYSIS_DAMAGE + PARALYSIS_PER_LEVEL * hero.getLevel();

        int roundNr = hero.getRoundNR();
        int overtime = roundNr + PARALYSIS_OVERTIME;
        float sumDamage = baseDamage + damageRound;
        switch (hero.getType()) {
            case 'P' :
                finalDamage = paralysisPyro(sumDamage);
                break;
            case 'K' :
                finalDamage = paralysisKnight(sumDamage);
                break;
            case 'R' :
                finalDamage = paralysisRogue(sumDamage);
                break;
            case 'W' :
                finalDamage = paralysisWizard(sumDamage);
                break;
            default:
                throw new IllegalStateException("Value not expected");
        }
        int damageOT = round(paralysisOT(hero));
        System.out.println(damageOT);
        hero.decreaseHp(damageOT / 2);
        return finalDamage;

    }

    /**
     *
     * @param hero
     * @return
     */

    public float paralysisOT(final Hero hero) {
        float finalDamage = 0;
        float damageRound = PARALYSIS_DAMAGE + PARALYSIS_PER_LEVEL * hero.getLevel();
        float baseDamage = 0;
        for (int i = 0; i < 2; i++) {
            damageRound = PARALYSIS_DAMAGE + PARALYSIS_PER_LEVEL * hero.getLevel();
            hero.setIncapacitated(true);
        }
        float sumDamage = baseDamage + damageRound;
        switch (hero.getType()) {
            case 'P' :
                finalDamage = paralysisPyro(sumDamage);
                break;
            case 'K' :
                finalDamage = paralysisKnight(sumDamage);
                break;
            case 'R' :
                finalDamage = paralysisRogue(sumDamage);
                break;
            case 'W' :
                finalDamage = paralysisWizard(sumDamage);
                break;
            default:
                throw new IllegalStateException("Value not expected");
        }
        return finalDamage;

    }

    /**
     *
     * @param hero
     */

    @Override
    public void isAttackedBy(final Hero hero) {
        hero.attack(this);
    }

    /**
     * The method computes the final damage by applying round to each damage resulted from both abilities
     * @param hero
     */

    @Override
    public void attack(final Hero hero) {
        int damageBackstab = round(backstab(hero));
        int damageParalysis = round(paralysis(hero));
        int total = damageBackstab + damageParalysis;

        hero.decreaseHp(total);
        hero.setReceivedDamage(total);

    }
}
