public class PlayerEngimon extends Engimon{
    protected int life;
    protected EngimonStatus status;
    protected boolean active;

    public PlayerEngimon(){
        super();
        this.life = 3;
        this.status = EngimonStatus.PLAYER;
        this.active = false;
    }

    public PlayerEngimon(String name_, Species species_, String namaPapa_, String namaMama,
                       Skill skill_, int X_, int Y_){
        super(name_, species_, namaPapa_, namaMama, skill_, X_, Y_);
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
        System.out.println("Skill(s): " + this.skills.get(0).getSkillName());
        System.out.println("Element(s): " + this.elements);
        System.out.println("Level: " + this.level);
        System.out.println("Current EXP: " + this.currExp);
        System.out.println("Max EXP: " + this.maxExp);
        System.out.println("X: " + this.location.getX());
        System.out.println("Y: " + this.location.getY());
        System.out.println("Icon: " + this.icon);
        System.out.println("Life: " + this.life);
        System.out.println("Status: " + this.status);
    }
    public static void main(String args[]){
        PlayerEngimon A = new PlayerEngimon();
        A.printInfo();
        System.out.println("NEW ENGIMON");
        Skill defSkill = new Skill();
        PlayerEngimon B = new PlayerEngimon("Haihai", Species.Mudtle, "New Daddy", "New Mommy",
                defSkill,1, 1);
        B.printInfo();
    }
}
