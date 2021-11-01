public class Franklin extends Characters{

    //franklin instance variables
    double lightningStrikePower = 5;
    //constructor
    public Franklin(){
        super("Franklin", 100, 10);
        String [] atkNames = {"Tackle", "Lightning Strike", "Thunder","-"};
        int[] atkPwrs = {5,5,40};
        setAttackNames(atkNames);
        setAttackPowers(atkPwrs);

    }

    public void attack(Franklin target){
        target.health /= lightningStrikePower;
        System.out.println("Franklin shocks " + target.name + " with his taser!");
    }

    //pikachu methods
    public void attack1 (Characters target){
        attack(target);
    }
    public void attack2 (Characters target){

    }
    public void attack3 (Characters target){

    }
    public void attack4 (Characters target){

    }

} //end of class franklin
