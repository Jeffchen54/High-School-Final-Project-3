
public class Graphics{
   public static void startDialouge(){
      System.out.println(" -----------------------------");
      System.out.println("|                             |");
      System.out.println("|    Battle Start             |");
      System.out.println("|_____________________________|");
   }
   public static void getMoves(PokemonID object){    //Grabs all moveIDs from pokemon and translates their ID. Shows all but Political Moves
      int[] moves = object.getMoveID();
      System.out.println("0) Move Description | Status");
      System.out.println("999) Switch Pokemon");
      for(int n = 0; n < moves.length - 1; n++)
         System.out.println(moves[n] + ") " + MoveID.MoveIDName(moves[n]));
      if(object.getHP() <= object.getZLimit() && object.getZMoveStatus() == true)
         getPolticalMove(object);
   }
   private static void getPolticalMove(PokemonID object){    // Prints political move
      int[] moves = object.getMoveID();
      System.out.println(moves[moves.length - 1] + ") " + MoveID.MoveIDName(moves[moves.length - 1]));
   }
   public static void getStatusWindow(Party user, Party enemy){
      System.out.println(" -----------------------------              -----------------------------");//30 wide
      System.out.println("| User: " + user.getActive().getName() + spaceGenerator(user.getActive().getName(), 23) + "            | Enemy: " + enemy.getActive().getName() + spaceGenerator(enemy.getActive().getName(), 22));
      System.out.println("| Hp: " + user.getActive().getHP() + "/" + user.getActive().getBaseHp() + spaceGenerator(Integer.toString(user.getActive().getHP()) + Integer.toString(user.getActive().getBaseHp()), 24) + "            | Hp: " + enemy.getActive().getHP() + "/" + enemy.getActive().getBaseHp() + spaceGenerator(Integer.toString(enemy.getActive().getHP()) + Integer.toString(enemy.getActive().getBaseHp()), 24));
      System.out.println("|_____________________________|            |_____________________________| ");
      System.out.println("| Remaining Units: " + user.PokemonRemaining() + spaceGenerator(Integer.toString(user.PokemonRemaining()), 12) + "            | Remaining Units: " + enemy.PokemonRemaining() + spaceGenerator(Integer.toString(enemy.PokemonRemaining()), 12));
      System.out.println("|_____________________________|            |_____________________________| ");
   }
   
  
   private static String spaceGenerator(String s1, int spaces)
   {
      String toReturn = "";
      for(int n = s1.length(); n < spaces - 1; n++)
         toReturn += " ";
      if(toReturn.length() < spaces - 1)
         toReturn += "|";
      return toReturn;
   }
   public static void moveDescription(PokemonID user, PokemonID opposing)
   {
      System.out.println("Your moves: ");
      for(int n = 0; n < user.getMoveID().length; n++)
         MoveID.MoveIDDescription(user.getMoveID()[n]);
         
      System.out.println("\nOpponent's moves: ");
      for(int n = 0; n < opposing.getMoveID().length; n++)
         MoveID.MoveIDDescription(opposing.getMoveID()[n]);
         
      System.out.println(" ---------------------------            --------------------------- ");
      System.out.println("|    USER " + user.getName() + spaceGenerator(user.getName(), 19) + "          |    Enemy " + opposing.getName() + spaceGenerator(opposing.getName(), 18));
      System.out.println("| Hp: " + user.getHP() + "/" + user.getBaseHp() + spaceGenerator(Integer.toString(user.getHP()) + Integer.toString(user.getBaseHp()), 22) + "          | Hp: " + opposing.getHP() + "/" + opposing.getBaseHp() + spaceGenerator(Integer.toString(opposing.getHP()) + Integer.toString(opposing.getBaseHp()), 22));
      System.out.println("| Atk: " + user.getAtk() + spaceGenerator(Integer.toString(user.getAtk()), 7) + "Def: " + user.getDef() + spaceGenerator(Integer.toString(user.getDef()), 10) + "          | Atk: " + opposing.getAtk() + spaceGenerator(Integer.toString(opposing.getAtk()), 7) + "Def: " + opposing.getDef() + spaceGenerator(Integer.toString(opposing.getDef()), 10)); 
      System.out.println("| Spd: " + user.getSpd() + spaceGenerator(Integer.toString(user.getSpd()), 7) + "Crit: " + user.getCrit() + spaceGenerator(Integer.toString(user.getCrit()), 9) + "          | Spd: " + opposing.getSpd() + spaceGenerator(Integer.toString(opposing.getSpd()), 7) + "Crit: " + opposing.getCrit() + spaceGenerator(Integer.toString(opposing.getCrit()), 9)); 
      System.out.println("| Eva is equal to crit      |          | Eva is equal to crit      |");
      System.out.println("| Bernie Stacks: " + user.getStacks() + spaceGenerator(Integer.toString(user.getStacks()), 12) + "          | Bernie Stacks: " + opposing.getStacks() + spaceGenerator(Integer.toString(opposing.getStacks()), 12)); 
      System.out.println("|___________________________|          |___________________________|");
   }
   public static void switchScreen(Party object){
      for(int n = 0; n < object.PokemonRemaining(); n++)
         System.out.println(object.indexSearch(n) + ") " + object.getPokemon(n).getName());
   }
   public static void startScreen(Party user, Party enemy){
      Graphics.getStatusWindow(user, enemy);
      Graphics.getMoves(user.getActive());
   
   }
}