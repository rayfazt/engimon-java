import java.util.*;

public class Player {
    private Point location;
    private char icon;
    private Engimon activeEngimon;
    private Inventory<SkillItem> listSkill;
    private Inventory<Engimon> listEngimon;

    public Player() {
        // default constructor
        location = new Point();
        icon = 'P';
        activeEngimon = new Engimon();
        listSkill = new Inventory<SkillItem>();
        listEngimon = new Inventory<Engimon>();
    }

    // Getter & Setter location
    public Point getPlayerLocation() {
        return this.location;
    }
    public void setPlayerLocation(Point p) {
        // if (p.getX() < 0 || p.getX() > 9 || p.getY() < 0 || p.getY() > 11) {
        //     throw "Tidak bisa keluar dari map";
        // }
        this.location.setX(p.getX());
        this.location.setY(p.getY());
    }

    // Getter & Setter icon
    public char getIcon() {
        return this.icon;
    }
    public void setIcon(char icon) {
        this.icon = icon;
    }

    public void move(char dir) {

    }

    public Engimon getActiveEngimon() {
        return this.activeEngimon;
    }

    public void setActiveEngimon(Engimon engi) {

    }

    public void breed(Engimon e1, Engimon e2) {

    }
    
    public ArrayList<SkillItem> getSkillItemInventory() {
        return this.listSkill.getInventoryList();
    }
    public ArrayList<Engimon> getEngimonInventory() {
        return this.listEngimon.getInventoryList();
    }

    public void addSkillItem(SkillItem sk) {
        getSkillItemInventory().add(sk);
    }
    public void addEngimon(Engimon engi) {
        getEngimonInventory().add(engi);
    }

    public void printListEngimon() {
        listEngimon.printInventory();
    }
    public void printDataEngimon(Engimon engi) {
        engi.printInfo();
    }
    public void printListSkillItem() {
        listSkill.printInventory();
    }
    public void printActiveEngimon() {
        this.getActiveEngimon().printInfo();
    }
    public void interact() {
        System.out.println(this.getActiveEngimon().getName()+": "+this.getActiveEngimon().getTeksUnik());
    }

    public void replaceSkillEngimon(Engimon engi, Skill skillLama, Skill skillBaru) {
        //
    }
    public void useSkillItem(Engimon engi, Skill s) {
        // 
    }
    

}