package heroes;

import static constants.Constants.WIZARD_START_HP;
import static constants.Constants.WIZARD_HP_PER_LEVEL;
import static constants.Constants.DRAIN_PERCENT;
import static constants.Constants.DRAIN_PERCENT_PER_LEVEL;
import static constants.Constants.DEFLECT_ON_KNIGHT;
import static constants.Constants.DEFLECT_ON_PYRO;
import static constants.Constants.DEFLECT_ON_ROGUE;
import static constants.Constants.DRAIN_ON_KNIGHT;
import static constants.Constants.DRAIN_ON_ROGUE;
import static constants.Constants.DRAIN_ON_PYRO;
import static constants.Constants.DRAIN_ON_WIZARD;
import static constants.Constants.DRAIN_MUL_MAX_HP;
import static constants.Constants.DEFLECT_PERCENT;
import static constants.Constants.DEFLECT_PERCENT_PER_LEVEL;
import static java.lang.Math.min;
import static java.lang.Math.round;


public class Wizard extends Hero {

    public Wizard(final int l, final int c) {
        super(l, c);
        super.setHp(WIZARD_START_HP + WIZARD_HP_PER_LEVEL * super.getLevel());
        super.setType('W');
        super.setLandModif('D');
    }

    /**
     *
     * @return
     */

    @Override
    public int getMaxHp() {
        return WIZARD_START_HP + WIZARD_HP_PER_LEVEL * super.getLevel();
    }

    /**
     *
     * @param damage
     * @return
     */

    public float drainPyro(final float damage) {
        float damageOnPyro = damage * (this.getBoost() + 1) * (DRAIN_ON_PYRO + 1);
        return damageOnPyro;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float drainKnight(final float damage) {
        float damageOnKnight =  damage * (this.getBoost() + 1) * (DRAIN_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float drainRogue(final float damage) {
        float damageOnRogue =  damage * (this.getBoost() + 1) * (DRAIN_ON_ROGUE + 1);
        return damageOnRogue;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float drainWizard(final float damage) {
        float damageOnWizard =  damage * (this.getBoost() + 1) * (DRAIN_ON_WIZARD + 1);
        return damageOnWizard;
    }

    /**
     * The method applies drain based on the hero type.
     * @param hero
     * @return
     */

    public float drain(final Hero hero) {
        float finalDamage = 0f;
        float percent = 0f;
        float finalP = 0f;
        percent = DRAIN_PERCENT + DRAIN_PERCENT_PER_LEVEL * hero.getLevel();
        float baseHP = min(DRAIN_MUL_MAX_HP * hero.getMaxHp(), hero.getHp());
        switch (hero.getType()) {
            case 'P':
                finalP = drainPyro(percent);
                break;
            case 'K':
                finalP = drainKnight(percent);
                break;
            case 'R':
                finalP = drainRogue(percent);
                break;
            case 'W':
                finalP = drainWizard(percent);
                break;
            default:
                throw new IllegalStateException("Value not expected");
        }
        finalDamage = finalP * baseHP;
        return finalDamage;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float deflectPyro(final float damage) {
        float damageOnPyro =  damage * (this.getBoost() + 1) * (DEFLECT_ON_PYRO + 1);
        return damageOnPyro;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float deflectKnight(final float damage) {
        float damageOnKnight = damage * (this.getBoost() + 1) * (DEFLECT_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float deflectRogue(final float damage) {
        float damageOnRogue = damage * (this.getBoost() + 1) * (DEFLECT_ON_ROGUE + 1);
        return damageOnRogue;
    }

    /**
     * The method applies deflect based on the hero type.
     * @param hero
     * @return
     */

    public float deflect(final Hero hero) {
        float finalDamage = 0;
        float finalPercent = 0;
        float percent = DEFLECT_PERCENT + DEFLECT_PERCENT_PER_LEVEL * hero.getLevel();
        switch (hero.getType()) {
            case 'P':
                finalPercent = deflectPyro(percent);
                break;
            case 'K':
                finalPercent = deflectKnight(percent);
                break;
            case 'R':
                finalPercent = deflectRogue(percent);
                break;
            case 'W':
                break;
            default:
                throw new IllegalStateException("Value not expected");
        }
        hero.setUnaltered();
        finalDamage = finalPercent * hero.getUnalteredDamage();
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
        int damageDrain = round(drain(pyromancer));
        int damageDeflect = round(deflect(pyromancer));
        int total = damageDrain + damageDeflect;
        pyromancer.decreaseHp(total);
        pyromancer.setReceivedDamage(total);

    }

    /**
     *
     * @param knight
     */

    @Override
    public void attack(final Knight knight) {
        int damageDrain = round(drain(knight));
        int damageDeflect = round(deflect(knight));
        int total = damageDrain + damageDeflect;
        knight.decreaseHp(total);
        knight.setReceivedDamage(total);

    }

    /**
     *
     * @param rogue
     */

    @Override
    public void attack(final Rogue rogue) {
        int damageDrain = round(drain(rogue));
        int damageDeflect = round(deflect(rogue));
        int total = damageDrain + damageDeflect;
        rogue.decreaseHp(total);
        rogue.setReceivedDamage(total);

    }

    /**
     *
     * @param wizard
     */

    @Override
    public void attack(final Wizard wizard) {
        int damageDrain = round(drain(wizard));
        int damageDeflect = round(deflect(wizard));
        int total = damageDrain + damageDeflect;
        wizard.decreaseHp(total);
        wizard.setReceivedDamage(total);

    }

}

