package heroes;

import static constants.Constants.*;
import static java.lang.Math.min;
import static java.lang.Math.round;


public class Wizard extends Hero {
    public Wizard() {
    }

    public Wizard(int l, int c) {
        super(l, c);
        super.setHP(WIZARD_START_HP + WIZARD_HP_PER_LEVEL * super.getLevel());
        super.setType('W');
        super.setLandModif('D');
    }

    @Override
    public int getMaxHP() {
        return WIZARD_START_HP + WIZARD_HP_PER_LEVEL * super.getLevel();
    }

    public float drainPyro(float damage){
        float damageOnPyro = damage * (this.getBoost() + 1) * (DRAIN_ON_PYRO + 1);
        return damageOnPyro;
    }
    public float drainKnight(float damage){
        float damageOnKnight =  damage * (this.getBoost() + 1) * (DRAIN_ON_KNIGHT + 1);
//        System.out.println(damageOnKnight);
        return damageOnKnight;
    }
    public float drainRogue(float damage){
        float damageOnRogue =  damage * (this.getBoost() + 1) * (DRAIN_ON_ROGUE + 1);
        return damageOnRogue;
    }
    public float drainWizard(float damage){
        float damageOnWizard =  damage * (this.getBoost() + 1) * (DRAIN_ON_WIZARD + 1);
        return damageOnWizard;
    }


    public float drain(Hero hero){
        float finalDamage = 0f;
        float percent = 0f;
        float finalP = 0f;
        percent = DRAIN_PERCENT + DRAIN_PERCENT_PER_LEVEL * hero.getLevel();
        float baseHP = min(DRAIN_MUL_MAX_HP * hero.getMaxHP(), hero.getHP());
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
                ;
        }
        finalDamage = finalP * baseHP;
        return finalDamage;
    }


    public float deflectPyro(float damage){
        float damageOnPyro =  damage * (this.getBoost() + 1) * (DEFLECT_ON_PYRO + 1);
        return damageOnPyro;
    }
    public float deflectKnight(float damage){
        float damageOnKnight = damage * (this.getBoost() + 1) * (DEFLECT_ON_KNIGHT + 1);
        return damageOnKnight;
    }
    public float deflectRogue(float damage){
        float damageOnRogue = damage * (this.getBoost() + 1) * (DEFLECT_ON_ROGUE + 1);
        return damageOnRogue;
    }

    public float deflect(Hero hero){
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
                ;
        };
        hero.setUnaltered();
        finalDamage = finalPercent * hero.getUnalteredDamage();
        return finalDamage;


    }


    @Override
    public void isAttackedBy(Hero hero) {
        hero.attack(this);

    }

    @Override
    public void attack(Hero hero) {
        int damageDrain = round(drain(hero));
        int damageDeflect = round(deflect(hero));
        int total = damageDrain + damageDeflect;
        hero.decreaseHP(total);
        hero.setReceivedDamage(total);

    }
}

