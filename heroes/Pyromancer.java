package heroes;

import static constants.Constants.PYRO_START_HP;
import static constants.Constants.PYRO_HP_PER_LEVEL;
import static constants.Constants.FIREBLAST_ON_PYRO;
import static constants.Constants.FIREBLAST_ON_KNIGHT;
import static constants.Constants.FIREBLAST_ON_WIZARD;
import static constants.Constants.FIREBLAST_ON_ROGUE;
import static constants.Constants.FIREBLAST_DAMAGE;
import static constants.Constants.FIREBLAST_PER_LEVEL;
import static constants.Constants.IGNITE_BASE_DAMAGE;
import static constants.Constants.IGNITE_BASE_PER_LEVEL;
import static constants.Constants.IGNITE_ON_PYRO;
import static constants.Constants.IGNITE_ON_KNIGHT;
import static constants.Constants.IGNITE_ON_WIZARD;
import static constants.Constants.IGNITE_ON_ROGUE;
import static constants.Constants.IGNITE_OVERTIME;
import static constants.Constants.IGNITE_ROUND_DAMAGE;
import static constants.Constants.IGNITE_ROUND_DAMAGE_PER_LEVEL;



import static java.lang.Math.round;


public class Pyromancer extends Hero {

    public Pyromancer(final int l, final int c) {
        super(l, c);
        super.setHp(PYRO_START_HP + PYRO_HP_PER_LEVEL * super.getLevel());
        super.setType('P');
        super.setLandModif('V');
    }

    /**
     *
     * @return
     */

    @Override
    public int getMaxHp() {
        return PYRO_START_HP + PYRO_HP_PER_LEVEL * super.getLevel();
    }

    /**
     *
     * @param damage
     * @return
     */

    public float fireblastPyro(final float damage) {
        float damageOnPyro = damage * (this.getBoost() + 1) * (FIREBLAST_ON_PYRO + 1);
        return damageOnPyro;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float fireblastKnight(final float damage) {
        float damageOnKnight = damage * (this.getBoost() + 1) * (FIREBLAST_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float fireblastRogue(final float damage) {
        float damageOnRogue = damage * (this.getBoost() + 1) * (FIREBLAST_ON_ROGUE + 1);
        return damageOnRogue;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float fireblastWizard(final float damage) {
        float damageOnWizard = damage * (this.getBoost() + 1) * (FIREBLAST_ON_WIZARD + 1);
        return damageOnWizard;
    }

    /**
     * The method applies fireblast based on the player type.
     * @param hero
     * @return
     */


    public float fireblast(final Hero hero) {
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
                throw new IllegalStateException("Value not expected");
        }
        return finalDamage;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float ignitePyro(final float damage) {
        float damageOnPyro = damage * (this.getBoost() + 1) * (IGNITE_ON_PYRO + 1);
        return damageOnPyro;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float igniteKnight(final float damage) {
        float damageOnKnight = damage * (this.getBoost() + 1) * (IGNITE_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float igniteRogue(final float damage) {
        float damageOnRogue = damage * (this.getBoost() + 1) * (IGNITE_ON_ROGUE + 1);
        return damageOnRogue;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float igniteWizard(final float damage) {
        float damageOnWizard = damage * (this.getBoost() + 1) * (IGNITE_ON_WIZARD + 1);
        return damageOnWizard;
    }

    /**
     * The method applies ignite based on the type of the player.
     * @param hero
     * @return
     */

    public float ignite(final Hero hero) {
        float finalDamage = 0;
        float baseDamage = IGNITE_BASE_DAMAGE + IGNITE_BASE_PER_LEVEL * hero.getLevel();
        float roundDamage = 0;
        for (int i = 0; i <= IGNITE_OVERTIME; i++) {
            roundDamage += IGNITE_ROUND_DAMAGE + IGNITE_ROUND_DAMAGE_PER_LEVEL * hero.getLevel();
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
        int damageFireblast = round(fireblast(pyromancer));
        int damageIgnite = round(ignite(pyromancer));
        int total = damageFireblast + damageIgnite;
        pyromancer.decreaseHp(total);
        pyromancer.setReceivedDamage(total);

    }

    /**
     *
     * @param knight
     */

    @Override
    public void attack(final Knight knight) {
        int damageFireblast = round(fireblast(knight));
        int damageIgnite = round(ignite(knight));
        int total = damageFireblast + damageIgnite;
        knight.decreaseHp(total);
        knight.setReceivedDamage(total);

    }

    /**
     *
     * @param rogue
     */

    @Override
    public void attack(final Rogue rogue) {
        int damageFireblast = round(fireblast(rogue));
        int damageIgnite = round(ignite(rogue));
        int total = damageFireblast + damageIgnite;
        rogue.decreaseHp(total);
        rogue.setReceivedDamage(total);

    }

    /**
     *
     * @param wizard
     */

    @Override
    public void attack(final Wizard wizard) {
        int damageFireblast = round(fireblast(wizard));
        int damageIgnite = round(ignite(wizard));
        int total = damageFireblast + damageIgnite;
        wizard.decreaseHp(total);
        wizard.setReceivedDamage(total);

    }
}
