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
    public void setPlayerLocation(Point p) throws OutOfMapException{
        if (p.getX() < 0 || p.getX() > 9 || p.getY() < 0 || p.getY() > 11) // NOTE : angkanya nyesuain map
        {
            throw new OutOfMapException("Tidak bisa keluar dari map"); // ini kyknya diganti sama kelas exception
        }
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
        if (dir == 'w') {
            try
            {
                int x = getPlayerLocation().getX();
                int y = getPlayerLocation().getY() - 1;
                Point p = new Point(); // NOTE : ini blm  fix karena blum nyesuain ke map nya
                setPlayerLocation(p); // Kalo ga valid dia throw
            }
            catch(OutOfMapException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else if (dir == 'a') {
            try
            {
                int x = getPlayerLocation().getX() - 1;
                int y = getPlayerLocation().getY();
                Point p = new Point();
                setPlayerLocation(p);
            }
            catch(OutOfMapException e)
            {
                System.out.println(e.getMessage());
            }      
        }
        else if (dir == 's') {
            try
            {
                int x = getPlayerLocation().getX();
                int y = getPlayerLocation().getY() + 1;
                Point p = new Point();
                setPlayerLocation(p);            
            }
            catch(OutOfMapException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else if (dir == 'd') {
            try
            {
                int x = getPlayerLocation().getX() + 1;
                int y = getPlayerLocation().getY();
                Point p = new Point(); 
                setPlayerLocation(p);            
            }
            catch(OutOfMapException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public Engimon getActiveEngimon() {
        return this.activeEngimon;
    }

    public void setActiveEngimon(Engimon engi) {
        // Cari engimon
        bool found = false;
        List<Engimon> listEngimon = this.getEngimonInventory();
        
        for (Engimon engimon : listEngimon) {
            if (engimon.getName().equals(engi.getName())){
                found = true;
            }
        }
        if (!found) {
            System.out.println("Engimon pilihan tidak ada di dalam inventory");;
        }
        else {
            // tambahin current active engimon ke inventory
            listEngimon.addItem(this.getActiveEngimon());
            // remove active engimon yang baru dari inventory
            listEngimon.removeItem(engi);
            // set active engimon baru
            this.activeEngimon = engi;
        }
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
        listSkill.delItem(s);
        // engimon learn skill
    }
}