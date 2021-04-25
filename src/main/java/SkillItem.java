import java.util.Comparator;
public class SkillItem {
    private Skill skill;
    private int skillAmount;

    public SkillItem() {
        Skill defaultSkill = new Skill();
        this.skill = defaultSkill;
        this.skillAmount = 1;
    }
    public SkillItem(Skill skill, int amount) {
        this.skill = skill;
        this.skillAmount = amount;
    }
    public void addSkillItem(int amount) {
        this.skillAmount += amount;
    }
    public void delSkillItem(int amount) {
        this.skillAmount -= amount;
    }
    @Override
    public String toString() {
        return "Skill: " + this.getSkill().getSkillName() + "\nJumlah: "+this.getSkillAmount();
    }
    // public void printInfo() {
    //     System.out.println("Skill: "+ this.getSkill().getSkillName());
    //     System.out.println("Jumlah: "+ this.getSkillAmount());
    // }
    public Skill getSkill() {
        return this.skill;
    }
    public int getSkillAmount() {
        return this.skillAmount;
    }
    public void addSkillAmount(int x) {
        this.skillAmount += x;
    }
    public void subSkillAmount(int x) {
        this.skillAmount -= x;
    }

    public static Comparator<SkillItem> skillItemComparator = new Comparator<SkillItem>() {

        @Override
        public int compare(SkillItem s1, SkillItem s2) {
            Integer basePower1 = s1.getSkill().getBasePower();
            Integer basePower2 = s2.getSkill().getBasePower();
    
           // descending order
           return basePower2.compareTo(basePower1);
        }};

    public static void main(String[] args) {
        SkillItem a = new SkillItem();
        System.out.println(a.toString());

    }
}