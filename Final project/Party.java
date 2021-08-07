import java.util.*;
public class Party /*extends PokemonID*/{
   private List<PokemonID> team;       //ArrList containing list of PokemonID objects
   private int active;                 //contains data point of arrList which is active
   
   public Party(int[]IDs){       //Creates a "Deck" of PokemonID objects
      team = new ArrayList<PokemonID>();
      active = 0;
      for(int n = 0; n < IDs.length; n++)
         team.add(new PokemonID(IDs[n], n));
   }
   
   public void remove(int U_ID)    //Removes the data spot whose IDsearch matches UniqueID
   {
      team.remove(IDsearch(U_ID));
   }
   
   public void setActive(int U_ID){    //Sets the active party index, takes in an ID
      active = IDsearch(U_ID);
   }
   
   public PokemonID getActive(){     //Returns the active PokemonID object
      return team.get(active);
   }
   
   
   public int IDsearch(int U_ID)   //Returns the index in the ArrList team w/ the Unique ID
   {
      for(int i = 0; i < team.size(); i++)
      {
         if(team.get(i).getUniqueID() == U_ID)
            return i;
      }
      System.out.println("ID not found");
      return 0;
   }
   
   public int indexSearch(int index)   //Returns UID for pokemonID object in the index
   {
      return team.get(index).getUniqueID();
   }
   
   public PokemonID getPokemon(int index){
      return team.get(index);
   }
         
   public int PokemonRemaining(){
      return team.size();       //Return size of team
   }
}