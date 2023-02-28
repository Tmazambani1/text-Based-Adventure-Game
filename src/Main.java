import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner keyscan = new Scanner(System.in);
        Random rand = new Random();

        //Our Game variables
        String[] enemies={"Dragon", "Zombie", "Goblin","Vampire"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // Players Variables
        int health =100;
        int attackDamage =50;
        int numHealthPotions = 3;
        int healthPotionsHeals=25;
        int healthPotionsDropChance = 25; //percent

        boolean running= true;

        System.out.println("Welcome to the Dungeon!");
        GAME:
        while(running) {
            System.out.println("***********************************************");
            System.out.println("Instructions");
            System.out.println("***********************************************");
            System.out.println("You are in a dungeon and you must fight the enemy to survive. ");
            System.out.println("You have a 100 health.");
            System.out.println("You have to three options fight, drink health potions(3 max) or run!");
            System.out.println("To play you need to enter in the console");
            System.out.println("(1) Attack, (2) drink health potions or (3) Run!");
            System.out.println("Good luck on your travels dungeon master!!! ");
            System.out.println("***********************************************");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy=enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# A "+ enemy+ " has appeared! #");

            while (enemyHealth>0)
            {   System.out.println("***********************************************");
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("***********************************************");
                System.out.println("\tWhat would you like to do?");
                System.out.println("\t1. Attack!");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");
                System.out.println("***********************************************");

                String input = keyscan.nextLine();
                if (input.equals("1"))
                {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth-=damageDealt;
                    health-=damageTaken;

                    System.out.println("\t> You strike the "+ enemy + " for "+ damageDealt +" damage.");
                    System.out.println("\t> You receive "+ damageTaken + " in retaliation");


                    if (health<1){
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                } else if (input.equals("2"))
                {
                    if (numHealthPotions >0)
                    {
                        health += healthPotionsHeals;
                        numHealthPotions--;
                        System.out.println("\t> You have drank a health potion, you have healed for " + healthPotionsHeals + "." +
                                "\n\t You now have " + health + "HP!" +
                                "\n\t You have " + numHealthPotions + " health potions left.!\n");
                    } else {
                        System.out.println("\t> You have no health potions left! defeat your enemies for a chance to get one");
                    }

                } else if (input.equals("3"))
                {
                    System.out.println("\tYou run away from the" + enemy+ "!");
                    continue GAME;
                }else {
                    System.out.println("\tInvalid Command!");
                    }


            } if ( health <1){
                System.out.println("You limp out of the dungeon, too weak to continue battle.");
                break;

            }
            System.out.println("***********************************************");
            System.out.println(" # The "+ enemy + " was defeated! #" );
            System.out.println(" # You have "+ health + "HP left! #");
            if(rand.nextInt(100)<healthPotionsDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potions! #");
                System.out.println(" # You now have "+ numHealthPotions + " health potions(s). # ");
        }
            System.out.println("***********************************************");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit Dungeon");

            String input = keyscan.nextLine();

            while (!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid Command!");
                input = keyscan.nextLine();
            }
            if (input.equals("1")){
                System.out.println("You continue with your adventure!");
            } else if (input.equals("2")){
                System.out.println("You exit the dungeon, successful from your adventures");
                break;
            }

        }
        System.out.println("***********************************************");
        System.out.println("# Well done, thank you for playing! # ");
        System.out.println("***********************************************");



        keyscan.close();
    }
}