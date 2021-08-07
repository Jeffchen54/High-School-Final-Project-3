import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.*;

public class test{
   private static Party user;
   private static Party enemy;
   private static boolean BattleOver;
   public static void main(String[]args) throws InterruptedException{
      Scanner scan = new Scanner(System.in);
      //music m = new music("115-battle (vs trainer)");
      int bernieStacks = 0;
      
      int[] a = new int[]{1,2,7};    //import IDs into curly brackets.
      int[] b = new int[]{7,7,7};    //Uncompatible with dupes, add feature if have time.  Is added now with the help of Unique IDs
      BattleOver = false;
      int turns = 0;
      user = new Party(a);
      enemy = new Party(b);
      System.out.println("Are you running in MS-DOS?");
      Thread.sleep(3000);
      while(BattleOver == false){
         ClrScreen();
         Graphics.startScreen(user, enemy);
         int choice = scan.nextInt();
         ClrScreen();
         if(choice == 0){
            Graphics.moveDescription(user.getActive(), enemy.getActive());
            System.out.println("Enter anything to continue");
            scan.next();
         }
         else if(choice == 999){
            Graphics.switchScreen(user);
            System.out.println("Choose which one to switch to, type random number if go back.");
            int partySelection = scan.nextInt();
            user.setActive(partySelection);
         }
         if(user.getActive().getSpd() >= enemy.getActive().getSpd() && moveChecker(user.getActive(), choice))  //If user is faster
         {
            fixedScreen();
            System.out.println("Your Move!!!");
            MoveID.initiateMove(choice, user.getActive().getStacks(), user, enemy);
            Thread.sleep(1000);
            ClrScreen();
            fixedScreen();   
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
               System.out.println("Enemy's Move!!!");
               MoveID.initiateMove(AI.decisions(enemy.getActive().getID(), enemy, enemy.getActive()), enemy.getActive().getStacks(), enemy, user);
               Thread.sleep(1000);
               if(user.getActive().getHP() == 0){ //Checks if the enemy pokemon is dead, declares winner or switches out
                  System.out.println(user.getActive().getName() + " has fainted!");
                  user.remove(user.getActive().getUniqueID());
                  if(user.PokemonRemaining() == 0){
                     System.out.println("You LOSE, BAKA!!!");
                     BattleOver = true;
                  }
                  else
                  {
                     Graphics.switchScreen(user);
                     System.out.println("Choose which one to switch to");
                     int partySelection = scan.nextInt();
                     user.setActive(partySelection);
                  }
               }
            }
         }
         else if (moveChecker(user.getActive(), choice))          //If enemy is faster
         {
            fixedScreen();
            System.out.println("Enemy's Move!!!");
            MoveID.initiateMove(AI.decisions(enemy.getActive().getID(), enemy, enemy.getActive()), enemy.getActive().getStacks(), enemy, user);
            Thread.sleep(1000);
            if(user.getActive().getHP() == 0){ //Checks if the enemy pokemon is dead, declares winner or switches out
               System.out.println(user.getActive().getName() + " has fainted!");
               user.remove(user.getActive().getUniqueID());
               if(user.PokemonRemaining() == 0){
                  System.out.println("You LOSE, BAKA!!!");
                  BattleOver = true;
               }
               else
               {
                  Graphics.switchScreen(user);
                  System.out.println("Choose which one to switch to");
                  int partySelection = scan.nextInt();
                  user.setActive(partySelection);
               }
            }
            else
            {
               ClrScreen();
               fixedScreen();
               System.out.println("Your Move!!!");
               MoveID.initiateMove(choice, user.getActive().getStacks(), user, enemy);
               Thread.sleep(1000);
               ClrScreen();
               fixedScreen();   
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
            }
         }
         //Thread.sleep(2000);
      }
   }
   public static void ClrScreen(){
      for(int n = 0; n < 100; n++)
         System.out.println("\n");
   }
   public static void fixedScreen(){            
      Graphics.getStatusWindow(user, enemy);
   }
   public static boolean moveChecker(PokemonID object, int choice){
      int[] moves = object.getMoveID();
      for(int n: moves)
         if(choice == n)
            return true;
      return false;
   }
  
   public static void play() {//Unused code, unable to play music without the game freezing up
      try {
         File file = new File("115-battle (vs trainer)" + ".wav");
         Clip clip = AudioSystem.getClip();
         clip.open(AudioSystem.getAudioInputStream(file));
         clip.start();
         Thread.sleep(215000);
         play();
      } catch (Exception e) {
         System.err.println(e.getMessage());
      }
   }   
 
}
