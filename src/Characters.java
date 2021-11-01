public class Characters implements Cloneable{

    // Instance variables
    String name;
    int health;
    int attackPower;
    int[] attackPowers;
    String [] attackNames;

    // This is the Pokemon constructor, it allows us to initialize the instance variables
    public Characters(){

    } // End of constructor
    // We can make multiple different constructors
    public Characters(String _name, int _health, int _attackPower){
        name = _name;
        health = _health;
        attackPower = _attackPower;
    } // End of constructor 2
    public void setAttackPowers(int[] atkPwrs){
        attackPowers = atkPwrs;
    }
    public void setAttackNames(String[] atkNames){
        attackNames = atkNames;
    }
    public Characters getCopy(){
        //Characters copy = new Characters(name,health,attackPower);
        //return copy;
        try{
            return (Characters) super.clone();
        } catch (Exception e){
            return null;
        }
    }

    public String getStats(){
        String stats = name + ", " + health + "HP, " + attackPower + "AP";
        return stats;
    }
    public void attack(Characters target, int attackNumber){
        int attackDamage = attackPowers [attackNumber];
        switch (attackNumber)
        {
            case 1:
                attack1(target);
                break;
            case 2:
                attack2(target);
                break;
            case 3:
                attack3(target);
                break;
            case 4:
                attack4(target);
                break;
        }
    }

    public void attack1 (Characters target){
        target.health -= attackPowers[0];
        System.out.println("Franklin tackled " + target.name + "!");
    }
    public void attack2 (Characters target){
        target.health /= attackPowers[1];
        System.out.println("Franklin shocks " + target.name + "with its lightning");
    }
    public void attack3 (Characters target){
        target.health -= attackPowers[2];
        System.out.println("Franklin strikes " + target.name + "with thunder.");
    }
    public void attack4 (Characters target){
        health += attackPowers[3];
        System.out.println("Franklin restores health!");
    }

    public void attack(Characters target){
        if(Main.rand.nextDouble() < 0.3){
            int criticalHit = attackPower*2;
            target.health -= criticalHit;
            System.out.println(name + " attacks " + target.name + " for "+ criticalHit + " damage. Critical hit!");
            return;
        }
        target.health -= attackPower;
        System.out.println(name + " attacks " + target.name + " for " + attackPower + " damage!");
    }

} // End of class Pokemon
