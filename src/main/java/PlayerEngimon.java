import java.util.ArrayList;

public class PlayerEngimon extends Engimon{
    protected int life;
    protected EngimonStatus status;
    protected boolean active;

    public PlayerEngimon(){
        super();
        this.life = 3;
        this.status = EngimonStatus.PLAYER;
        this.active = false;
        this.imagePath = ""; // TODO image buat playerEngimon
    }

    public PlayerEngimon(String name_, Species species_, String namaPapa_, String namaMama,
                         ArrayList<Skill> skill_, int X_, int Y_){
        super(name_, species_, namaPapa_, namaMama, skill_, X_, Y_);
        this.life = 3;
        this.status = EngimonStatus.PLAYER;
        this.active = false;
        this.imagePath = this.getSpeciesName().toString()+"Player.png";
    }

    public PlayerEngimon(String name_, Species speciesName_, String namaPapa, String namaMama,
                         Species speciesPapa, Species speciesMama, ArrayList<Skill> skill_, int X_, int Y_){
        super(name_, speciesName_, namaPapa, namaMama, speciesPapa, speciesMama, skill_, X_, Y_);
        this.life = 3;
        this.status = EngimonStatus.PLAYER;
        this.active = false;
        this.imagePath = this.getSpeciesName().toString()+"Player.png";
    }

    public PlayerEngimon(WildEngimon wEngimon){
        super(wEngimon.getName(), wEngimon.getSpeciesName(), wEngimon.getNamaPapa(), wEngimon.getNamaMama(), wEngimon.getSkills(), wEngimon.getX(), wEngimon.getY());
        this.life = 3;
        this.status = EngimonStatus.PLAYER;
        this.active = false;
        this.imagePath = this.getSpeciesName().toString()+"Player.png";
    }

    // Setter & Getter life
    public void setLife(int newLife){
        this.life = newLife;
    }
    public int getLife(){
        return this.life;
    }

    // Getter Status
    public EngimonStatus getStatus(){
        return this.status;
    }

    // Setter & Getter active
    public void setActiveTrue(){
        this.active = true;
    }
    public void setActiveFalse(){
        this.active = false;
    }
    public boolean getActive(){
        return this.active;
    }

    // Getter Image Path
    public String getImagePath(){
        return this.imagePath;
    }

    @Override
    public void printInfo() {
        System.out.println("Engimon Name: " + this.name);
        System.out.println("Species: " + this.speciesName);
        System.out.println("TeksUnik: " + this.teksUnik);
        System.out.println("Parent: " + this.parent);
        System.out.print("Skill(s): ");
        for (int i = 0; i < this.skills.size(); i++){
            if (i != this.skills.size()-1){
                System.out.print(this.skills.get(i).getSkillName()+" (lv. " + this.skills.get(i).getMasteryLevel() + ")" +", ");
            }
            else{
                System.out.print(this.skills.get(i).getSkillName()+" (lv. " + this.skills.get(i).getMasteryLevel() + ")");
            }

        }
        System.out.println();

        System.out.print("Element(s): ");
        for (int i = 0; i < this.elements.size(); i++){
            if (i != this.elements.size()-1){
                System.out.print(this.elements.get(i)+", ");
            }
            else{
                System.out.print(this.elements.get(i));
            }

        }
        System.out.println();

        System.out.println("Level: " + this.level);
        System.out.println("Current EXP: " + this.currExp);
        System.out.println("Max EXP: " + this.maxExp);
        System.out.println("X: " + this.location.getX());
        System.out.println("Y: " + this.location.getY());
        System.out.println("Icon: " + this.icon);
        System.out.println("Life: " + this.life);
        System.out.println("Status: " + this.status);
    }

    public String printInfoTooltip(){
        String info = new String();
        info = info + ("Engimon Name: " + getName().toString() + "\n");
        info = info + ("Species: " + getSpeciesName() + "\n");
        info = info + ("TeksUnik: " + getTeksUnik().toString() + "\n");
        info = info + ("Parent: " + "Parent1: " + getNamaPapa().toString()+ ", Species1: " + getSpeciesPapa().toString()
        + ". Parent2: " + getNamaMama().toString() + ", Species2: " + getSpeciesMama() + "\n");
        info = info + ("Skill(s): ");
        for (int i = 0; i < this.skills.size(); i++){
            if (i != this.skills.size()-1){
                info = info + (this.skills.get(i).getSkillName()+" (lv. " + this.skills.get(i).getMasteryLevel() + ")" +", ");
            }
            else{
                info = info + (this.skills.get(i).getSkillName()+" (lv. " + this.skills.get(i).getMasteryLevel() + ")\n");
            }

        }

        info = info + ("Element(s): ");
        for (int i = 0; i < this.elements.size(); i++){
            if (i != this.elements.size()-1){
                info = info + (this.elements.get(i).toString()+", ");
            }
            else{
                info = info + (this.elements.get(i).toString() + "\n");
            }

        }

        info = info + ("Level: " + getLevel() + "\n");
        info = info + ("Current EXP: " + getCurrExp() + "\n");
        info = info + ("Max EXP: " + this.maxExp + "\n");
        info = info + ("X: " + this.location.getX() + "\n");
        info = info + ("Y: " + this.location.getY() + "\n");
        info = info + ("Icon: " + this.icon + "\n");
        info = info + ("Life: " + this.life + "\n");
        info = info + ("Status: " + this.status + "\n");
        info = info + ("Active: " + this.active + "\n");

        return info;
    }

    @Override
    public String toString() {
        String engimonString = super.toString();
        return engimonString + "\nPlayer Engimon" +
                "\nlife=" + life +
                ",\nstatus=" + status +
                ",\n active=" + active;
    }


        public static void main(String args[]){
//        PlayerEngimon A = new PlayerEngimon();
//        A.printInfo();
//        System.out.println("NEW ENGIMON");
//        ArrayList<Skill> skill__ = new ArrayList<Skill>();
//        Skill defSkill = new Skill();
//        skill__.add(defSkill);
//        PlayerEngimon B = new PlayerEngimon("Haihai", Species.Mudtle, "New Daddy", "New Mommy",
//                skill__,1, 1);
//        B.printInfo();

        WildEngimon A = new WildEngimon();
        A.printInfo();
        System.out.println("CONVERT");
        PlayerEngimon B = new PlayerEngimon();
        B.printInfo();
        double adv = B.battleAdvantage(A);
        double pwr = B.getPower(adv);
        System.out.println("Power: "+ pwr);
    }
}
