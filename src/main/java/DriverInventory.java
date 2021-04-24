public class DriverInventory {
    public static void main(String[] args) {
        SkillItem skill1 = new SkillItem();
        SkillItem skill2 = new SkillItem();
        SkillItem skill3 = new SkillItem();
        Inventory<SkillItem> invSkill = new Inventory<SkillItem>();
        invSkill.addItem(skill1);
        invSkill.addItem(skill2);
        invSkill.addItem(skill3);

        Engimon e1 = new Engimon();
        Engimon e2 = new Engimon();
        Engimon e3 = new Engimon();
        Inventory<Engimon> invEngimon = new Inventory<Engimon>();
        invEngimon.addItem(e1);
        invEngimon.addItem(e2);
        invEngimon.addItem(e3);
    }
    // javac Engimon.java Skill.java SkillItem.java InventoryItem.java Inventory.java DriverInventory.java
}