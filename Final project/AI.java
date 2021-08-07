public class AI{

   public static int decisions(int n, Party object, PokemonID enemy){
      if(n == 1)  // n is ID values under 13 unless modifications have been made
         return Sanders(object.getActive());
      if(n == 2)
         return Cortez(object.getActive(), enemy);
      if(n == 7)
         return Cruz(object.getActive());
      if(n == 99)    //returns index one ahead of fainted Pokemon. Untested
         return object.IDsearch(object.getActive().getUniqueID()) + 1;
      else
         System.out.println("AI error");
      return 0;
   }
   private static int Sanders(PokemonID sanders){//{1, 2, 3, 4, 900}
      int[] moves = sanders.getMoveID();
      int rando = (int)(Math.random() * 2);
      if(sanders.getHP() == sanders.getBaseHp())      //Socialist takeover conditions
         return moves[1];
      if(sanders.getHP() <= sanders.getZLimit() && sanders.getZMoveStatus() == true){      //Political move conditions
         return moves[4];
      }
      if(sanders.getHP() <= sanders.getZLimit())      //Free Healthcare conditions
         return moves[2];     //Public support conditions
      if(rando == 1) 
         return moves[0];
      else                 //Super taxation if no other condition matches.
         return moves[3];
   }
   
   private static int Cruz(PokemonID cruz){
      int[] moves = cruz.getMoveID();
      int rando = (int)(Math.random() * 6);
      if(cruz.getHP() <= cruz.getZLimit() && cruz.getZMoveStatus() == true)      //Political move conditions
         return moves[4];
      if(cruz.getZMoveStatus() == false || cruz.getHP() <= cruz.getBaseHp() * 0.7)
         return moves[1];
      if(cruz.getAtk() > 1500)
         return moves[3];
      if(rando <= 1)
         return moves[2];
      if(rando == 4)
         return moves[3];
      else
         return moves[0]; 
   
   }
   private static int Cortez(PokemonID cortez, PokemonID enemy){
      int[] moves = cortez.getMoveID();
      int rando = (int)(Math.random() * 6);
      if(cortez.getHP() <= cortez.getZLimit() && cortez.getZMoveStatus() == true)
         return moves[4];
      if(enemy.getDef() >= 800)
         return moves[3];
      if(cortez.getSpd() >= 1000)
         return moves[1];
      if(rando <= 1)
         return moves[2];
      else
         return moves[0];
   }
}