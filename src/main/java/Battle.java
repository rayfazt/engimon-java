import java.util.ArrayList;
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
        System.out.print("Enemy Engimon's Power : " + this.powerWild);
    }

    public double battleAdvantage(Engimon engimonPlayer, Engimon engimonWild) {
        List<ElementType> elementsPlayer = engimonPlayer.getElements();
        List<ElementType> elementsWild = engimonWild.getElements();

        double maxAdv = 0;
        for (ElementType elementPlayer : elementsPlayer) {
            Element elP = new Element(elementPlayer);
            for (ElementType elementWild : elementsWild) {
                double currAdv = elP.getAdvantage(elementWild);
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

    public void commenceBattle() {
        boolean playerWin = false;

        if (this.powerPlayer >= this.powerWild) {
            playerWin = true;
        }

        System.out.println("Tes");

        if (playerWin) {
            // Jika engimon player menang, player akan mendapatkan engimon yang menjadi lawan jika inventory masih cukup.
            // Active engimon juga akan menerima experience point dengan besaran yang bebas (boleh statik atau menggunakan rumus tertentu).
            // Player juga akan mendapatkan Skill Item yang berada skill di slot pertama dari engimon musuh.
        }
        else {
            int newLife = this.engimonPlayer.getLife() - 1;
            this.engimonPlayer.setLife(newLife);
        }
    }

    public static void main(String[] args) {
        Player a = new Player();
        WildEngimon w = new WildEngimon();
        Battle b = new Battle(a, w);
    }

}
