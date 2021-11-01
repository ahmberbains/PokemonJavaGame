import java.util.Scanner;
import java.util.Random;

public class Main {

    // Public variables
    static Characters[] availableCharacters;
    static Scanner input;
    static Characters playerCharacters;
    static Characters opponentCharacters;
    static Random rand;



    public static void main(String[] args){
        System.out.println("Welcome to My GTA game!");

        createCharacters();
        input = new Scanner(System.in);
        selectCharacters();
        rand = new Random();
        selectOpponent();
        selectBattleAction();
        Franklin frank = new Franklin();
        frank.attack(opponentCharacters);




    } // End of main

    // Main methods/functions
    public static void createCharacters(){
        availableCharacters = new Characters[3];
        //availableCharacters[0] = new Characters("Franklin",100,10);
        availableCharacters[0] = new Franklin();
        availableCharacters[1] = new Trevor();
        availableCharacters[2] = new Michael();
        for(int i=0; i < availableCharacters.length; i++){
            System.out.println("Option " + (i+1) + ": " + availableCharacters[i].getStats());
        }
    }
    public static void selectCharacters(){
        // try/catch statement
        // The try/catch statement tries to run some code, then catches any exceptions.
        try{
            System.out.println("Pick your character by typing a number from 1 to " + availableCharacters.length + ".");
            String userInput = input.next();
            int playerSelection = Integer.parseInt(userInput);
            playerCharacters = availableCharacters[playerSelection-1].getCopy();
            System.out.println("You have selected " + playerCharacters.name + "!");
        } catch(Exception e) {
            System.out.println("Whoops! Something went wrong: " + e);
            selectCharacters();
        }
    }
    public static void selectOpponent(){
        int r = rand.nextInt(availableCharacters.length);
        opponentCharacters = availableCharacters[r].getCopy();
        System.out.println("Your opponent has selected " + opponentCharacters.name + "!");
        }
    public static void selectBattleAction(){
        System.out.println("Do you want to attack (1) or run away (2)?");
        String battleOption = input.next();
        // switch/case statement
        // if the switch(variable) has changed, then proceed with one of the specified cases
        switch(battleOption)
        {
            case "1":
                //Attack
                System.out.println("Choose your attack!");
                for(int i=0; i < playerCharacters.attackNames.length; i++){
                    System.out.println((i+1) + ". " + playerCharacters.attackNames[i]);
            }
                int attackNumber = input.nextInt();
                playerCharacters.attack(opponentCharacters);
                if (opponentCharacters.health <= 0){
                    System.out.println("You win! Your opponent congratulates you.");
                    break;
                }
                int randomAttack = rand.nextInt(opponentCharacters.attackNames.length);
                opponentCharacters.attack(playerCharacters);
                if(playerCharacters.health <= 0){
                    System.out.println("You lost! Keep practising.");
                    break;
                }
                System.out.println("Player: " + playerCharacters.getStats());
                System.out.println("Opponent: " + opponentCharacters.getStats());
                selectBattleAction();
                break;
            case "2":
                // Run away
                System.out.println("You ran away! The game has ended.");
                break;
            default:
                // Improper input
                System.out.println("Whoops! That was not a valid option.");
                selectBattleAction();
                break;
        }
    }




} // public class Main
