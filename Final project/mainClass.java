import java.util.Scanner;
public class mainClass{

   public static void main(String[]args) throws InterruptedException{
      Scanner scan = new Scanner(System.in);
      int bernieStacks = 0;
      int[] a = new int[]{1, 2, 7};    //import IDs into curly brackets.
      int[] b = new int[]{1, 2, 7};    //Uncompatible with dupes, add feature if have time.
      boolean BattleOver = false;
      int turns = 0;
      Party user = new Party(a);
      Party enemy = new Party(b);
      
      while(BattleOver == false){
         System.out.println(turns);
         Graphics.getStatusWindow(user, enemy);
         Graphics.getMoves(user.getActive());
         int choice = scan.nextInt();
         if(user.getActive().getSpd() >= enemy.getActive().getSpd())
         {
            MoveID.initiateMove(choice, user.getActive().getStacks(), user, enemy);    ///2021 Edit -> Fixed from user.getStacks() to user.getActive().getStacks()
            if(enemy.getActive().getHP() == 0){ //Checks if the enemy pokemon is dead, declares winner or switches out
               System.out.println(enemy.getActive().getName() + " has fainted!");
               enemy.remove(enemy.getActive().getUniqueID());
               if(enemy.PokemonRemaining() == 0){
                  System.out.println("You Win!!!");
                  BattleOver = true;
               }
               else
                  System.out.println("Enemy has switched out to " + enemy.getActive().getName() + "!");  //If remaining pokemon, switches auto that that one
            }
            else
            {
               MoveID.initiateMove(AI.decisions(enemy.getActive().getID(), enemy, enemy.getActive()), enemy.getActive().getStacks(), enemy, user);
            }
         }
         turns++;
      }
   
   }
   
}