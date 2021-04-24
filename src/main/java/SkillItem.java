import java.util.Comparator;
public class SkillItem {
    private Skill skill;
    private int amount;

    public SkillItem() {
        Skill defaultSkill = new Skill();
        this.skill = defaultSkill;
        this.amount = 1;
    }
    public SkillItem(Skill skill, int amount) {
        this.skill = skill;
        this.amount = amount;
    }
    public void addSkillItem(int amount) {
        this.amount += amount;
    }
    public void delSkillItem(int amount) {
        this.amount -= amount;
    }
    @Override
    public String toString() {
        return "Skill: " + this.getSkill().getSkillName() + "\n Jumlah: "+this.getSkillAmount();
    }
    // public void printInfo() {
    //     System.out.println("Skill: "+ this.getSkill().getSkillName());
    //     System.out.println("Jumlah: "+ this.getSkillAmount());
    // }
    public Skill getSkill() {
        return this.skill;
    }
    public int getSkillAmount() {
        return this.amount;
    } 

    public static Comparator<SkillItem> skillItemComparator = new Comparator<SkillItem>() {

        @Override
        public int compare(SkillItem s1, SkillItem s2) {
            Integer basePower1 = s1.getSkill().getBasePower();
            Integer basePower2 = s2.getSkill().getBasePower();

           //ascending order
           //return StudentName1.compareTo(StudentName2);
    
           // descending order
           return basePower2.compareTo(basePower1);
        }};
}