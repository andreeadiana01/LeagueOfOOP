package heroes;

import static constants.Constants.KNIGHT_START_HP;
import static constants.Constants.KNIGHT_HP_PER_LEVEL;
import static constants.Constants.EXECUTE_ON_PYRO;
import static constants.Constants.EXECUTE_ON_ROGUE;
import static constants.Constants.EXECUTE_ON_KNIGHT;
import static constants.Constants.EXECUTE_ON_WIZARD;
import static constants.Constants.EXECUTE_DAMAGE;
import static constants.Constants.EXECUTE_MUL_LEVEL;
import static constants.Constants.EXECUTE_MUL_LIFE;
import static constants.Constants.EXECUTE_PER_LEVEL;
import static constants.Constants.SLAM_ON_PYRO;
import static constants.Constants.SLAM_ON_KNIGHT;
import static constants.Constants.SLAM_ON_WIZARD;
import static constants.Constants.SLAM_ON_ROGUE;
import static constants.Constants.SLAM_DAMAGE;
import static constants.Constants.SLAM_PER_LEVEL;
import static java.lang.Math.round;

public class Knight extends Hero {

    public Knight(final int l, final int c) {
        super(l, c);
        super.setHp(KNIGHT_START_HP + KNIGHT_HP_PER_LEVEL * super.getLevel());
        super.setType('K');
        super.setLandModif('L');
    }

    /**
     *
     * @return
     */

    @Override
    public int getMaxHp() {
        return KNIGHT_START_HP + KNIGHT_HP_PER_LEVEL * super.getLevel();
    }

    /**
     *
     * @param damage
     * @return
     */

    public float executePyro(final float damage) {
        float damageOnPyro = damage * (this.getBoost() + 1) * (EXECUTE_ON_PYRO + 1);
        return damageOnPyro;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float executeKnight(final float damage) {
        float damageOnKnight = damage * (this.getBoost() + 1) * (EXECUTE_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float executeRogue(final float damage) {
        float damageOnRogue = damage * (this.getBoost() + 1) * (EXECUTE_ON_ROGUE + 1);
        return damageOnRogue;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float executeWizard(final float damage) {
        float damageOnWizard = damage * (this.getBoost() + 1) * (EXECUTE_ON_WIZARD + 1);
        return damageOnWizard;
    }

    /**
     * The method applies execute based on the hero type.
     * @param hero
     * @return
     */

    public float execute(final Hero hero) {
        float limitHP = 0;
        float baseDamage = 0;
        float finalDamage = 0;
        limitHP = EXECUTE_MUL_LIFE * hero.getMaxHp() + EXECUTE_MUL_LEVEL * hero.getLevel();
        if (hero.getHp() > limitHP) {
            baseDamage = EXECUTE_DAMAGE + EXECUTE_PER_LEVEL * hero.getLevel();
            switch (hero.getType()) {
                case 'P':
                    finalDamage = executePyro(baseDamage);
                    break;
                case 'K':
                    finalDamage = executeKnight(baseDamage);
                    break;
                case 'R':
                    finalDamage = executeRogue(baseDamage);
                    break;
                case 'W':
                    finalDamage = executeWizard(baseDamage);
                    break;
                default:
                    throw new IllegalStateException("Value not expected");
            }
        } else {
            hero.setHp(0);
        }
        return finalDamage;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float slamPyro(final float damage) {
        float damageOnPyro = damage * (this.getBoost() + 1) * (SLAM_ON_PYRO + 1);
        return damageOnPyro;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float slamKnight(final float damage) {
        float damageOnKnight = damage * (this.getBoost() + 1) * (SLAM_ON_KNIGHT + 1);
        return damageOnKnight;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float slamRogue(final float damage) {
        float damageOnRogue = damage * (this.getBoost() + 1) * (SLAM_ON_ROGUE + 1);
        return damageOnRogue;
    }

    /**
     *
     * @param damage
     * @return
     */

    public float slamWizard(final float damage) {
        float damageOnWizard = damage * (this.getBoost() + 1) * (SLAM_ON_WIZARD + 1);
        return damageOnWizard;
    }

    /**
     * The method applies slam based on the hero type.
     * @param hero
     * @return
     */

    public float slam(final Hero hero) {
        float finalDamage = 0;
        float baseDamage = SLAM_DAMAGE + SLAM_PER_LEVEL * hero.getLevel();
        int roundNr = hero.getRoundNR();
        int overtime = roundNr + 1;
        for (int i = roundNr; i < overtime; i++) {
            hero.setIncapacitated(true);
        }
        switch (hero.getType()) {
            case 'P':
                finalDamage = slamPyro(baseDamage);
                break;
            case 'K':
                finalDamage = slamKnight(baseDamage);
                break;
            case 'R':
                finalDamage = slamRogue(baseDamage);
                break;
            case 'W':
                finalDamage = slamWizard(baseDamage);
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
     * The method computes the final damage by applying round
     * to each damage resulted from both abilities.
     * @param hero
     */

    @Override
    public void attack(final Hero hero) {
        int damageExecute = round(execute(hero));
        int damageSlam = round(slam(hero));
        int total = damageExecute + damageSlam;
        hero.decreaseHp(total);
        hero.setReceivedDamage(total);
    }
}

