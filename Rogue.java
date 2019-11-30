package heroes;

import static constants.Constants.*;
import static constants.Constants.WOODS_BOOST;
import static java.lang.Math.round;

public class Rogue extends Hero {
    public Rogue() {
    }

    public Rogue(int l, int c) {
        super(l, c);
        super.setHP(ROGUE_START_HP + ROGUE_HP_PER_LEVEL * super.getLevel());
        super.setType('R');
        super.setLandModif('W');
    }

    @Override
    public int getMaxHP() {
        return ROGUE_START_HP + ROGUE_HP_PER_LEVEL * super.getLevel();
    }

    public float backstabPyro(float damage){
        float damageOnPyro = damage * (this.getCritical() + 1) * (this.getBoost() + 1) * (BACKSTAB_ON_PYRO + 1);
        return damageOnPyro;
    }
    public float backstabKnight(float damage){
        float damageOnKnight = damage * (this.getCritical() + 1) * (this.getBoost() + 1) * (BACKSTAB_ON_KNIGHT + 1);
//        System.out.println(this.getCritical());
//        System.out.println(this.getBoost());
//        System.out.println(damageOnKnight);
        return damageOnKnight;
    }
    public float backstabRogue(float damage){
        float damageOnRogue = damage * (this.getCritical() + 1) * (this.getBoost() + 1) * (BACKSTAB_ON_ROGUE + 1);
        return damageOnRogue;
    }
    public float backstabWizard(float damage){
        float damageOnWizard = damage * (this.getCritical() + 1) * (this.getBoost() + 1) * (BACKSTAB_ON_WIZARD + 1);
        return damageOnWizard;
    }

    public float backstab(Hero hero){
        float finalDamage = 0;
        float baseDamage = BACKSTAB_DAMAGE + BACKSTAB_PER_LEVEL * hero.getLevel();
        switch (hero.getType()){
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
                ;
        }
        return finalDamage;
    }

    public float paralysisPyro(float damage){
        float damageOnPyro = damage * (this.getBoost() + 1) * (PARALYSIS_ON_PYRO + 1);
        return damageOnPyro;
    }
    public float paralysisKnight(float damage){
        float damageOnKnight = damage * (this.getBoost() + 1) * (PARALYSIS_ON_KNIGHT + 1);
//        System.out.println(damageOnKnight);
        return damageOnKnight;
    }
    public float paralysisRogue(float damage){
        float damageOnRogue = damage * (this.getBoost() + 1) * (PARALYSIS_ON_ROGUE + 1);
        return damageOnRogue;
    }
    public float paralysisWizard(float damage){
        float damageOnWizard = damage * (this.getBoost() + 1) * (PARALYSIS_ON_WIZARD + 1);
        return damageOnWizard;
    }


    public float paralysis(Hero hero){
        float finalDamage = 0;
        float damageRound = 0;
        float baseDamage = PARALYSIS_DAMAGE + PARALYSIS_PER_LEVEL * hero.getLevel();
//        hero.addUnalteredDamage(baseDamage);

        int roundNr = hero.getRoundNR();
        int overtime = roundNr + PARALYSIS_OVERTIME;
        float sumDamage = baseDamage + damageRound;
        switch (hero.getType()){
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
                ;
        }
        int damageOT = round(paralysisOT(hero));
        System.out.println(damageOT);
        hero.decreaseHP(damageOT/2);
        return finalDamage;

    }

    public float paralysisOT(Hero hero){
        float finalDamage = 0;
        float damageRound = PARALYSIS_DAMAGE + PARALYSIS_PER_LEVEL * hero.getLevel();
        float baseDamage = 0;
        for(int i = 0 ; i < 2; i++){
            damageRound = PARALYSIS_DAMAGE + PARALYSIS_PER_LEVEL * hero.getLevel();
            hero.setIncapacitated(true);
        }
        float sumDamage = baseDamage + damageRound;
        switch (hero.getType()){
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
        int damageBackstab = round(backstab(hero) );
        int damageParalysis = round(paralysis(hero));
        int total = damageBackstab + damageParalysis;

        hero.decreaseHP(total);
        hero.setReceivedDamage(total);

    }
}
