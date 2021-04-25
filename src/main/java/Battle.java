import java.util.*;

public class Battle {
    private Player player;
    private PlayerEngimon engimonPlayer;
    private WildEngimon engimonWild;
    private int levelPlayer;
    private int levelWild;
    private double powerPlayer;
    private double powerWild;
    private double advantagePlayer;
    private double advantageWild;

    public Battle(Player player, WildEngimon engimonWild) {
        this.player = player;
        this.engimonPlayer = player.getActiveEngimon();
        this.engimonWild = engimonWild;
        this.levelPlayer = this.engimonPlayer.getLevel();
        this.levelWild = engimonWild.getLevel();
        this.advantagePlayer = battleAdvantage(this.engimonPlayer, engimonWild);
        this.advantageWild = battleAdvantage(engimonWild, this.engimonPlayer);
        this.powerPlayer = getPower(this.levelPlayer, this.advantagePlayer, this.engimonPlayer);
        this.powerWild = getPower(this.levelWild, this.advantageWild, engimonWild);

        printInfoBattle();
    }

    public void printInfoBattle() {
        System.out.println("==========YOUR ENGIMON==========");
        this.player.getActiveEngimon().printInfo();
        System.out.println("==========ENEMY ENGIMON==========");
        this.engimonWild.printInfo();
        System.out.println("!!!!!!!!!!POWER COMPARISON!!!!!!!!!!");
        System.out.println("Your Engimon's Power : " + this.powerPlayer);
        System.out.println("Enemy Engimon's Power : " + this.powerWild);

    }

//    @Override
//    public String toString() {
//        return "Battle{" +
//                "player=" + player +
//                ", engimonPlayer=" + engimonPlayer +
//                ", engimonWild=" + engimonWild +
//                ", levelPlayer=" + levelPlayer +
//                ", levelWild=" + levelWild +
//                ", powerPlayer=" + powerPlayer +
//                ", powerWild=" + powerWild +
//                ", advantagePlayer=" + advantagePlayer +
//                ", advantageWild=" + advantageWild +
//                '}';
//    }

    public String getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to commence battle(y/n)?");
        String choice = sc.nextLine();

        return choice;
    }

    public double battleAdvantage(Engimon engimonPlayer, Engimon engimonWild) {
        List<ElementType> elementsPlayer = engimonPlayer.getElements();
        List<ElementType> elementsWild = engimonWild.getElements();

        double maxAdv = 0;
        double currAdv;
        for (ElementType elementPlayer : elementsPlayer) {
            Element elP = new Element(elementPlayer);
            for (ElementType elementWild : elementsWild) {
                currAdv = elP.getAdvantage(elementWild);
                if (currAdv > maxAdv) {
                    maxAdv = currAdv;
                }
            }
        }

        return maxAdv;
    }

    public double getPower(int level, double advantage, Engimon e) {
        List<Skill> skills = e.getSkills();
        int base;
        int mastery;
        int sumSkill = 0;

        for (Skill skill : skills) {
            base = skill.getBasePower();
            mastery = skill.getMasteryLevel();
            sumSkill += base * mastery;
        }

        double power = level * advantage + sumSkill;

        return power;
    }

    public void increaseExp() {
        //  Exp +40
        int newExp = this.engimonPlayer.getCurrExp() + 40;
        this.engimonPlayer.setCurrExp(newExp);
        if (newExp % (this.engimonPlayer.getLevel() * 100) != 0 || newExp == this.engimonPlayer.getLevel() * 100) {
            this.engimonPlayer.updateEngimonLevel();
        }
        System.out.println("Current " + this.engimonPlayer.getName() + " exp : " + this.engimonPlayer.getCurrExp());
        System.out.println("Current " + this.engimonPlayer.getName() + " level : " + this.engimonPlayer.getLevel());
    }

    public void addEngimon() {
        PlayerEngimon e = new PlayerEngimon(this.engimonWild);
        if (!this.player.isCapacityFull()) {
            this.player.addEngimon(e);
            System.out.println(this.engimonWild.getName() + " has been added to Inventory");
        }
        else {
            System.out.print("Inventory full, cannot add Engimon");
        }
    }

    public void loseBattle() {
        int newLife = this.engimonPlayer.getLife() - 1;
        this.engimonPlayer.setLife(newLife);
        if (newLife == 0) {
            System.out.println("Commiserations. Your " + this.engimonPlayer.getName() + " has reached 0 life");
            this.player.delEngimon(this.engimonPlayer);
        }
    }

    public boolean commenceBattle() {
        boolean playerWin = false;

        if (this.powerPlayer >= this.powerWild) {
            playerWin = true;
        }

        if (playerWin) {
            // Player juga akan mendapatkan Skill Item yang berada skill di slot pertama dari engimon musuh.
            System.out.println("Your " + this.engimonPlayer.getName() + " won! Wild " + this.engimonWild.getName() + " fainted");
            increaseExp();
            addEngimon();

        }
        else {
            System.out.print("Wild " + this.engimonWild.getName() + " won! Your " + this.engimonPlayer.getName() + " fainted");
            loseBattle();
        }

        return playerWin;
    }

//    public static void main(String[] args) {
//        Player a = new Player();
//        WildEngimon w = new WildEngimon();
//        WildEngimon x = new WildEngimon();
//        WildEngimon y = new WildEngimon();
//        WildEngimon z = new WildEngimon();
//        WildEngimon f = new WildEngimon();
////        WildEngimon g = new WildEngimon();
////        WildEngimon h = new WildEngimon();
////        WildEngimon i = new WildEngimon();
////        WildEngimon j = new WildEngimon();
////        WildEngimon k = new WildEngimon();
//        Battle b = new Battle(a,w);
//        Battle b1 = new Battle(a,x);
//        Battle b2 = new Battle(a,y);
//        Battle b3 = new Battle(a,z);
//        Battle b4 = new Battle(a,f);
////        Battle b5 = new Battle(a,g);
////        Battle b6 = new Battle(a,h);
////        Battle b7 = new Battle(a,i);
////        Battle b8 = new Battle(a,j);
////        Battle b9 = new Battle(a,k);
//        String choice = b.getChoice();
//        while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
//            System.out.println("Invalid input");
//            choice = b.getChoice();
//        }
//        if (choice.equalsIgnoreCase("y")) {
//            Boolean battlez = b.commenceBattle();
//            battlez = b1.commenceBattle();
//            battlez = b2.commenceBattle();
//            battlez = b3.commenceBattle();
//            battlez = b4.commenceBattle();
//        }
//        else if (choice.equalsIgnoreCase("n")) {
//            System.out.println("Battle aborted");
//        }
////        battlez = b5.commenceBattle();
////        battlez = b6.commenceBattle();
////        battlez = b7.commenceBattle();
////        battlez = b8.commenceBattle();
////        battlez = b9.commenceBattle();
//    }

}
