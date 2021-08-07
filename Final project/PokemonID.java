public class PokemonID{
   private int ID;
   private int Atk, Def, Spd, Eva, Crit, Hp, ZMoveLimit, baseHP;
   private String Name;
   private int[] moveID;
   private boolean ZMove;
   private int stacks;
   private int uniqueID;
   
   public PokemonID(){}

   
   public PokemonID(int ID, int uniqueID){
      this.ID = ID;  
      searchID(this.ID);
      
      ZMove = true;    
      ZMoveLimit = Hp / 2;
      Eva = Spd/30;
      Crit = Eva;
      baseHP = Hp;
      stacks = 0;
      this.uniqueID = uniqueID;
   }

   private void searchID(int ID)    //Searches datebase for ID,  You can add new IDs here.   Political Moves are the last index of moveID
   {
      if(ID == 999)
      {
         Name = "Tester1";
         Hp = 1000;
         Atk = 1000;
         Def = 1000;
         Spd = 1000;
         Crit = 100;
         moveID = new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9};
      }
      else if(ID == 0){
         Name = "Zero";
         Hp = 0;
         Atk = 0;
         Def = 0;
         moveID = new int[]{1, 2, 3, 4};
      }
      else if(ID == 1)
      {
         Name = "Bernie Sanders";
         Hp = 444;
         Atk = 372;
         Def = 372;
         Spd = 372;
         moveID = new int[]{1, 2, 3, 4, 500};
      }
      else if(ID == 2){
         Name = "Alexandria Cortez";
         Hp = 304;
         Atk = 317;
         Def = 306;
         Spd = 504;
         moveID = new int[]{9,10,11,12,502};
      }
      else if(ID == 7){
         Name = "Ted Cruz";
         Hp = 444;
         Atk = 450;
         Def = 504;
         Spd = 318;
         moveID = new int[]{5,6,7,8,501};
      }
      else if(ID == 8){
         Name = "Joe Biden";
         Hp = 524;
         Atk = 350;
         Def = 251;
         Spd = 174;
         moveID = new int[]{13,14,15,4,503};
      }
      else
      {
         Name = "MissingNo.";
         Hp = 0;
         Atk = 0;
         Def = 0;
         Spd = 0;
         Crit = 0;
         Eva = 0;
         Spd = 0;
         moveID = new int[]{0,0,0,0};
      }
   }
   //All setter and getter methods
   public int getHP(){
      return Hp;
   }
   
   public int getBaseHp(){
      return baseHP;
   }
   
   public int getStacks(){
      return stacks;
   }

   
   public int getID(){
      return ID;
   }
   
   public int getAtk(){
      return Atk;
   }
   
   public int getDef(){
      return Def;
   }
   
   public int getEva(){
      return Eva;
   }
   
   public int getCrit(){
      return Crit;
   }
   
   public String getName(){
      return Name;
   }
   
   public int getSpd(){
      return Spd;
   }
   
   public int[] getMoveID(){
      return moveID;
   }
   
   public boolean getZMoveStatus(){
      return ZMove;
   }
   
   public int getZLimit(){
      return ZMoveLimit;
   }
   
   public void changeZMoveStatus(){
      ZMove = !ZMove;
   }
   
   public int HpMod(int dmg)
   {
      if((Hp + (-1 * dmg)) <= 0)
         Hp = 0;
      else
         Hp += (-1 * dmg);
      if(Hp > baseHP)
         Hp = baseHP;
      return Hp;
   }
   
   public int AtkMod(double nerf)
   {
      return (int)(Atk *= nerf);
   }
   public int AtkAdd(double nerf)
   {
      return (int)(Atk += nerf);
   }

   
   public int DefMod(int broke)
   {
      return Def += broke;
   }
   

   public void SpdMod(int haste)
   {
      Spd += haste;
      if(Spd >= 1500)
      {
         System.out.println("Speed is Maxed!");
         Spd = 1500;
      }
      Eva = Spd/30;
      Crit = Eva;
   }
     
      
   public void addStacks(){
      stacks++;
   }
   
   public int getUniqueID(){
      return uniqueID;
   }
   
}