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
    }
    public PlayerEngimon(WildEngimon wEngimon){
        super(wEngimon.getName(), wEngimon.getSpeciesName(), wEngimon.getNamaPapa(), wEngimon.getNamaMama(), wEngimon.getSkills(), wEngimon.getX(), wEngimon.getY());
        this.life = 3;
        this.status = EngimonStatus.PLAYER;
        this.active = false;
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

    @Override
    public String toString() {
        String engimonString = super.toString();
        return engimonString + "\nPlayerEngimon{" +
                "life=" + life +
                ", status=" + status +
                ", active=" + active +
                '}';
    }

    //    public static void main(String args[]){
////        PlayerEngimon A = new PlayerEngimon();
////        A.printInfo();
////        System.out.println("NEW ENGIMON");
////        ArrayList<Skill> skill__ = new ArrayList<Skill>();
////        Skill defSkill = new Skill();
////        skill__.add(defSkill);
////        PlayerEngimon B = new PlayerEngimon("Haihai", Species.Mudtle, "New Daddy", "New Mommy",
////                skill__,1, 1);
////        B.printInfo();
//
//        WildEngimon A = new WildEngimon();
//        A.printInfo();
//        System.out.println("CONVERT");
//        PlayerEngimon B = new PlayerEngimon();
//        B.printInfo();
//    }
}
