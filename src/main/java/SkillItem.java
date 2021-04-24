public class SkillItem extends InventoryItem {
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
    public void printInfo() {
        System.out.println("Skill: "+ this.getSkill().getSkillName());
        System.out.println("Jumlah: "+ this.getSkillAmount());
    }
    public Skill getSkill() {
        return this.skill;
    }
    public int getSkillAmount() {
        return this.amount;
    } 
}