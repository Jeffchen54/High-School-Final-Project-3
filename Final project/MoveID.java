public class MoveID {  //Combined with the calculations class, contains all move IDs, //As of 7:37, should work hopefully
   private static boolean CritActivated;
   private static boolean EvaActivated;

   public static String MoveIDName(int n){    //Returns move name
      if(n == -1)
         return "100 DAMAGE";
      if(n == -2)
         return "50% DAMAGE";
      if(n == -3)
         return "ONE-HIT KO";
      if(n == 1)
         return "Public Support";
      if(n == 2)
         return "Socialist Takeover";
      if(n == 3)
         return "Free Healthcare";
      if(n == 4)
         return "Super Taxation";
      if(n == 5)
         return "The Zodiac Force";
      if(n == 6)
         return "Butcher";
      if(n == 7)
         return "Maple Syrup";
      if(n == 8)
         return "Texas Shotgun";
      if(n == 9)
         return "The Green New Deal";
      if(n == 10)
         return "Young Wisdom";
      if(n == 11)
         return "Bernie's Sis";
      if(n == 12)
         return "What You Mean?";
      if(n == 500)
         return "Bernie Bros";
      if(n == 501)
         return "The Zodiac Killer";
      if(n == 502)
         return "(In)Equal Divison of Resources";
      if(n == 503)
         return "Hil?a?y ?lin?t?n";
         
      return "MOVE_NAME_EXCEPTION";
   }
   
   public static void MoveIDDescription(int n){
      if(n == 1)
         System.out.println(MoveIDName(n) + ") Buff; Increase attack by 10%, adds one Bernie Stack");
      else if(n == 2)
         System.out.println(MoveIDName(n) + ") Attack; Deals current stats value / 3 (hint* use this at the start for maximum coverage).");
      else if(n == 3)
         System.out.println(MoveIDName(n) + ") Recovery; Heal by 50% max Hp. Opposing Pokemon heals by 10% max Hp.");
      else if(n == 4)
         System.out.println(MoveIDName(n) + ") Attack; Deals dmg proportional to your total attack and 20% of the opposing Pokemon's attack");
      else if(n == 5)
         System.out.println(MoveIDName(n) + ") Buff; Increases attack by 20% and Spd by 20 points.");
      else if(n == 6)
         System.out.println(MoveIDName(n) + ") Attack; Recovery; Deals dmg proportional to your total attack and heals 20% of damage dealt.");
      else if(n == 7)
         System.out.println(MoveIDName(n) + ") Debuff; Reduces enemy speed by 50 points and attack by 10%.");
      else if(n == 8)
         System.out.println(MoveIDName(n) + ") Attack; Deals 10%-30% of attack power 6 times.");
      else if(n == 9)
         System.out.println(MoveIDName(n) + ") Buff; Increase speed by 100.");
      else if(n == 10)
         System.out.println(MoveIDName(n) + ") Attack; Deals damage proportional to speed stat.");
      else if(n == 11)
         System.out.println(MoveIDName(n) + ") Attack; Deals 1-8 damage 100 times.");
      else if(n == 12)
         System.out.println(MoveIDName(n) + ") Attack; True; Deals true damage equal to attack stat."); 
      else if(n == 13)
         System.out.println("Buff; Defense increases by 35% and speed decreases by 35%");
      else if(n == 14)
         System.out.println("Luck; Chance to activate the following effects: (1) Opponent's attack and speed increase by 15%, (2) Deals true damage proportional to defense stat, (3) Lower opponent's attack, defense, and speed by 10%.");
      else if(n == 15)
         System.out.println("Luck; Deals damage ranging from 50% to 300% of attack.");
      else if(n == 500)
         System.out.println(MoveIDName(n) + ") POLITICAL MOVE; Attack; True; Deals 1-8 damage 100 times. Bernie stacks boost each hit by 1 damage.");
      else if(n == 501)
         System.out.println(MoveIDName(n) + ") POLITICAL MOVE; Buff; Puts the sum of all stats (not included eva and crit) into attack. Spd is increased by 100 (not factored in).");
      else if(n == 502)
         System.out.println(MoveIDName(n) + ") POLITICAL MOVE; Buff; Stats double.");
      else
         System.out.println("MOVE DESCRIPTION EXCEPTION");
   }
   public static void initiateMove(int n, int bernieStacks, Party attacker, Party defender) throws InterruptedException{    //Does the move's function
      Thread.sleep(2000);
      System.out.println(attacker.getActive().getName() + " uses " + MoveIDName(n) + "!");
      Thread.sleep(2000);
      test.ClrScreen();
      test.fixedScreen();
   
      if(n == 1){                               //Remember to call bernie stacks in MasterClass
         attacker.getActive().addStacks();
         attacker.getActive().AtkMod(1.1);      //Atk boosted by 10%
         System.out.println("The USA is now more communist!");
         Thread.sleep(2000);
         test.ClrScreen();
         test.fixedScreen();
         System.out.println(attacker.getActive().getName() + " attack increases!");
         Thread.sleep(2000);
         test.ClrScreen();
         test.fixedScreen();
         System.out.println(attacker.getActive().getName() + " acquires a Bernie Stack!");
      }
      if(n == 2){       //defender hp - (attacker hp, atk, def, spd) /3 
         System.out.println("The New Republic of U.S.A is being Established!");
         Thread.sleep(2000);
         test.ClrScreen();
         int dmg = DmgCalc(attacker, defender, (attacker.getActive().getHP() +  attacker.getActive().getAtk() +  attacker.getActive().getDef() +  attacker.getActive().getSpd()) / 3);
         defender.getActive().HpMod(dmg);
         test.fixedScreen();
         System.out.println(defender.getActive().getName() + " takes " + dmg + " DMG!");
      }
      if(n == 3){    //attacker heals 50% base hp and defender heals 10% base hp, not affected by DmgCalc
         attacker.getActive().HpMod((int)(attacker.getActive().getBaseHp() * 0.5) * -1);
         System.out.println(attacker.getActive().getName() + " recovers lots of Hp!");
         Thread.sleep(2000);
         test.ClrScreen();
         test.fixedScreen();
         defender.getActive().HpMod((int)(defender.getActive().getBaseHp() * 0.1) * -1);
         System.out.println(defender.getActive().getName() + " recovers slightly as a benefit of socialism!");
         
      }
      if(n == 4){    //defender hp - attacker atk * 1 + defender atk * 0.2
         System.out.println(defender.getActive().getName() + " is hit by 100% income tax used for the 'Future' of the State!");
         Thread.sleep(2000);
         test.ClrScreen();
         int dmg = 0;
         if(defender.getActive().getID() >= 500)
         {
            System.out.println("It was SUPER EFFECTIVE!");
            Thread.sleep(2000);
            test.ClrScreen();
            test.fixedScreen();
            System.out.println(defender.getActive().getName() + " IS BANKRUPT!!!!!");
            Thread.sleep(2000);
            test.ClrScreen();
            test.fixedScreen();
            dmg = 2 * (attacker.getActive().getAtk() + (int)(defender.getActive().getAtk() * 0.35));
         }
         else{
            dmg = DmgCalc(attacker, defender, attacker.getActive().getAtk() + (int)(defender.getActive().getAtk() * 0.35));
         }
         defender.getActive().HpMod(dmg);
         test.fixedScreen();
         System.out.println(defender.getActive().getName() + " takes " + dmg + " DMG!");
      }
      if(n == 5)
      {
         System.out.println("A red aura is coming out of " + attacker.getActive().getName());
         Thread.sleep(2000);
         test.ClrScreen();
         test.fixedScreen();
         System.out.println(attacker.getActive().getName() + " attack increases by 20% and speed increases by 20 points!");
         attacker.getActive().AtkMod(1.2);
         attacker.getActive().SpdMod(20);  
      }
      if(n == 6)
      {
         System.out.println(attacker.getActive().getName() + " charges at " + defender.getActive().getName() + " with malicious intent!");
         Thread.sleep(2000);
         test.ClrScreen();
         int dmg = DmgCalc(attacker, defender, attacker.getActive().getAtk());
         defender.getActive().HpMod(dmg);
         test.fixedScreen();
         System.out.println(defender.getActive().getName() + " takes " + dmg + " dmg!");
         Thread.sleep(2000);
         test.ClrScreen();
         attacker.getActive().HpMod((int)(dmg * -0.2));
         test.fixedScreen();
         System.out.println(attacker.getActive().getName() + " heals " + (int)(dmg * 0.2) + " hp!"); 
      }
      if(n == 7)
      {
         System.out.println(attacker.getActive().getName() + " is CANADIAN!?");
         Thread.sleep(2000);
         test.ClrScreen();
         test.fixedScreen();
         System.out.println(defender.getActive().getName() + " attack and speed decreases due to sticky maple syrup!");
         defender.getActive().AtkMod(0.9);
         defender.getActive().SpdMod(-50);
      }
      if(n == 8)
      {
         System.out.println("Go Away Socialist!!!");
         Thread.sleep(2000);
         test.ClrScreen();
         int dmg = 0;
         dmg += (int)((Math.random() * 4 + 5) * defender.getActive().getAtk() * 0.2);
         dmg = DmgCalc(attacker, defender, dmg);
         defender.getActive().HpMod(dmg);
         test.fixedScreen();
         System.out.println(defender.getActive().getName() + " takes " + dmg + " damage!");
      }
      if(n == 9){
         System.out.println("Super realistic goal requires super realistic measures!");
         Thread.sleep(2000);
         test.ClrScreen();
         test.fixedScreen();
         attacker.getActive().SpdMod(100);
         System.out.println(attacker.getActive().getName() + " speed sharply increases!");    
      }
      if(n == 10)
      {
         System.out.println(attacker.getActive().getName() + " flexing on the House of Republicans and " + defender.getActive().getName() + "!");
         Thread.sleep(2000);
         test.ClrScreen();
         int dmg = DmgCalc(attacker, defender, attacker.getActive().getSpd());
         defender.getActive().HpMod(dmg);
         test.fixedScreen();
         System.out.println(attacker.getActive().getName() + " deals " + dmg + " Dmg!");
      }
      if(n == 11)
      {
         int sandersRage = 0;
         for(int loops = 0; loops < 100; loops++)
            sandersRage += (int)(Math.random() * 8) + 5; 
         System.out.println("The Bernie Sis's take up arms!");
         sandersRage = DmgCalc(attacker, defender, sandersRage);
         defender.getActive().HpMod(sandersRage);
         Thread.sleep(2000);
         test.ClrScreen();
         test.fixedScreen();
         System.out.println(defender.getActive().getName() + " takes " + sandersRage + " Dmg!"); 
      }
      if(n == 12)
      {
         System.out.println(attacker.getActive().getName() + " bullcrap is very effective!");
         Thread.sleep(2000);
         test.ClrScreen();
         defender.getActive().HpMod(attacker.getActive().getAtk());
         test.fixedScreen();
         System.out.println(defender.getActive().getName() + " takes " + attacker.getActive().getAtk());      
      }
      if(n == 13)
      {
         System.out.println(attacker.getActive().getName() + " began snoozing during his speech!");
         Thread.sleep(2000);
         test.ClrScreen();
         defender.getActive().DefMod((int)(defender.getActive().getDef() * 1.35));
         defender.getActive().SpdMod((int)(defender.getActive().getSpd() * 0.65));
         test.fixedScreen();
         System.out.println(defender.getActive().getName() + " becomes closer to a true immovable object!");
      }
      if((n >= 500 && attacker.getActive().getZMoveStatus() == false) || (n >= 500 && attacker.getActive().getHP() > attacker.getActive().getZLimit()))
      {
         System.out.println("The FOOL's ENEMY GETS A FREE TURN!!!!");
         Thread.sleep(10000);
      }
      if(n >= 500 && attacker.getActive().getHP() <= attacker.getActive().getZLimit() && attacker.getActive().getZMoveStatus() == true){
         System.out.println("POLITICAL MOVE!!!!!!!!!!");
         Thread.sleep(2000);
         test.ClrScreen();
         test.fixedScreen();
         
         if(n == 500){ //defender hp - Loop(100)@(rando 1-8 + stacks), not affected by DmgCalc
            attacker.getActive().changeZMoveStatus();
            int sandersRage = 0;
            for(int loops = 0; loops < 100; loops++)
               sandersRage += (int)(Math.random() * 8) + 1 + attacker.getActive().getStacks(); 
            defender.getActive().HpMod(sandersRage);
            attacker.getActive().changeZMoveStatus();
            System.out.println("THE BERNIE BROS TAKE UP ARMS !!!!!");
            Thread.sleep(2000);
            test.ClrScreen();
            test.fixedScreen();
            System.out.println(defender.getActive().getName() + " takes " + sandersRage + " Dmg!!!!!"); 
         }
         if(n == 501){
            attacker.getActive().changeZMoveStatus();
            int cruz = attacker.getActive().getBaseHp() + attacker.getActive().getAtk() + attacker.getActive().getDef() + attacker.getActive().getSpd();
            attacker.getActive().AtkAdd(cruz);
            System.out.println("THE ZODIAC KILLER AWAKENS!!!!!");
            Thread.sleep(2000);
            test.ClrScreen();
            test.fixedScreen();
            System.out.println(attacker.getActive().getName() + " attack is superboosted!!!");
         }
         if(n == 502)
         {
            attacker.getActive().changeZMoveStatus();
            System.out.println("SOCIALIST POLICIES HAVE BEEN IMPLEMENTED!!!!!");
            Thread.sleep(2000);
            test.ClrScreen();
            attacker.getActive().HpMod((int)(defender.getActive().getBaseHp() * -0.25));
            defender.getActive().HpMod((int)(defender.getActive().getBaseHp() * 0.25));
            attacker.getActive().AtkAdd((int)(defender.getActive().getAtk() * 0.25));
            defender.getActive().AtkAdd((int)(defender.getActive().getAtk() * -0.25));
            attacker.getActive().DefMod((int)(defender.getActive().getDef() * 0.25));
            defender.getActive().DefMod((int)(defender.getActive().getDef() * -0.25));
            attacker.getActive().SpdMod((int)(defender.getActive().getSpd() * 0.25));
            defender.getActive().SpdMod((int)(defender.getActive().getSpd() * -0.25));
            test.fixedScreen();
            System.out.println(attacker.getActive().getName() + " has taken their fair share!!!!! Or not!!!???");
             
         }
      }
      if(n == -1){    //Deals 100 true damage
         System.out.println(attacker.getActive().getName() + " uses " + MoveIDName(n) + "!");
         defender.getActive().HpMod(DmgCalc(attacker, defender, 100));
      
      }
      if(n == -2){    //Deals dmg = Zlimit + 1
         defender.getActive().HpMod(defender.getActive().getZLimit() + 1);
         System.out.println(attacker.getActive().getName() + " uses " + MoveIDName(n) + "!");
      }
      if(n == -3){
         System.out.println(attacker.getActive().getName() + " uses " + MoveIDName(n) + "!");
         System.out.println(defender.getActive().getHP());
         defender.getActive().HpMod(defender.getActive().getBaseHp());
      }
      Thread.sleep(2000);
      
   }
   private static int DmgCalc(Party attacker, Party defender, int atk) throws InterruptedException{ //Calcs crit, eva, and def variables
      CritActivated = false;
      EvaActivated = false;
      
      atk = critCalc(attacker, atk);   //Calcs if has crit, CritActivated is activated if crit
      if(CritActivated == false)        //if CritActivated was activated, overrides evasion
         atk = evaCalc(defender, atk); //Calcs if evasion occured. EvaActivated if activated if eva occured
         
      if(EvaActivated == false)         //Calcs only if EvaActivated has been activated
         atk = defCalc(defender, atk); //Calcs value after def has been taken out
                  
      return atk;
   }
   
   private static int critCalc(Party attacker, int atk) throws InterruptedException{ //Calculates if crit occured. 1.5x mutiplier.
      int chance = (int)(Math.random() * 100);
      if(attacker.getActive().getCrit() >= chance){
         System.out.println("IT WAS A CRITICAL HIT!!!"); //one liner that doesn't need to be coded into graphics class
         Thread.sleep(2000);
         CritActivated = true;
         return (int)(atk * 1.5);
      }
      return atk;
   }

   private static int evaCalc(Party defender, int atk)throws InterruptedException{//Calculates if evasion occured.
      int chance = (int)(Math.random() * 100);
      if(defender.getActive().getEva() >= chance){
         System.out.println("IT MISSED!!!"); //one liner that doesn't need to be coded into graphics class
         Thread.sleep(2000);
         EvaActivated = true;
         return (0);
      }
      return atk;
   }
   
   private static int defCalc(Party defender, int atk) throws InterruptedException{
      if(atk <= defender.getActive().getDef()){
         System.out.println("DEFENSE WAS TOO HIGH!!!");
         Thread.sleep(2000);
         return 1;
      }
      else
      {
         return Math.abs(defender.getActive().getDef() - atk);
      }
   }
}
   
       
