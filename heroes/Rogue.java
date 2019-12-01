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
     * The method applies back stab on each hero based on its type.
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
        for (int i = 0; i < PARALYSIS_OVERTIME; i++) {
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
     *
     * @param pyromancer
     */

    @Override
    public void attack(final Pyromancer pyromancer) {
        int damageBackstab = round(backstab(pyromancer));
        int damageParalysis = round(paralysis(pyromancer));
        int total = damageBackstab + damageParalysis;
        pyromancer.decreaseHp(total);
        pyromancer.setReceivedDamage(total);

    }

    /**
     *
     * @param knight
     */

    @Override
    public void attack(final Knight knight) {
        int damageBackstab = round(backstab(knight));
        int damageParalysis = round(paralysis(knight));
        int total = damageBackstab + damageParalysis;
        knight.decreaseHp(total);
        knight.setReceivedDamage(total);


    }

    /**
     *
     * @param rogue
     */

    @Override
    public void attack(final Rogue rogue) {
        int damageBackstab = round(backstab(rogue));
        int damageParalysis = round(paralysis(rogue));
        int total = damageBackstab + damageParalysis;
        rogue.decreaseHp(total);
        rogue.setReceivedDamage(total);

    }

    /**
     *
     * @param wizard
     */

    @Override
    public void attack(final Wizard wizard) {
        int damageBackstab = round(backstab(wizard));
        int damageParalysis = round(paralysis(wizard));
        int total = damageBackstab + damageParalysis;
        wizard.decreaseHp(total);
        wizard.setReceivedDamage(total);

    }

}
